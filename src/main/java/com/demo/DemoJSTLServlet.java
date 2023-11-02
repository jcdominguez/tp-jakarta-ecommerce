package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet("/demoJSTL")
public class DemoJSTLServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<String> villes = new ArrayList<>();
        villes.add("Paris");
        villes.add("Marseille");
        villes.add("Niort");

        request.setAttribute("villes", villes);

        request.getRequestDispatcher("WEB-INF/demoJSTL.jsp").forward(request, response);
    }
}
