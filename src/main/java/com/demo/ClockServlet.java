package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/clock")
public class ClockServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        LocalDateTime maintenant = LocalDateTime.now();

        request.setAttribute("horaire", maintenant);

       request.getRequestDispatcher("WEB-INF/clock.jsp").forward(request, response);
    }
}
