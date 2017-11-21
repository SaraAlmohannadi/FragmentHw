package m.lab6fragmenthw;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;


public class QuizListFragment extends Fragment {
ListView mylist;
    String quizType[] ={"Science","Math"};
      Comm c;
    public QuizListFragment() {
        // Required empty public constructor
    }




public void setComm(Comm comm){

    this.c=comm;
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz_list, container, false);
        mylist = (ListView) v.findViewById(R.id.List1);
        mylist.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,quizType));
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String name = (String) parent.getItemAtPosition(position);

                if (name.equals("Math"))
                c.respond("Math");
                else
                    c.respond("Science");

            }
        });
         return v;

    }

    interface Comm{

        public void respond(String data);
    }

}
