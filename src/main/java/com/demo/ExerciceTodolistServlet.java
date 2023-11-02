package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
2 routes disponibles:
 GET  /todolist
 POST /todolist
 */

@WebServlet("/todolist")
public class ExerciceTodolistServlet extends HttpServlet {

    private ArrayList<String> taches = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("taches", taches);
        request.getRequestDispatcher("WEB-INF/todolist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nouvelleTache = request.getParameter("tache");
        taches.add(nouvelleTache);

        // Au choix:
        //doGet(request, response);
        response.sendRedirect(request.getContextPath()+"/todolist");
    }
}