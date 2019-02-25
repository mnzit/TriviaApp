/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.triviaapp.controller;

import com.mnzit.triviaapp.web.dao.UserDAO;
import com.mnzit.triviaapp.web.dao.impl.UserDAOFileImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mnzit
 */
@WebServlet(name = "home", urlPatterns = {"/", "/home/*"})
public class HomeController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI().toLowerCase();
        String redirect = "";
        if (uri.contains("about")) {
            redirect = "home/about";
        } else if (uri.contains("facts")) {
            redirect = "home/facts";
        } else if (uri.contains("login")) {
            redirect = "home/login";
        } else if (uri.contains("register")) {
            redirect = "home/register";
        } else if (uri.contains("logout")) {
            request.getSession().invalidate();
            redirect = "home/login";
        } else {
            redirect = "home/index";
        }
        view(redirect, request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAOFileImpl();
        try {
            String uri = request.getRequestURI().toLowerCase();
            if (uri.contains("login")) {
                int i = userDAO.login(username, password);
                if (i > 0) {
                    request.getSession(true).setAttribute("username", username);
                    request.getSession(true).setAttribute("id", i);
                    response.sendRedirect(request.getContextPath() + "/home");
                } else {
                    response.sendRedirect(request.getContextPath() + "/home?error");
                }
            } else {
                userDAO.register(username, password);
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
