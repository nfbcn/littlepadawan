<%-- 
    Document   : escolherProva
    Created on : 09/06/2013, 10:29:05
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escolha o seu critério de seleção para prova</title>
        <link rel="stylesheet" type="text/css" href="../css/telausuario.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="../imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset class="master">

            <legend class="toplegend">Critério de Seleção</legend>

            <div id="colunaesquerda">
                <img src="../imgs/maketest.png"/>
            </div>
            <div id="colunadireita">
                <fieldset class="sel">
                     <legend class="sellegend">Escolha o critério de seleção das questões</legend>
                    <form action="/SistemaDeProvas_alfa/SelecionarTipoQuestoesServlet" method="get">

                        <p><input type="radio" name="tipoSelecao" value="1"/>Disciplina<br>
                        <input type="radio" name="tipoSelecao" value="2"/>Assunto<br> </p>
                        <input class="botaoavancar" type="button" value="Voltar" onClick="history.back();"/>
                        <input class="botaoavancar" type="submit" name="avancar" value="Avançar" style="position: absolute; right: 10px;"/>
                    </form>
                </fieldset>
            </div>
        </fieldset>

    </body>
</html>
