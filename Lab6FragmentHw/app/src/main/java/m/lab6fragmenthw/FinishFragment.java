package m.lab6fragmenthw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FinishFragment extends Fragment {

    TextView t1;
    ImageView good,excellent,bad;
    public FinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_finish, container, false);



        t1 = (TextView) v.findViewById(R.id.textView1);

        bad = (ImageView)v.findViewById(R.id.imageView1);
        excellent = (ImageView)v.findViewById(R.id.imageView2);


        good = (ImageView)v.findViewById(R.id.imageView3);




        return v;


    }


    public void DisplayScore(int score){

        t1.setText("you scored "+"4/"+score);


        if (score<3){
            bad.setVisibility(View.VISIBLE);
            excellent.setVisibility(View.GONE);
            good.setVisibility(View.GONE);


        }else if (score == 3){
            good.setVisibility(View.VISIBLE);
            excellent.setVisibility(View.GONE);
            bad.setVisibility(View.GONE);

        }else{
            excellent.setVisibility(View.VISIBLE);
            bad.setVisibility(View.GONE);
            good.setVisibility(View.GONE);



        }

    }
}
