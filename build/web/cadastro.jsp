<%-- 
    Document   : cadastro
    Created on : 04/06/2013, 14:02:20
    Author     : Barbara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Cadastro</title>
        <link rel="stylesheet" type="text/css" href="css/indexlogincss.css" /> 
    </head>
    <body>
        <fieldset>
            <div id="colunaesquerda">
                <img src="imgs/cadastrarse.png"/>
            </div>
            <div id="colunadireita">

                <fieldset class="dir">
                    <input type="image" src="imgs/modalidade.png" name="alterar" title="Modalidade de Cadastro" />
                    <c:import url="/WEB-INF/menuTeste/menuCadastro.jspf"/>
                    <input class="botaoenviar" type="button" value="Voltar" onClick="history.back()">
                </fieldset>
            </div>
        </fieldset>
    </body>
</html>
