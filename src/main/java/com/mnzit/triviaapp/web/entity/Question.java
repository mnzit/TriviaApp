/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.entity;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public class Question {

    private int id;
    private String question;
    private List<String> choice;
    private int correctChoice;

    public Question() {
    }

    public Question(int id, String question, List<String> choice, int correctChoice) {
        this.id = id;
        this.question = question;
        this.choice = choice;
        this.correctChoice = correctChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoice() {
        return choice;
    }

    public void setChoice(List<String> choice) {
        this.choice = choice;
    }

    public int getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(int correctChoice) {
        this.correctChoice = correctChoice;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", choice=" + choice + ", correctChoice=" + correctChoice + '}';
    }
}
