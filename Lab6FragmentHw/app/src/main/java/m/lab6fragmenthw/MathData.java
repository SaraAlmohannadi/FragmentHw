package m.lab6fragmenthw;


public class MathData {
    public String choices[][]={
            {"12","15","17","20"},
            {"33","65","80","14"},
            {"44","70","66","34"},
            {"86","40","21","36"}
    };

    public String[] correctAnswers={
            "17","33","70","86"

    };

    public String questions[]={"Questions 1: 12+5=","Questions 2: 27+6=","Questions 3: 55+15=","Questions 4: 46+40="};




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
