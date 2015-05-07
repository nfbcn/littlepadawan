<%-- 
    Document   : resultado
    Created on : 29/05/2013, 11:55:47
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <link rel="stylesheet" type="text/css" href="css/opcoesprovascss.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset>
            <legend>Resultados</legend>
            <table id="lista">  
                <tr>
                    <th scope="col">Aluno</th>
                    <th scope="col">Nota</th>
                    <th scope="col">Percentual de Acerto</th>
                    <th scope="col">Número de Acertos</th>
                </tr>
                <c:forEach items="${resultadoSimulado}" var="rs">
                    <tr>
                        <td><c:out value="${rs.nomeAluno}"/><br></td>
                        <td><c:out value="${rs.nota}"/><br></td>
                        <td><c:out value="${rs.percentual}"/>%<br></td>
                        <td><c:out value="${rs.acerto}"/><br></td>
                    </tr>

                </c:forEach>
            </table>
                <p><a class="voltar" href="javascript:history.back()"><input type="image" src="imgs/backicon.png"/> Voltar</a></p>
                </body>
</html>
