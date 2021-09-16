package com.example.mathquiz.model;

public class QuestionAnalyzer {
    //Validator
    //Method isCorrectAnswer will return a boolean
    //Compare the question.
    public boolean isCorrectAnswer(Question question, double answer){

        return question.getCorrectAnswer() == answer;
    }
}
