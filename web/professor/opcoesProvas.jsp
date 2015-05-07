<%-- 
    Document   : index
    Created on : 28/05/2013, 15:41:22
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/opcoesprovascss.css" />
        <title>Sistemas de Provas Teste</title>
    </head>
    <body>

        <div id="cabecalhopadrao">
            <img src="imgs/cabecalhoalpha.jpg"/>
        </div>
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
                        <td>
                            <c:choose>
                                <c:when test="${q.tipo eq 1}">Multipla escolha</c:when>
                                <c:when test="${q.tipo eq 2}">V ou F</c:when>
                            </c:choose>

                        </td>
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
            <p><a class="voltar" href="javascript:history.back()"><input type="image" src="imgs/backicon.png"/> Voltar</a></p>
        </fieldset>
    </body>
</html>
