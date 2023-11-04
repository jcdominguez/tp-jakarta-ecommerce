package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/tpvalidationform")
public class TpValidationFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("WEB-INF/tpvalidationform.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nom = request.getParameter("nom");
        System.out.println(nom);
        boolean erreurNom = false;
        if(nom == null || nom.isEmpty()) {
            erreurNom = true;
            request.setAttribute("erreurNom", erreurNom);
        }

        String ageString = request.getParameter("age");
        System.out.println(ageString);
        boolean erreurAge = false;
        if(ageString == null || !isNumeric(ageString)) {
            erreurAge = true;
            request.setAttribute("erreurAge", erreurAge);
        }
        else{
            int age = Integer.parseInt(ageString);
            if(age < 0 || age > 150) {
                erreurAge = true;
                request.setAttribute("erreurAge", erreurAge);
                request.setAttribute("age", ageString);
            }
        }

        String email = request.getParameter("email");
        System.out.println(email);
        boolean erreurEmail = false;
        if(email == null || !email.contains("@")) {
            erreurEmail = true;
            request.setAttribute("erreurEmail", erreurEmail);
        }


        if(!erreurNom && !erreurAge && !erreurEmail) {
            // c'est ok : On execute le traitement normal
            // ... à compléter

            // et on confirme:
            request.setAttribute("confirmation", true);
        }
        else {
            request.setAttribute("nom", nom);
            request.setAttribute("age", ageString);
            request.setAttribute("email", email);
        }

        request.getRequestDispatcher("WEB-INF/tpvalidationform.jsp").forward(request, response);
    }

    private boolean isNumeric(String str) {
        /* utilisation d'une regex pour savoir si le string contient un nombre et éviter :
         - d'utiliser try/catch
         - d'importer une bibliothèque externe
        */

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }
}
