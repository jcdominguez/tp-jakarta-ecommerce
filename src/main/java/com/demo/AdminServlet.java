package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Stock stock = Stock.getStock(getServletContext());

        request.setAttribute("produits", stock.getProduits());
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String idString = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prixString = request.getParameter("prix");

        // TODO : valider les données du formulaire

        int id = Integer.parseInt(idString);
        int prix = Integer.parseInt(prixString);

        Produit produit = new Produit(id, nom, prix);
        Stock stock = Stock.getStock(getServletContext());
        stock.addProduit(produit);

        request.setAttribute("produits", stock.getProduits());
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }
}
