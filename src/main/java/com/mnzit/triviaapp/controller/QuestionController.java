/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.controller;

import com.mnzit.triviaapp.web.dao.QuestionDAO;
import com.mnzit.triviaapp.web.dao.UserDAO;
import com.mnzit.triviaapp.web.dao.impl.QuestionDAOFileImpl;
import com.mnzit.triviaapp.web.dao.impl.UserDAOFileImpl;
import com.mnzit.triviaapp.web.entity.Question;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "question", urlPatterns = {"/question"})
public class QuestionController extends Controller {

    private QuestionDAO questionDAO = new QuestionDAOFileImpl();
    private List<Question> currentQuestions;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List question = questionDAO.getAll();
            currentQuestions = question;
            request.setAttribute("questions", question);
            view("questions/index", request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        for (Question currentQuestion : currentQuestions) {
            String a = req.getParameter(String.valueOf(currentQuestion.getId()));
            if (String.valueOf(currentQuestion.getCorrectChoice()).equalsIgnoreCase(a)) {
                result++;
            }
        }
        req.setAttribute("result", result + "/" + currentQuestions.size());
        UserDAO userDAO = new UserDAOFileImpl();
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            int id = (int) session.getAttribute("id");
            try {
                userDAO.updateScore(result, id);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        view("questions/result", req, resp);
    }

}
