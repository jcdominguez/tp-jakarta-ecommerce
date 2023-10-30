package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String prenom = request.getParameter("prenom");
        System.out.println(prenom);

        LocalDateTime maintenant = LocalDateTime.now();
        response.getWriter().write("<h1>Hello world Bis</h1><p>"+maintenant+"</p>"
                +"<p>"+prenom+"</p>");
    }
}
