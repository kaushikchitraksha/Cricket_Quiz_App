package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView numberOfQuestions,Questions,option1btn,option2btn,option3btn,option4btn,next_btn;
    private ImageView imageView;
    boolean flag = false;

    //Creating ArrayList to Store Data Type of Array list is of Quiz Data type
    private ArrayList<Quiz> quizzesArrayList;

    //Random class is used to generate random numbers.
    Random random;
    int currentScore = 0, questionAttempted = 0, onQuestion = 1,currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Questions = (TextView) findViewById(R.id.Questions);
        numberOfQuestions = (TextView) findViewById(R.id.NumOfAttempt);
        imageView = (ImageView) findViewById(R.id.Image_Id);
        option1btn = (TextView) findViewById(R.id.Btn_Op1);
        option2btn = (TextView) findViewById(R.id.Btn_Op2);
        option3btn = (TextView) findViewById(R.id.Btn_Op3);
        option4btn = (TextView) findViewById(R.id.Btn_Op4);
        next_btn = (TextView) findViewById(R.id.Btn_Next);
        quizzesArrayList = new ArrayList<>();

        // Adding Data to ArrayList

        quizzesArrayList.add(new Quiz(" What does the cricket umpire signal below mean",R.drawable.img1,"Penalty runs","Four runs","Short run","Six runs","Six runs"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img2,"Bye","Short run","Four runs","Out","Short run"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img3,"Wide ball","Four runs","Six runs","No ball","No ball"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img4,"Short run","Out","New ball","Bye","Bye"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img5,"Wide ball","Short run","No ball","Out","Wide ball"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img6,"Bye","No ball","New ball","Out","Out"));
        quizzesArrayList.add(new Quiz(" What does the cricket umpire signal below mean",R.drawable.img7,"Penalty runs","Four runs","Short run","Six runs","Four runs"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img8,"Bye","Dead ball","No ball","Penalty runs","Penalty runs"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img9,"Cancel call","Dead ball","New ball","Bye","Dead ball"));
        quizzesArrayList.add(new Quiz("What does the cricket umpire signal below mean?",R.drawable.img10,"New ball","Short run","No ball","Out","New ball"));

        random = new Random();

        //Selecting a random number for some random index in ArrayList

        currentPosition = random.nextInt(quizzesArrayList.size());
        setData(currentPosition);

        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Setting the background resource for Button
                option1btn.setBackgroundResource(R.drawable.custom_2);
                option2btn.setBackgroundResource(R.drawable.custom);
                option3btn.setBackgroundResource(R.drawable.custom);
                option4btn.setBackgroundResource(R.drawable.custom);

                //flag to check either we selected a option or not
                flag = true;

                // Checking if the Selected Answer is correct or not if its is correct then
                // Increasing the current score

                if(quizzesArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option1btn.getText().toString().toString().trim().toLowerCase())){
                    currentScore++;
                }
            }
        });
        option2btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Setting the background resource for Button
                option2btn.setBackgroundResource(R.drawable.custom_2);
                option1btn.setBackgroundResource(R.drawable.custom);
                option3btn.setBackgroundResource(R.drawable.custom);
                option4btn.setBackgroundResource(R.drawable.custom);

                //flag to check either we selected a option or not
                flag = true;

                // Checking if the Selected Answer is correct or not if its is correct then
                // Increasing the current score

                if(quizzesArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option2btn.getText().toString().toString().trim().toLowerCase())){
                    currentScore++;
                }
            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option3btn.setBackgroundResource(R.drawable.custom_2);
                option1btn.setBackgroundResource(R.drawable.custom);
                option2btn.setBackgroundResource(R.drawable.custom);
                option4btn.setBackgroundResource(R.drawable.custom);

                //flag to check either we selected a option or not
                flag = true;

                // Checking if the Selected Answer is correct or not if its is correct then
                // Increasing the current score

                if(quizzesArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().toString().trim().toLowerCase())){
                    currentScore++;
                }
            }
        });
        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option4btn.setBackgroundResource(R.drawable.custom_2);
                option1btn.setBackgroundResource(R.drawable.custom);
                option2btn.setBackgroundResource(R.drawable.custom);
                option3btn.setBackgroundResource(R.drawable.custom);

                //flag to check either we selected a option or not
                flag = true;

                // Checking if the Selected Answer is correct or not if its is correct then
                // Increasing the current score

                if(quizzesArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(option4btn.getText().toString().toString().trim().toLowerCase())){
                    currentScore++;
                }
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    flag = false;
                    option1btn.setBackgroundResource(R.drawable.custom);
                    option2btn.setBackgroundResource(R.drawable.custom);
                    option3btn.setBackgroundResource(R.drawable.custom);
                    option4btn.setBackgroundResource(R.drawable.custom);
                    onQuestion += 1;
                    if (onQuestion == 6) {
                        onQuestion = 5;
                    }
                    questionAttempted++;
                    currentPosition = random.nextInt(quizzesArrayList.size());
                    setData(currentPosition);
                }else{
                    Toast.makeText(MainActivity.this, "Question not Answered", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    // Function is created to show the Result of the Quiz using BottomSheetDialog
    private void showScoreSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

        //Creating View to access the views of score_sheet Layout
        //LayoutInflater class is used to instantiate the contents of layout XML files into their corresponding View objects
        //it takes an XML file as input and builds the View objects from it.

        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_sheet,(LinearLayout)findViewById(R.id.ScoreSheet));

        TextView scoreTv = bottomSheetView.findViewById(R.id.Score);
        scoreTv.setText("Your Score is \n"+currentScore+"/5");
        Button restartButton = bottomSheetView.findViewById(R.id.restartBtn);

        //seating onClickListener of restartButton to restart the quiz

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = random.nextInt(quizzesArrayList.size());
                setData(currentPosition);
                questionAttempted = 0;
                onQuestion = 1;
                currentScore = 0;
                next_btn.setText("Next");
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false); //to will prevent the bottom sheet dismiss on back press also
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    private void setData(int currentPosition){

        // for the counter to show how many questions are there

        numberOfQuestions.setText(onQuestion+" /5");
        //Checking condition to change the next button to Submit button
        if(onQuestion==5){
            next_btn.setText("Submit");
        }
        if(questionAttempted==5){
            showScoreSheet();
        }
        else {
            //setting the Data for layout using the method we Create in Quiz class
            //Get methods to extract data from ArrayList
            Questions.setText(quizzesArrayList.get(currentPosition).getQuestion());
            imageView.setImageResource(quizzesArrayList.get(currentPosition).getImageRid());
            option1btn.setText(quizzesArrayList.get(currentPosition).getOption1());
            option2btn.setText(quizzesArrayList.get(currentPosition).getOption2());
            option3btn.setText(quizzesArrayList.get(currentPosition).getOption3());
            option4btn.setText(quizzesArrayList.get(currentPosition).getOption4());
        }


    }
}