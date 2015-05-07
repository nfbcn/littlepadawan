<%-- 
    Document   : cadastro
    Created on : 03/06/2013, 14:37:14
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Aluno</title>
        <link rel="stylesheet" type="text/css" href="css/cadastrocss.css" /> 
        <script type="text/javascript" src="scripts/validaForm.js"></script> 
    </head>
    <body>
        <fieldset>
            <div id="colunaesquerda">
                <img src="imgs/newstudent.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="dir">
                    <legend>INFORME SEUS DADOS</legend>
                    <form action="/SistemaDeProvas_alfa/CadastrarAlunoServlet" method="post" name="cadastroAluno" onsubmit="return validaCadastroAl  (this);">
                        <p>Nome: <input type="text" name="nomeAluno" /></p>
                        <p>Matrícula: <input type="text" name="matricula" /></p>
                        <p>Senha: <input type="password" name="senhaAluno" /></p>
                        <input class="botaocadastrar" type="button" value="Voltar" onClick="history.back()"/>
                        <input class="botaocadastrar" type="submit" name="cadastrarAluno" value="Cadastrar" style="position: absolute; right: 10px;"/>

                    </form>
            </div>
        </fieldset>
    </fieldset>
</body>
</html>
