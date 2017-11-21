package m.lab6fragmenthw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartFragment extends Fragment {
    Button bscience, bmath;

    public StartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start, container, false);
        bmath = (Button) v.findViewById(R.id.button1);
        bscience = (Button) v.findViewById(R.id.button2);

        bmath.setVisibility(View.GONE);
        bscience.setVisibility(View.GONE);


        bmath.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SeconedActivity.class);
                i.putExtra("Type", "Math");
                startActivity(i);
            }
        });

        bscience.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SeconedActivity.class);
                i.putExtra("Type", "Science");
                startActivity(i);
            }
        });
        return v;
    }


    public void displayMathQuiz() {
        bmath.setVisibility(View.VISIBLE);


    }

    public void displayScienceQuiz() {

        bscience.setVisibility(View.VISIBLE);

    }

    public void changeData(String data) {

        if (data.equals("Math"))
            displayMathQuiz();
        else
            displayScienceQuiz();

    }


}
