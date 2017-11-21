package m.lab6fragmenthw;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeconedActivity extends AppCompatActivity implements SciQFragment.Comm,MathQFragment.Comm  {
String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconed);
FragmentManager fmanager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fmanager.beginTransaction();
       // MathQFragment mathf = new MathQFragment();
       // SciQFragment scif = new SciQFragment();

        type= getIntent().getStringExtra("Type");
        Fragment f;

        if (type.equals("Math"))
           f=   new MathQFragment();
        else
            f= new SciQFragment();

        ft.replace(R.id.fragmentfirst,f);
        ft.commit();

    }


    @Override
    public void respond(int data) {
        FinishFragment f =(FinishFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentsec);
        if (f!=null && f.isVisible()){

            f.DisplayScore(data);

        }else{
            Intent i = new Intent(this,phoneThird.class);
            i.putExtra("Score",data);
            startActivity(i);

        }





    }
}
