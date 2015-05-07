<%-- 
    Document   : index
    Created on : 28/05/2013, 15:41:22
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Sistemas de Provas Teste</title>
        <link rel="stylesheet" type="text/css" href="../css/inserircss.css" /> 
        <script type="text/javascript" src="../scripts/validaForm.js"></script>  
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="../imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset>
            <legend>Cadastrar Questão</legend>
            <form name="valida" method="post" action="/SistemaDeProvas_alfa/InserirQuestaoServlet" id="formInserir" onsubmit="return validarForm(this);">

                <div id="colunaesquerda">
                    Disciplina: <input type="text" name="disciplina"/><br>
                    Assunto: <input type="text" name="assunto"/><br>
                    Tipo de questão<br>
                    Objetiva <input type="radio" name="tipo" value="1"/><br>
                    Acertiva<input type="radio" name="tipo" value="2"/><br>
                    Peso: <input type="text" name="peso"/><br>
                    Enunciado : <br>                   
                    <textarea rows="4" cols="50" name="enunciado" form="formInserir"  onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Insira o enunciado da sua questão</textarea><br>
                    Alternativa Correta :<br>
                    <textarea rows="4" cols="50" name="alternativaCorreta" form="formInserir" onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Se Questão de multipla escolha informe a alternativa correta nesse espaço
            caso contrário informe apenas o valor da sua proposição v ou f </textarea><br>
                </div>
                <div id="colunadireita">
                    Alternativas Incorretas :<br>
                    <textarea rows="4" cols="50" name="alternativa1" form="formInserir" onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Insira uma das alternativas de resposta incorreta</textarea><br>
                    <textarea rows="4" cols="50" name="alternativa2" form="formInserir" onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Insira uma das alternativas de resposta incorreta</textarea><br>
                    <textarea rows="4" cols="50" name="alternativa3" form="formInserir" onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Insira uma das alternativas de resposta incorreta</textarea><br>
                    <textarea rows="4" cols="50" name="alternativa4" form="formInserir" onclick="this.value = '';" onblur="this.value = !this.value ? '' : this.value;"> Insira uma das alternativas de resposta incorreta</textarea><br>
                    <input class="botaoenviar" type="submit" value="Enviar" style="position: absolute; right: 25px;"/>   
                    <input class="botaoenviar" type="button" value="Voltar" onClick="history.back()">
                </div>
            </form>

        </fieldset>

    </body>
</html>
