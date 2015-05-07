<%-- 
    Document   : login
    Created on : 22/05/2013, 14:24:46
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas - Login</title>
        <link rel="stylesheet" type="text/css" href="../css/indexlogincss.css" /> 
         <script type="text/javascript" src="../scripts/validaForm.js"></script> 
    </head>
    <body>
        <fieldset>
            <div id="colunaesquerda">
                <img src="../imgs/loginscreen.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="dir">
                    <form action="${action}" method="post" onsubmit="return validarLogin(this);"> 
                        <p><label for="login">Login:</label> <input type="text" name="login" id="login">
                        <p><label for="senha">Senha:</label> <input type="password" name="senha" id="senha">
                             <p><input class="botaoenviar" type="button" value="Voltar" onClick="history.back()">
                            <input class="botaoenviar" type="submit" name="cadastrarProf" value="Entrar" style="position: absolute; right: 26px;"/></p>
                    </form>
                </fieldset>
            </div>
        </fieldset>
    </body>
</html>
