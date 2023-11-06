package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/magasin")
public class MagasinServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Stock stock = Stock.getStock(getServletContext());
        request.setAttribute("produits", stock.getProduits());
        request.getRequestDispatcher("WEB-INF/magasin.jsp").forward(request, response);
    }
/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.getRequestDispatcher("WEB-INF/magasin.jsp").forward(request, response);
    }

 */
}
