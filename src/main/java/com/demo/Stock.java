package com.demo;

import jakarta.servlet.ServletContext;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Produit> produits = new ArrayList<>();

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
    }

    static Stock getStock(ServletContext context){
        Stock stock = (Stock)context.getAttribute("stock");
        if(stock == null) {
            stock = new Stock();

            stock.addProduit(new Produit(1, "laptop", 900));
            stock.addProduit(new Produit(2, "smartphone", 500));

            context.setAttribute("stock", stock);
        }
        return stock;
    }
}
