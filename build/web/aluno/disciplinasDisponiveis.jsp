<%-- 
    Document   : disciplinasDisponiveis
    Created on : 09/06/2013, 11:50:42
    Author     : nikolas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplinas Disponíveis</title>
        <link rel="stylesheet" type="text/css" href="./css/telausuario.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="./imgs/cabecalhoalpha.jpg"/>
        </div>
        <fieldset class="master">

            <legend class="toplegend">Disciplinas Disponíveis</legend>

            <div id="colunaesquerda">
                <img src="./imgs/maketest.png"/>
            </div>

        <%-- 
            <fieldset>

            <legend>Banco de Questões</legend>
            <table id="lista">
                <tr>
                <form action="/SistemaDeProvas_alfa/DistribuirServlet" method="post">
                    <th colspan="4"><input type="image" title="Inserir" src="imgs/insert.png" name="inserir" value="inserir" /></th>
                    </tr>
                    <tr>
                        <th scope="col">Opções</th>
                        <th scope="col">Disciplina</th>
                        <th scope="col">Assunto</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Peso</th>
                        <th scope="col">Enunciado</th>
                        <th scope="col">Alternativa Correta</th>
                        <th scope="col">Alternativa Incorreta 1</th>
                        <th scope="col">Alternativa Incorreta 2</th>
                        <th scope="col">Alternativa Incorreta 3</th>
                        <th scope="col">Alternativa Incorreta 4</th>
                </form>
                </tr>
                <c:if test="${empty colecao}">
                    <tr>
                        <th colspan="4">Nenhuma Questao Cadastrada.</th>
                    </tr>	
                </c:if>
                <c:forEach items="${colecao}" var="q">
                    <tr>
                    <form action="/SistemaDeProvas_alfa/DistribuirServlet" method="post">
                        <input type="hidden" name="id" id="id" value="${q.id}" />
                        <td><input type="image" src="imgs/alter.png" name="alterar" title="Alterar" />
                            <input type="image" src="imgs/remove.png" name="remover" title="Remover" /></td>
                        <td>${q.disciplina}</td>
                        <td>${q.assunto}</td>
                        <td>${q.tipo}</td>
                        <td>${q.peso}</td>
                        <td>${q.enunciado}</td>
                        <td>${q.alternativaCorreta}</td>
                        <td>${q.alternativa1}</td>
                        <td>${q.alternativa2}</td>
                        <td>${q.alternativa3}</td>
                        <td>${q.alternativa4}</td>
                    </form>
                    </tr>
                </c:forEach>
            </table>

        </fieldset>
        
        --%>

        <div id="colunadireita">
                <fieldset class="sel">
                     <legend class="sellegend">Escolha uma das disciplinas disponíveis</legend>
            <p><table id="lista">
                

                
                <c:if test="${empty colecao}">
                    <tr>
                        <th colspan="4">Nenhuma questão cadastrada.</th>
                    </tr>	
                </c:if>
                     <form action="BuscarProvaPorDisciplinaServlet" method="get">
                <c:forEach items="${colecao}" var="q">
                    <tr>
                   


                        <td><c:out value="${q}"/></td>
                        <td><input type="radio" name="disciplinaEscolhida" value="${q}"/></td>
                        
                    
                    </tr>
                </c:forEach>
            </table></p>
            <input class="botaoavancar" type="button" value="Voltar" onClick="history.back();"/>
                        <input class="botaoavancar" type="submit" name="avancar" value="Avançar" style="position: absolute; right: 10px;"/>
        </form>
    </fieldset>


</body>
</html>
