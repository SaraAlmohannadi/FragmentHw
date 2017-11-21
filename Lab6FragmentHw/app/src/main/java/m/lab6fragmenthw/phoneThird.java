package m.lab6fragmenthw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class phoneThird extends AppCompatActivity {
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_third);

        Intent i = getIntent();
        score = i.getIntExtra("Score",0);

        FinishFragment stf = (FinishFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if(stf!=null)
            stf.DisplayScore(score);
    }
}
