<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<sec:authorize access="!isAuthenticated()">
    <%
        response.sendRedirect("/login");
    %>
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/main.css"/>
</head>
<body>
<header>
    <div id="one">Управление системой</div>
    <div id="two">Управление хранилищем</div>
</header>
<main>
    <div class="stuff">
        <ul class="folders">
            <li>
                <span>Алгоритмы</span>
                <c:forEach items="${allUsers}" var="user">
                    <ul class="users">
                        <li>
                            <span class="username">${user.username}</span>
                            <ul class="files">
                                <c:forEach items="${user.files}" var="file">
                                    <li class="classFile" id="${file.uuid}">${file.name}</li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                </c:forEach>
            </li>
        </ul>
        <ul class="userList">
            <c:forEach items="${allUsers}" var="user">
                <li class="username">${user.username}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="user">
        <form name="userInfo">
            <label for="rights">Права:</label>
            <select id="rights" name="rights">
                <c:forEach items="${allRights}" var="perm">
                    <option value="${perm.name}">${perm.text}</option>
                </c:forEach>
            </select>
            <br/>
            <label for="block">Блокировать</label>
            <input id="block" type="range" name="block" value="1" max="1" min="0" class="slider"/>
            <br/>
            <input id="delete" type="checkbox" name="delete" value="true">Удалить</input>
            <br/>
            <input id="submit" type="submit" name="submit" value="Применить"/>
        </form>
    </div>
    <div class="file">
				<textarea class="code">
				</textarea>
        <button type="button" name="remove" id="remove">Удалить</button>
    </div>
    <div class="storage">
        <form name="storageSettings">
            <label for="signUp">Регистрация новых пользователей:</label>
            <input id="signUp" type="range" name="signUp" value="1" min="0" max="1" class="slider"/>
            <br/>
            <label for="change">Внесение изменений в хранилище:</label>
            <input id="change" type="range" name="change" value="1" min="0" max="1" class="slider"/>
        </form>
    </div>
</main>
</body>
<script src="${contextPath}/resources/js/jQuery.js"></script>
<script src="${contextPath}/resources/js/main.js"></script>
</html>
