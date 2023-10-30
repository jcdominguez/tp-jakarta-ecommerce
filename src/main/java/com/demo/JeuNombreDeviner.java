package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet("/jeu")
public class JeuNombreDeviner extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.getWriter().write("<h1>Jeu Nombre a deviner</h1>");

        Partie partie = (Partie)request.getSession().getAttribute("partie");
        if(partie == null) {

            partie = new Partie();
            // Initialisation d'une partie:
            partie.nombreTentativesRestantes = 3;
            partie.nombreADeviner = new Random().nextInt(1, 10);

        }

        // Récuperer le nombre proposé par le joueur
        String nombreJoueurString = request.getParameter("nombrejoueur");
        partie.nombreJoueur = Integer.parseInt(nombreJoueurString);

        // algo du jeu
        if(partie.nombreJoueur == partie.nombreADeviner){
            response.getWriter().write("<p>Bravo</p>");
            partie.nombreADeviner = new Random().nextInt(1,10) ;
            partie.nombreTentativesRestantes = 3;
        }
        else {
            partie.nombreTentativesRestantes--;

            if(partie.nombreJoueur > partie.nombreADeviner){
                response.getWriter().write("<p>Trop grand</p>");
            }
            else {
                response.getWriter().write("<p>Trop petit</p>");
            }

            if(partie.nombreTentativesRestantes == 0){
                response.getWriter().write("<p>Perdu. Nouvelle partie</p>");
                partie.nombreTentativesRestantes = 3;
                partie.nombreADeviner = new Random().nextInt(1,10) ;
            }
        }


        request.getSession().setAttribute("partie", partie);


        response.getWriter().write("<p>Nombre joueur:</p>"+partie.nombreJoueur);
        response.getWriter().write("<p>Nombre jeu:</p>"+partie.nombreADeviner);
        response.getWriter().write("<p>Nombre tentatives restantes:</p>"+partie.nombreTentativesRestantes);
    }
}
