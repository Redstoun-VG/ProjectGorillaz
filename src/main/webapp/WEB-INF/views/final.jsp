<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Конец истории</title>
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
      margin-top: 20px;
    }
    .madness { color: #ff0000; font-weight: bold; }
    .safe { color: #00aa00; }
  </style>
</head>
<body>
<h1>Конец вашего пути</h1>

<c:choose>
  <c:when test="${gameState.mad}">
    <p class="madness">${description}</p>
    <p>Вы проиграли, как и многие до вас. Древние боги не прощают любопытных.</p>
  </c:when>
  <c:otherwise>
    <p class="safe">${description}</p>
    <p>Вы выжили, но какие тайны остались нераскрытыми?..</p>
  </c:otherwise>
</c:choose>

<p>Игр сыграно: ${gameState.gamesPlayed}</p>

<a href="${pageContext.request.contextPath}/start" class="button">Начать заново</a>
</body>
</html>