package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/majeurmineur")
public class MajeurMinueurServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       request.getRequestDispatcher("WEB-INF/personneForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String ageString = request.getParameter("age");
        int age = Integer.parseInt(ageString);

        String message = "";
        if(age > 17) {
            message = "Vous êtes une personne majeure !";
        } else {
            message = "Vous êtes une personne mineure !";
        }

        request.setAttribute("prenom", prenom);
        request.setAttribute("nom", nom);
        request.setAttribute("message", message);

        request.getRequestDispatcher("WEB-INF/personneDisplay.jsp").forward(request, response);
    }
}
