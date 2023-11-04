<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Liste des Films</title>
  </head>
  <body>
    <h1>Liste de films</h1>

        <table>
            <tr>
                <th>Titre</th>
                <th>Réalisateur</th>
                <th>Année</th>
                <th>Acteurs</th>
            </tr>
            <c:forEach var="film" items="${films}">
                <tr>
                    <td>${film.titre}</td>
                    <td>${film.realisateur}</td>
                    <td>${film.anneeSortie}</td>
                    <td>${film.acteurs}</td>
                </tr>
            </c:forEach>
        </table>


        <c:if test="${ showprevious == true }">
            <a href="films?page=${page - 1}">Précédent</a>
        </c:if>

        <c:if test="${ shownext == true  }">
            <a href="films?page=${page + 1}">Suivant</a>
        </c:if>

        <div>
            Page: ${page}
        </div>

  </body>
</html>