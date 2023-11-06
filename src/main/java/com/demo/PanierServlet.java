package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PanierClient panier = (PanierClient) request.getSession().getAttribute("panier");
        if(panier == null) {
            panier = new PanierClient();
            request.getSession().setAttribute("panier", panier);
        }

        ArrayList<Produit> produits = panier.getProduits();

        int total = 0;
        for(Produit p : produits){
            total += p.getPrix();
        }
        request.setAttribute("total", total);

        request.setAttribute("produits", produits);
        request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // amélioration : envoyer que l'id et utiliser l'objet Produit qui se trouve dans la liste du Magasin.

        String idString = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prixString = request.getParameter("prix");

        // TODO : valider les données du formulaire

        int id = Integer.parseInt(idString);
        int prix = Integer.parseInt(prixString);

        Produit produit = new Produit(id, nom, prix);

        PanierClient panier = (PanierClient) request.getSession().getAttribute("panier");
        if(panier == null) {
            panier = new PanierClient();
        }

        panier.addProduit(produit);
        request.getSession().setAttribute("panier", panier);

        ArrayList<Produit> produits = panier.getProduits();
        int total = 0;
        for(Produit p : produits){
            total += p.getPrix();
        }
        request.setAttribute("total", total);

        request.setAttribute("produits", panier.getProduits());
        request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
    }
}
