/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.web.dao;

import com.mnzit.triviaapp.web.entity.Question;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface QuestionDAO {

    List<Question> getAll() throws Exception;

    Question getById(int id) throws Exception;

    int insert(Question model) throws Exception;

    int update(Question model) throws Exception;

    int delete(int id) throws Exception;
}
