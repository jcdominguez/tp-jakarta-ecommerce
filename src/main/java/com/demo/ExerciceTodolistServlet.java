package com.demo;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.getWriter().append("<h1>Todolist</h1>");

        response.getWriter().append("<ul>");
        for(String tache : taches){
            response.getWriter().append("<li>"+tache+"</li>");
        }
        response.getWriter().append("</ul>");

        response.getWriter().append("<form action='todolist' method='POST'>");
        response.getWriter().append("<label>Nouvelle tache:</label>");
        response.getWriter().append("<input type='text' name='tache' />");
        response.getWriter().append("<input type='submit' value='Envoyer'>");
        response.getWriter().append("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nouvelleTache = request.getParameter("tache");
        taches.add(nouvelleTache);

        // Au choix:
        //doGet(request, response);
        response.sendRedirect(request.getContextPath()+"/todolist");
    }
}