<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Login</title>
  <link type="text/css" rel="stylesheet" href="${contextPath}/css/index.css"/>
</head>
<body>
<h1>Войти/регистрация</h1>
<div class="login">
  <form method="post" action="/login" name="login">
    <label for="username">Логин:</label>
    <input id="username" name="username" type="text" placeholder="Логин"/>
    <br/>
    <label for="password">Пароль</label>
    <input id="password" type="password" name="password" placeholder="Пароль"/>
    <br/>
    <input type="submit" name="Login" value="Войти" id="submit"/>
    <input type="hidden" name="check" value="random"/>
  </form>
</div>
</body>
</html>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3>${pageContext.request.userPrincipal.name}</h3>
  <sec:authorize access="!isAuthenticated()">
    <h4><a href="/login">Войти</a></h4>
    <h4><a href="/registration">Зарегистрироваться</a></h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Выйти</a></h4>
  </sec:authorize>
  <h4><a href="/news">Новости (только пользователь)</a></h4>
  <h4><a href="/admin">Пользователи (только админ)</a></h4>
</div>
</body>
</html>