<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Liste des Articles</title>
  </head>
  <body>
    <h1>Liste de Articles</h1>

        <table>
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>prix</th>
                <th>.</th>
            </tr>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.prix}</td>
                    <td>
                         <form action="panier" method="POST">
                               <input type="hidden" name="id" value="${produit.id}" />
                               <input type="hidden" name="nom" value="${produit.nom}" />
                               <input type="hidden" name="prix" value="${produit.prix}" />
                               <input type="submit" value="Ajouter au panier">
                         </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

  </body>
</html>