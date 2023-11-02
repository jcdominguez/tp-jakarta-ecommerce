package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/demovalidation")
public class DemoValidationDonneesServlet extends HttpServlet {

    private ArrayList<String> personnes = new ArrayList<>();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("WEB-INF/demovalidation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String prenom = request.getParameter("prenom");
        System.out.println(prenom);
        if(prenom.length() >  5) {
            // c'est ok
            personnes.add(prenom);
        }
        else {
            request.setAttribute("erreurPrenom", true);
            request.setAttribute("prenom", prenom);
        }

        request.getRequestDispatcher("WEB-INF/demovalidation.jsp").forward(request, response);
    }
}
