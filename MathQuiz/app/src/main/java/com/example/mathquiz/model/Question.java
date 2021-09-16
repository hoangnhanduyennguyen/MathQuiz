package com.example.mathquiz.model;

public class Question {
    private String text; // only be used in this class
    private double correctAnswer;
    private double incorrectAnswer;

    //Constructor for the questions
    public Question(String text, double correctAnswer, double incorrectAnswer){
        //"this" refers to the current object of a method or constructor.
        //high level coding <3
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
    }
    //Encapsulation
    //Get
    public String getText(){ return text;}

    public double getCorrectAnswer(){ return correctAnswer;}

    public double getIncorrectAnswer(){ return incorrectAnswer;}

    //Set

}
