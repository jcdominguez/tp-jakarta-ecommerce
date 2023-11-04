<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>tp validation form</title>
  </head>
  <body>
    <h1>tp validation form</h1>

     <c:if test="${confirmation == true}">
            <p>Le formualire a été enregistré</p>
     </c:if>

    <form action="tpvalidationform" method="POST">

       <c:if test="${erreurNom == true}">
              <p>Le nom ne peut pas être vide</p>
       </c:if>
       <label>Nom:</label><input type="text" name="nom" value="${nom}"/ />
       <br/>

       <c:if test="${erreurAge == true}">
               <p>L'âge doit être un nombre entier entre 0 et 150</p>
       </c:if>
       <label>Age:</label><input type="number" name="age" value="${age}"/>
       <br/>

        <c:if test="${erreurEmail == true}">
              <p>L'email doit contenir le symbole: @</p>
       </c:if>
       <label>Email:</label><input type="text" name="email" value="${email}"/>
       <br/><br/>

       <input type="submit" value="Envoyer">
    </form>
  </body>
</html>