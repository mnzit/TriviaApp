/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.dao;

/**
 *
 * @author Mnzit
 */
public interface UserDAO {

    int login(String userName, String password) throws Exception;

    boolean register(String userName, String password) throws Exception;

    boolean updateScore(int score, int id) throws Exception;

}
