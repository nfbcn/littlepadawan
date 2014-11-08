<%-- 
    Document   : cadastroProfessor
    Created on : 03/06/2013, 18:48:08
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Professor</title>
        <link rel="stylesheet" type="text/css" href="css/cadastrocss.css" />
        <script type="text/javascript" src="scripts/validaForm.js"></script> 
    </head>
    <body>
        <fieldset>
            <div id="colunaesquerda">
                <img src="imgs/newteacher.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="dir">
                    <legend>INFORME SEUS DADOS</legend>
                     <form action="/SistemaDeProvas_alfa/CadastrarProfessorServlet" method="post" name="cadastroProf" onsubmit="return validaCadastroProf(this);">
                        <p>Nome: <input type="text" name="nomeProf" value="${param.nomeProf}"/></p>
                        <p>Disciplina: <input type="text" name="disciplina" value="${param.disciplina}" /></p>
                        <p>SIAPE: <input type="text" name="siape" value="${param.siape}"/></p>
                        <p>Senha: <input type="password" name="senhaProf" value="${param.senhaProf}" /></p>
                         <input class="botaocadastrar "type="button" value="Voltar" onClick="history.back()"/>
                        <input class="botaocadastrar" type="submit" name="cadastrarProf" value="Cadastrar" style="position: absolute; right: 10px;"/>
                        
                    </form>
                </fieldset>
            </div>
        </fieldset>

    </body>
</html>
