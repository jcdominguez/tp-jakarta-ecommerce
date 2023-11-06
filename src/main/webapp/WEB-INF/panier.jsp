<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Liste des Articles</title>
  </head>
  <body>
    <h1>Votre panier</h1>

        <table>
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>prix</th>
            </tr>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.prix}</td>
                </tr>
            </c:forEach>
        </table>

        <br/>
        <p>Total : ${total}</p>
  </body>
</html>