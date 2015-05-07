<%-- 
    Document   : alterar
    Created on : 30/05/2013, 17:48:32
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">        
        <link rel="stylesheet" type="text/css" href="css/alterarcss.css" />

        <title>JSP Page</title>
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset>
            <legend>Alterar Questão</legend>
            <div id="colunaesquerda">
                <form method="post" action="/SistemaDeProvas_alfa/AlterarQuestaoServlet">
                    <input type="hidden" name="id" value="${q.id}" />
                    Disciplina: <input type="text" name="disciplina" value="${q.disciplina}"/><br>
                    Assunto: <input type="text" name="assunto" value="${q.assunto}"/><br>
                    Peso: <input type="text" name="peso" value="${q.peso}"/><br>
                    Enunciado : <br>
                    <textarea rows="4" cols="50" name="enunciado">${q.enunciado}</textarea><br>
                    Alternativa Correta :<br>
                    <textarea rows="4" cols="50" name="alternativaCorreta" >${q.alternativaCorreta}
                    </textarea><br>
                    </div>
                    <div id="colunadireita">
                        Alternativas Incorretas :<br>
                        <textarea rows="4" cols="50" name="alternativa1" >${q.alternativa1}</textarea><br>
                        <textarea rows="4" cols="50" name="alternativa2" >${q.alternativa2}</textarea><br>
                        <textarea rows="4" cols="50" name="alternativa3" >${q.alternativa3}</textarea><br>
                        <textarea rows="4" cols="50" name="alternativa4" >${q.alternativa4}</textarea><br>
                    </div>
                    <input class ="botaoalterar" type="submit" value="Alterar"/>
                    <input type="button" value="Voltar" onClick="history.back()">
                </form>
        </fieldset>
    </body>
</html>
