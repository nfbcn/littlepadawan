<%-- 
    Document   : verQuestoes
    Created on : 13/06/2013, 14:37:47
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h2>Clique para acessar o banco de questões!</h2>
        <form action="../AtualizarServlet" method="post">
          <input type="submit" value="Acessar">
          <input type="button" value="Voltar" onClick="history.back()">
        </form>
    </body>
</html>
