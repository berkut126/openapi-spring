<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<sec:authorize access="isAuthenticated()">
  <%
    if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
            .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))){
      response.sendRedirect("/main");
    }
    else{
      response.sendRedirect("/user");
    }
  %>
</sec:authorize>

<!DOCTYPE HTML>
<html>
<head>
  <title>Login</title>
  <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/index.css"/>
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
