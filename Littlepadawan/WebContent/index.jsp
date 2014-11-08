<%-- 
    Document   : index
    Created on : 15/05/2013, 09:52:42
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas IFPE</title>
        <link rel="stylesheet" type="text/css" href="css/indexlogincss.css" /> 
    </head>
    <body>
        <fieldset>
            <div id="colunaesquerda">
                <img src="imgs/welcome.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="dir">
                    <c:import url="menuTeste/menu.jspf" />
                </fieldset>
            </div>
        </fieldset>
    </body>
</html>
