package com.demo;

import java.util.ArrayList;

public class PanierClient {

    private ArrayList<Produit> produits = new ArrayList<>();

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
    }

}
