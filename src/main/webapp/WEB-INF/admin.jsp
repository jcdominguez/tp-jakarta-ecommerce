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
            </tr>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.prix}</td>
                </tr>
            </c:forEach>
        </table>


        <form action="admin" method="POST">


           <label>Id:</label><input type="text" name="id" value="${id}"/ />
           <br/>

           <label>Nom:</label><input type="text" name="nom" value="${nom}"/>
           <br/>

           <label>Prix:</label><input type="text" name="prix" value="${prix}"/>
           <br/><br/>

           <input type="submit" value="Ajouter">
        </form>

  </body>
</html>