<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Demo JSTL</title>
  </head>
  <body>
    <h1>Demo JSTL</h1>

    <c:forEach items="${ villes }" var="ville">
        <p>Ville: <c:out value="${ ville }" /></p>
    </c:forEach>

    <c:if test="${ villes.size() == 0 }">
        <p>Il n'y a aucune ville dans la liste</p>
    </c:if>
  </body>
</html>