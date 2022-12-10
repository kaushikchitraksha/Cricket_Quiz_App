package com.example.quiz_app;

public class Quiz {
    private String question;
    private int imageRid;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    public Quiz(String nQuestion,int ImageId ,String nOption1, String nOption2, String nOption3, String nOption4, String nAnswer){
        question = nQuestion;
        imageRid = ImageId;
        option1 = nOption1;
        option2 = nOption2;
        option3 = nOption3;
        option4 = nOption4;
        answer = nAnswer;
    }

    public String getQuestion() {
        return question;
    }
    public int getImageRid(){
        return imageRid;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }
}
