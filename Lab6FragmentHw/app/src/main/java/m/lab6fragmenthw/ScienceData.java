package m.lab6fragmenthw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScienceData  {

    public String choices[][]={
            {"Jupiter","Mars","Earth","Venus"},
            {"Hydrogen","Chlorine","Helium","Silicon"},
            {"Sirius","Sun","Vega","Polaris"},
            {"Ca","Os","H","O"}
    };


    public String[] correctAnswers={
            "Jupiter","Helium","Sun","O"

    };

    public String questions[]={"Questions 1: What is the biggest planet in our solar system?",
            "Questions 2: What is the name of the element with the chemical symbol 'He'?",
            "Questions 3: What is the name to the closest star to the earth?",
            "Questions 4: What is the chemical symbol for the element oxygen?"};





    public String choiceOne(int num){

        String choice = choices[num][0];
        return choice;
    }

    public String choiceTwo(int num){

        String choice = choices[num][1];
        return choice;
    }
    public String choiceThree(int num){

        String choice = choices[num][2];
        return choice;
    }
    public String choiceFour(int num){

        String choice = choices[num][3];
        return choice;
    }

    public String Question(int num){
        String question= questions[num];
        return question;
    }

    public String getCorrectAnswer(int num ){
        String answer = correctAnswers[num];
        return answer;
    }
}
