<%-- 
    Document   : prova
    Created on : 12/06/2013, 09:49:52
    Author     : nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prova</title>
        <link rel="stylesheet" type="text/css" href="./css/provacss.css" />
    </head>
    <body>
        <div id="cabecalhopadrao">
            <img src="./imgs/cabecalhoalpha.jpg"/>
        </div>
        <%--
        Como pegar as alternativas
        <c:out value="alternativa :  ${p.alternativas[0]}"></c:out><br>
        
        --%>

        <fieldset class="master">

            <legend class="toplegend">Simulado</legend>
            <%-- marcador para as questoes --%>
            <c:set var="cont" value="1"/>

            <%--   A quantidade de questões é: <c:out value="${tamanhoProva}"/><br> -->



            <%-- inicio do form para envio das questoes --%>

            <form action="RecebeRespostasServlet" method="post">

                <%--for para percorrer todos os itens da prova--%>
                <c:forEach items="${prova}" var="p">
                    <p>
                        <%--exibição da prova--%>
                        <c:out value="${cont}"/>)<c:out value="${p.enunciado}"></c:out><br>
                        Peso:<c:out value="${p.peso}" ></c:out>
                        <%-- contador para letras --%>
                        <c:set var="contLetras" value="0"/>

                        <%-- exibição das alternativas--%>
                    <div id="alternativas">
                        <c:if test="${contLetras eq 0}">
                            <input type="radio" name="q${cont}" value="${p.alternativas[0]}"/>
                            <c:out value="a"/>)<c:out value="${p.alternativas[0]}  "/><br>
                            <c:set var="contLetras" value="${contLetras +1}"/>
                        </c:if> 
                        <c:if test="${contLetras eq 1}">
                            <input type="radio" name="q${cont}" value="${p.alternativas[1]}"/>
                            <c:out value="b"/>)<c:out value="${p.alternativas[1]}  "/><br>
                            <c:set var="contLetras" value="${contLetras +1}"/>
                        </c:if>
                        <c:if test="${contLetras eq 2}">
                            <input type="radio" name="q${cont}" value="${p.alternativas[2]}"/>
                            <c:out value="c"/>)<c:out value="${p.alternativas[2]}  "/><br>
                            <c:set var="contLetras" value="${contLetras +1}"/>
                        </c:if>
                        <c:if test="${contLetras eq 3}">
                            <input type="radio" name="q${cont}" value="${p.alternativas[3]}"/>
                            <c:out value="d"/>)<c:out value="${p.alternativas[3]}  "/><br>
                            <c:set var="contLetras" value="${contLetras +1}"/>
                        </c:if>
                        <c:if test="${contLetras eq 4}">
                            <input type="radio" name="q${cont}" value="${p.alternativas[4]}"/>
                            <c:out value="e"/>)<c:out value="${p.alternativas[4]}  "/><br>
                            <c:set var="contLetras" value="${contLetras +1}"/>
                        </c:if>
                        <%--  fim da exibição de alternativas --%>
                    </div>
                    </p>




                    <%-- contador das questoes--%>
                    <c:set var="cont" value="${cont +1}"/>

                    <%--  fim da exibição de questoes --%>

                </c:forEach> 
                <%--  fim da exibição do form --%>
                <input class="botaoenviar" type="submit" value="Finalizar Prova"/>
            </form>
        </fieldset>

    </body>
</html>
