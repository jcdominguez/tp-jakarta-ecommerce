package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/demoJSTL")
public class DemoJSTLServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //String[] villes = { "Paris", "Marseille", "Niort" };
        String[] villes = new String[0];
        request.setAttribute("villes", villes);

        request.setAttribute("vide", villes.length == 0);

       request.getRequestDispatcher("WEB-INF/demoJSTL.jsp").forward(request, response);
    }
}
