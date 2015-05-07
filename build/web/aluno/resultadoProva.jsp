<%-- 
    Document   : resultadoProva
    Created on : 17/06/2013, 09:38:36
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <link rel="stylesheet" type="text/css" href="./css/telausuario.css" /> 
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="./imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset class="master">

            <legend class="toplegend">Resultados</legend>
            <c:out value=""/><br />
            <div id="colunaesquerda">
                <img src="./imgs/resuttest.png"/>
            </div>
            <div id="colunadireita">

                <fieldset class="sel"><legend class="sellegend">Resultado do Simulado</legend>
                    <%-- Mostrando as questoes acertadas --%>
                    <c:set var="contQuestao" value="1"/>
                    <p>
                        <c:forEach items="${comparativo}" var="c"> 
                            <b>Questão <c:out value="${contQuestao}"/>:</b> <c:out value="${c}"/><br />
                            <c:set var="contQuestao" value="${contQuestao + 1}"/>
                        </c:forEach></p>
                    A sua nota final foi: <c:out value="${nota}"/>
                    <p style="float: right"><a class="voltar" href="aluno/telaAluno.jsp"><input type="image" src="imgs/backicon.png"/> Voltar ao Início</a></p>
                </fieldset>

            </div>
        </fieldset>
    </body>
</html>
