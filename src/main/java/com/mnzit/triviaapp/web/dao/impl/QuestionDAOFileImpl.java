/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.dao.impl;

import com.mnzit.triviaapp.web.dao.QuestionDAO;
import com.mnzit.triviaapp.web.entity.Question;
import com.mnzit.triviaapp.web.filehelper.FileManipulater;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class QuestionDAOFileImpl implements QuestionDAO {

    @Override
    public List<Question> getAll() throws Exception {
        List<Question> question = new ArrayList<>();
        String line = "";
//        FileManipulater reader = new FileManipulater("d:/trivia.txt");
        BufferedReader reader = new BufferedReader(new FileReader("d:/trivia.txt"));
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(":");
            if (tokens.length == 7) {
                Question q = new Question();
                q.setId(Integer.parseInt(tokens[0]));
                q.setQuestion(tokens[1]);
                q.setChoice(new ArrayList<>(Arrays.asList(tokens[2], tokens[3], tokens[4], tokens[5])));
                q.setCorrectChoice(Integer.parseInt(tokens[6]));
                question.add(q);
            }
        }
        Collections.shuffle(question);
        return question;
    }

    @Override
    public Question getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Question model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Question model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
