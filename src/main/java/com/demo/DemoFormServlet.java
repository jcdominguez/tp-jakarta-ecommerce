package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/demoform")
public class DemoFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LocalDateTime maintenant = LocalDateTime.now();
        response.getWriter().append("<h1>Demo Form</h1>");
        response.getWriter().append("<form action='demoform' method='POST'>");
        response.getWriter().append("<label>Prenom:</label>");
        response.getWriter().append("<input type='text' name='prenom' />");
        response.getWriter().append("<input type='submit' value='Envoyer'>");
        response.getWriter().append("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String prenom = request.getParameter("prenom");
        response.getWriter().append("<p>Bonjour: "+prenom+"</p>");
    }
}