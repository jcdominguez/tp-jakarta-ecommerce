package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/films")
public class TpPaginationFilmsServlet extends HttpServlet {

    private ArrayList<Film> films;
    private final int TAILLE_PAGE = 5;

    public TpPaginationFilmsServlet() {
        films = new ArrayList<>();

        films.add(new Film("The Shawshank Redemption", "Frank Darabont", "1994", "Tim Robbins / Morgan Freeman"));
        films.add(new Film("The Godfather", "Francis Ford Coppola", "1972", "Marlon Brando / Al Pacino"));
        films.add(new Film("The Godfather: Part II", "Francis Ford Coppola", "1974", "Al Pacino / Robert De Niro"));
        films.add(new Film("The Dark Knight", "Christopher Nolan", "2008", "Christian Bale / Heath Ledger"));
        films.add(new Film("12 Angry Men", "Sidney Lumet", "1957", "Henry Fonda / Lee J. Cobb"));
        films.add(new Film("Schindler's List", "Steven Spielberg", "1993", "Liam Neeson / Ralph Fiennes"));
        films.add(new Film("The Lord of the Rings: The Return of the King", "Peter Jackson", "2003", "Elijah Wood / Viggo Mortensen"));
        films.add(new Film("Pulp Fiction", "Quentin Tarantino", "1994", "John Travolta / Uma Thurman"));
        films.add(new Film("The Good, the Bad and the Ugly", "Sergio Leone", "1966", "Clint Eastwood / Eli Wallach"));
        films.add(new Film("Fight Club", "David Fincher", "1999", "Brad Pitt / Edward Norton"));
        films.add(new Film("Forrest Gump", "Robert Zemeckis", "1994", "Tom Hanks / Robin Wright"));
        films.add(new Film("Inception", "Christopher Nolan", "2010", "Leonardo DiCaprio / Joseph Gordon-Levitt"));
        films.add(new Film("Star Wars: Episode V - The Empire Strikes Back", "Irvin Kershner", "1980", "Mark Hamill / Harrison Ford"));
        films.add(new Film("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", "2001", "Elijah Wood / Ian McKellen"));
        films.add(new Film("One Flew Over the Cuckoo's Nest", "Miloš Forman", "1975", "Jack Nicholson / Louise Fletcher"));
        films.add(new Film("Goodfellas", "Martin Scorsese", "1990", "Robert De Niro / Ray Liotta"));
        films.add(new Film("The Matrix", "Lana and Lilly Wachowski", "1999", "Keanu Reeves / Laurence Fishburne"));
        films.add(new Film("Seven Samurai", "Akira Kurosawa", "1954", "Toshirō Mifune / Takashi Shimura"));
        films.add(new Film("City of God", "Fernando Meirelles", "2002", "Alexandre Rodrigues / Leandro Firmino"));
        films.add(new Film("Se7en", "David Fincher", "1995", "Brad Pitt / Morgan Freeman"));
        films.add(new Film("The Silence of the Lambs", "Jonathan Demme", "1991", "Jodie Foster / Anthony Hopkins"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));

            // ceil():arrondit vers le haut. utile quand le nombre d'items n'est pas un multiple de la taille de la page
            int totalPages = (int) Math.ceil((double) films.size() / TAILLE_PAGE);
            if(page < 1 || page > totalPages)
                page = 1;
        }
        catch (Exception e){

        }

        int fromIndex = (page - 1) * TAILLE_PAGE;
        int toIndex = Math.min(fromIndex + TAILLE_PAGE, films.size()); // Ne pas dépasser la taille de la liste
        ArrayList<Film> filmsPagine = new ArrayList<>(films.subList(fromIndex, toIndex));

        request.setAttribute("page",page);
        request.setAttribute("showprevious",page > 1);
        request.setAttribute("shownext",page*TAILLE_PAGE < films.size());
        request.setAttribute("films",filmsPagine);
        request.getRequestDispatcher("WEB-INF/films.jsp").forward(request, response);
    }
}
