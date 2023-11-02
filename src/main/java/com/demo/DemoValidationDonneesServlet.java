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
        boolean erreurPrenom = false;
        if(prenom.length() <  5) {
            erreurPrenom = true;
            request.setAttribute("erreurPrenom", true);
            request.setAttribute("prenom", prenom);
        }

        String ageString = request.getParameter("age");
        System.out.println(ageString);
        boolean erreurAge = false;
        try {
            int age = Integer.parseInt(ageString);
            if (age < 18) {
                request.setAttribute("erreurAge", true);
                request.setAttribute("age", age);
            }
        }
        catch(Exception e){
            request.setAttribute("erreurAge", true);
            request.setAttribute("age", ageString);
            System.out.println("l'age n'est pas un nombre");
        }

        if(!erreurAge && !erreurPrenom) {
            // c'est ok : On execute le traitement normal
            personnes.add(prenom);
        }


        request.getRequestDispatcher("WEB-INF/demovalidation.jsp").forward(request, response);
    }
}
