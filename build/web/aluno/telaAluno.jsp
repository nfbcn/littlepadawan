<%-- 
    Document   : telaAluno
    Created on : 28/05/2013, 08:14:37
    Author     : Barbara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel do aluno!</title>
        <link rel="stylesheet" type="text/css" href="../css/telausuario.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="../imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset class="master">

            <legend class="toplegend">Menu do Aluno</legend>
            <div id="colunaesquerda">
                <img src="../imgs/welcomestudent.png"/>
            </div>
            <div id="colunadireita">
                <img src="../imgs/part.png"/>
                <fieldset class="dir">
                    <legend class="opcoeslegend">Opções</legend>
                    <c:import url="/WEB-INF/menuTeste/menuAluno.jspf" />
                </fieldset>

                <a class="botaodeslogar" href="deslogar.jsp">
                    <input type="image" src="../imgs/logout.png" name="logout" title="Sair" /></a>
            </div>
        </fieldset>
    </body>
</html>
