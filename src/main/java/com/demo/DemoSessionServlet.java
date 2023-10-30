package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/demosession")
public class DemoSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String prenomUrl = request.getParameter("prenom");
        System.out.println(prenomUrl);
        if(prenomUrl == null) {
            String prenomSession = (String)request.getSession().getAttribute("prenom");
            if(prenomSession == null) {
                response.getWriter().write("Je ne te connais pas");
            } else {
                response.getWriter().write("Je te connais. Tu es : "+prenomSession);
            }
        } else {
            request.getSession().setAttribute("prenom", prenomUrl);
            response.getWriter().write("J'ai enregistre ton prenom");
        }
    }
}
