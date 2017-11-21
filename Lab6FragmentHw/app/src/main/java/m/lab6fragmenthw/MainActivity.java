package m.lab6fragmenthw;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements QuizListFragment.Comm {
    QuizListFragment ql;
    StartFragment s;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= getFragmentManager();

        ql = (QuizListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ql.setComm(this);
    }

public void respond (String data){
    StartFragment f =(StartFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
   if (f!=null && f.isVisible()){

       f.changeData(data);

   }else{
       Intent i = new Intent(this,phoneSeconed.class);
       i.putExtra("Type",data);
        startActivity(i);

   }



}
}
