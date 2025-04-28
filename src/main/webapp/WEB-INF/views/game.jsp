<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>${gameState.currentScene}</title>
  <style>
    body {
      background-color: #0a0a0a;
      color: #c0c0c0;
      font-family: 'Times New Roman', serif;
      line-height: 1.6;
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
    }
    h1 { color: #8b0000; }
    .button {
      background-color: #8b0000;
      color: white;
      padding: 10px 15px;
      border: none;
      cursor: pointer;
      margin: 5px;
    }
  </style>
</head>
<body>
<h1>${gameState.playerName}, продолжайте исследование</h1>
<p>${description}</p>

<c:choose>
  <c:when test="${gameState.currentScene == 'investigation'}">
    <a href="${pageContext.request.contextPath}/game?choice=library" class="button">Идти в библиотеку</a>
    <a href="${pageContext.request.contextPath}/game?choice=cellar" class="button">Спуститься в подвал</a>
  </c:when>

  <c:when test="${gameState.currentScene == 'library'}">
    <a href="${pageContext.request.contextPath}/game?choice=read" class="button">Прочитать фолиант</a>
    <a href="${pageContext.request.contextPath}/game?choice=leave" class="button">Уйти</a>
  </c:when>

  <c:when test="${gameState.currentScene == 'cellar'}">
    <a href="${pageContext.request.contextPath}/game?choice=open" class="button">Открыть сундук</a>
    <a href="${pageContext.request.contextPath}/game?choice=ignore" class="button">Игнорировать</a>
  </c:when>
</c:choose>
</body>
</html>