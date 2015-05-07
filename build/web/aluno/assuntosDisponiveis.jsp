<%-- 
    Document   : assuntosDisponiveis
    Created on : 09/06/2013, 11:51:08
    Author     : nikolas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assuntos Disponíveis</title>
        <link rel="stylesheet" type="text/css" href="./css/telausuario.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="./imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset class="master">

            <legend class="toplegend">Assuntos Disponíveis</legend>

            <div id="colunaesquerda">
                <img src="./imgs/maketest.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="sel">
                    <legend class="sellegend">Escolha uma dos assuntos disponíveis</legend>
                    <p><table id="lista">
                        <c:if test="${empty colecao}">
                            <tr>
                                <th colspan="4">Nenhuma questão cadastrada.</th>
                            </tr>	
                        </c:if>
                        <form action="BuscarProvaPorAssuntoServlet" method="get">
                            <c:forEach items="${colecao}" var="q">
                                <tr>
                                    <td><input type="radio" name="assuntoEscolhido" value="${q}"/></td>
                                    <td><c:out value="${q}"/></td>
                                    
                                </tr>
                            </c:forEach>

                    </table><p>
                        <input class="botaoavancar" type="button" value="Voltar" onClick="history.back();"/>
                        <input class="botaoavancar" type="submit" name="avancar" value="Avançar" style="position: absolute; right: 10px;"/>
                        </form>

                </fieldset>
                </body>
                </html>
