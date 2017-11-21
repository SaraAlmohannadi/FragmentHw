package m.lab6fragmenthw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MathQFragment extends Fragment {
    int numq =0,numch=0,numans=0,score=0;
    String answer;
    MathQFragment.Comm c;


    TextView t1,vscore;
    RadioButton ans1,ans2,ans3,ans4;
    Button bnext,bprev,bfin;

    View seletedRadio;
    MathData q = new MathData();
    RadioGroup radioGroup;
    public MathQFragment() {
        // Required empty public constructor
    }
    public void setComm(MathQFragment.Comm comm){

        this.c=comm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_sci_q, container, false);

        t1 = (TextView) v.findViewById(R.id.textView1);
        vscore = (TextView) v.findViewById(R.id.scoreView);
        ans1 = (RadioButton) v.findViewById(R.id.radioButton);
        ans2 = (RadioButton) v.findViewById(R.id.radioButton2);
        ans3 = (RadioButton) v.findViewById(R.id.radioButton3);
        ans4 = (RadioButton) v.findViewById(R.id.radioButton4);
        seletedRadio= v.findViewById(R.id.radioButton);
        bnext = (Button)v.findViewById(R.id.nextButton);
        bprev = (Button)v.findViewById(R.id.prevButton);
        bfin = (Button)v.findViewById(R.id.finButton);
        if (savedInstanceState!=null){
            numq = savedInstanceState.getInt("qnum");
            numch = savedInstanceState.getInt("chnum");
            score = savedInstanceState.getInt("theScore");
            numans = savedInstanceState.getInt("ansnum");
            answer = savedInstanceState.getString("theAnswer");
            vscore.setText("Score:" + "" + score);


        }else{
            t1.setText(q.Question(numq));
            ans1.setText(q.choiceOne(numch));
            ans2.setText(q.choiceTwo(numch));
            ans3.setText(q.choiceThree(numch));
            ans4.setText(q.choiceFour(numch));
            answer = q.getCorrectAnswer(numans);
            vscore.setText("Score:" + "" + score);

        }


        bprev.setVisibility(View.GONE);
        bfin.setVisibility(View.GONE);

        startQuiz();
        radioGroup = (RadioGroup) v.findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.radioButton: {
                        if (ans1.getText() == answer) {
                            score = score + 1;
                            vscore.setText("Score:" + "" + score);
                            ans2.setEnabled(false);
                            ans1.setEnabled(false);
                            ans4.setEnabled(false);
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    }


                    case R.id.radioButton2: {

                        if (ans2.getText() == answer) {
                            score = score + 1;
                            vscore.setText("Score:" + "" + score);
                            ans3.setEnabled(false);
                            ans2.setEnabled(false);
                            ans4.setEnabled(false);
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    }

                    case R.id.radioButton3: {

                        if (ans3.getText() == answer) {
                            score = score + 1;
                            vscore.setText("Score:" + "" + score);
                            ans3.setEnabled(false);
                            ans1.setEnabled(false);
                            ans4.setEnabled(false);
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();
                        }
                        break;


                    }
                    case R.id.radioButton4: {
                        if (ans3.getText() == answer) {
                            score = score + 1;
                            vscore.setText("Score:" + "" + score);
                            ans2.setEnabled(false);
                            ans3.setEnabled(false);
                            ans4.setEnabled(false);
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();
                        }

                        break;

                    }


                }
            }
        });

        bnext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                NextQuestion();

            }
        });

        bprev.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                prevQuestion();

            }
        });

        bfin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callFinish(v);
            }
        });



        return v;

    }



    public final void callFinish(View view ){

        c.respond(score);

    }
    public void   startQuiz() {
        ans1.setEnabled(true);
        ans2.setEnabled(true);
        ans3.setEnabled(true);
        ans4.setEnabled(true);




        if (numq <= 3 && numch <=3 && numans <= 3){

            t1.setText(q.Question(numq));
            ans1.setText(q.choiceOne(numch));
            ans2.setText(q.choiceTwo(numch));
            ans3.setText(q.choiceThree(numch));
            ans4.setText(q.choiceFour(numch));
            answer = q.getCorrectAnswer(numans);



        }else{

            bnext.setVisibility(View.GONE);
        }


    }

    public void   NextQuestion() {
        ans1.setEnabled(true);
        ans2.setEnabled(true);
        ans3.setEnabled(true);
        ans4.setEnabled(true);
        numq = numq + 1;
        numch = numch + 1;
        numans = numans + 1;

        if (numq >= 1 && numch >=1 && numans >=1){
            bprev.setVisibility(View.VISIBLE);    }



        t1.setText(q.Question(numq));
        ans1.setText(q.choiceOne(numch));
        ans2.setText(q.choiceTwo(numch));
        ans3.setText(q.choiceThree(numch));
        ans4.setText(q.choiceFour(numch));
        answer = q.getCorrectAnswer(numans);



        if (numq == 3 && numch ==3 && numans == 3){
            bnext.setVisibility(View.GONE);
            bfin.setVisibility(View.VISIBLE);

        }


    }


    public void   prevQuestion() {
        bnext.setVisibility(View.VISIBLE);
        bfin.setVisibility(View.GONE);

        ans1.setEnabled(true);
        ans2.setEnabled(true);
        ans3.setEnabled(true);
        ans4.setEnabled(true);
        numq = numq - 1;
        numch = numch - 1;
        numans = numans - 1;

        if (numq > 1 && numch >1 && numans >1){
            bprev.setVisibility(View.VISIBLE);    }



        t1.setText(q.Question(numq));
        ans1.setText(q.choiceOne(numch));
        ans2.setText(q.choiceTwo(numch));
        ans3.setText(q.choiceThree(numch));
        ans4.setText(q.choiceFour(numch));
        answer = q.getCorrectAnswer(numans);






    }

    @Override
    public void onSaveInstanceState(Bundle outState) {


        outState.putInt("qnum", numq);

        outState.putInt("chnum", numch);
        outState.putInt("theScore", score);
        outState.putInt("ansnum", numans);
        outState.putString("theAnswer", answer);

        super.onSaveInstanceState(outState);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        numq = savedInstanceState.getInt("qnum");
        numch = savedInstanceState.getInt("chnum");
        score = savedInstanceState.getInt("theScore");
        numans = savedInstanceState.getInt("ansnum");
        answer = savedInstanceState.getString("theAnswer");


        t1.setText(q.Question(numq));
        ans1.setText(q.choiceOne(numch));
        ans2.setText(q.choiceTwo(numch));
        ans3.setText(q.choiceThree(numch));
        ans4.setText(q.choiceFour(numch));
        answer = q.getCorrectAnswer(numans);


    }

    interface Comm{

        public void respond(int data);
    }
}