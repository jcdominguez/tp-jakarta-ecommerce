<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Demo JSTL</title>
  </head>
  <body>
          <h1>Todolist</h1>

          <form action='todolist' method='POST'>
              <label>Nouvelle tache:</label>
              <input type='text' name='tache' />
              <input type='submit' value='Envoyer'>
          </form>


    <ul>
    <c:forEach items="${ taches }" var="tache">
        <li><c:out value="${ tache }" /></li>
    </c:forEach>
    </ul>


  </body>
</html>