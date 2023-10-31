<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Mineur / Majeur</title>
  </head>
  <body>
    <h1>Mineur / Majeur</h1>

    <form action='majeurmineur' method='POST'>
        <label>Prenom:</label><input type='text' name='prenom' />
        <label>Nom:</label><input type='text' name='nom' />
        <label>Age:</label><input type='number' name='age' />
        <input type='submit' value='Envoyer'>
    </form>
  </body>
</html>