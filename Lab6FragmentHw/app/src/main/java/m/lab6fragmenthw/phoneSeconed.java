package m.lab6fragmenthw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class phoneSeconed extends AppCompatActivity {
String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_seconed);


        Intent i = getIntent();
         type = i.getStringExtra("Type");

        StartFragment stf = (StartFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if(stf!=null)
        stf.changeData(type);

    }


}
