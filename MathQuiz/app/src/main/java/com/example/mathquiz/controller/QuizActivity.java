package com.example.mathquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathquiz.R;
import com.example.mathquiz.model.Question;
import com.example.mathquiz.model.QuestionAnalyzer;
import com.example.mathquiz.model.QuestionRepository;

//import java.text.NumberFormat;
//import java.text.ParseException;
//import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    //Load all the questions
    private QuestionRepository repository = new QuestionRepository();

    //declare it here
    private int index_question = 0;
    private TextView textViewTextQuestion;
    private Button buttonRepository1;
    private Button buttonRepository2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // save the state of the application
        setContentView(R.layout.activity_main);
        //R class utility R is a class to load all the view of the layout  R = resource or res
        // R is resource

        Question question = repository.getListQuestion().get(index_question);

        //findViewById
        textViewTextQuestion = findViewById(R.id.text_question_textview);
        textViewTextQuestion.setText(question.getText());

        //Listeners are interfaces that connect the buttons with his interface that we code
        //that meaning is what will happen when the button clicked.
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message;
                // final is restrict, nothing is going to replace the answer cannot be over
                final String response = ((Button)view).getText().toString();
                QuestionAnalyzer questionAnalyzer = new QuestionAnalyzer();
                // don't have constructor = create object and vice versa
                Question question = repository.getListQuestion().get(index_question);
                if (questionAnalyzer.isCorrectAnswer(question,Double.valueOf(response))){
                    message = "Congrats, Correct Answer!";
                }else{
                    message = "Ahh, Wrong Answer!";
                }
                //activity is page or view
                Toast.makeText(QuizActivity.this,message,Toast.LENGTH_SHORT).show();
                }
        };

        //Convert double to String
        buttonRepository1 = findViewById(R.id.option1_button);
        buttonRepository1.setText(String.valueOf(question.getCorrectAnswer()));
        buttonRepository1.setOnClickListener(listener);

        buttonRepository2 = findViewById(R.id.option2_button);
        buttonRepository2.setText(String.valueOf(question.getIncorrectAnswer()));
        buttonRepository2.setOnClickListener(listener);

        // --------------------------Next Question -----------------------------
        View.OnClickListener listenerNextQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index_question++;
                // when the user reaches the last question
                if (index_question >= repository.getListQuestion().size()){
                    index_question = 0;
                }
                displayQuestion();
            }
        };
        Button buttonNextQuestion = findViewById(R.id.next_question_button);
        buttonNextQuestion.setText("Next Question");
        buttonNextQuestion.setOnClickListener(listenerNextQuestion);
    }

    public void displayQuestion(){
        Question question = repository.getListQuestion().get(index_question);
        textViewTextQuestion.setText(question.getText());
        buttonRepository1.setText(String.valueOf(question.getCorrectAnswer()));
        buttonRepository2.setText(String.valueOf(question.getIncorrectAnswer()));
    }
}