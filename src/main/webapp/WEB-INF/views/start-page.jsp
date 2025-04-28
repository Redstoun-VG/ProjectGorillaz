<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Лавкрафтовский кошмар</title>
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
      margin-top: 10px;
    }
  </style>
</head>
<body>
<h1>Тьма над Аркхэмом</h1>
<p>1926 год. В старинном городке Аркхэм происходят странные события. Люди пропадают без вести,
  а те, кто возвращается, рассказывают о неописуемых ужасах и вскоре сходят с ума.
  Вы - исследователь паранормальных явлений, прибывший расследовать эти случаи.</p>

<form action="${pageContext.request.contextPath}/start" method="post">
  <label for="playerName">Ваше имя:</label>
  <input type="text" id="playerName" name="playerName" required>
  <button type="submit" class="button">Начать расследование</button>
</form>
</body>
</html>