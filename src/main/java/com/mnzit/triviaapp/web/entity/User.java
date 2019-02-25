package com.mnzit.triviaapp.web.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mnzit
 */
public class User {

    private int id, score;
    private String userName, password;

    public User() {
    }

    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + score;
    }

    public User(int id, String userName, String password, int score) {
        this.id = id;
        this.score = score;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
