<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Validation</title>
  </head>
  <body>
    <h1>Validation</h1>

    <form action='demovalidation' method='POST'>
        <c:if test="${erreurPrenom == true}">
                <p>Le prénom doit contenir au moins 5 lettres</p>
        </c:if>
        <label>Prenom:</label>
      <!--   <input type='text' name='prenom' minlength="5"/> -->
        <input type='text' name='prenom' value="${prenom}"/>
   <!--     <label>Nom:</label><input type='text' name='nom' />
        <label>Age:</label><input type='number' name='age' />-->
        <input type='submit' value='Envoyer'>
    </form>
  </body>
</html>