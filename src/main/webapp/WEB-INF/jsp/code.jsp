<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="!isAuthenticated()">
    <%
        response.sendRedirect("/login");
    %>
</sec:authorize>

<!DOCTYPE HTML>
<html>
<head>
    <title>User</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/user.css"/>
    <link rel="stylesheet"
          href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/styles/default.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/highlight.min.js"></script>
</head>
<body>
<main>
    <div>
        <p>Мои алгоритмы:</p>
        <ul class="files">
            <c:forEach items="${codeFiles}" var="file">
                <li class="classFile" id="${file.uuid}">${file.name}</li>
            </c:forEach>
        </ul>
    </div>
    <div>
        <p><img src="circle-user-man-dark-7-512.png" width="25" height="25"/>${username}</p>
        <div class="nameHolder">
            <label for="className">Название</label>
            <input id="className" type="text" name="className" value="Algo1" class="name"/>
        </div>
        <pre><code class="java" contentEditable="true" style="background: none;">${codeFile.text}</code></pre>
        <div class="buttons">
            <form method="post" action="/code">
                <input type="submit" name="save" value="Сохранить"/>
                <input id="hidden" type="hidden" name="uuid" value="${codeFile.uuid}"/>
            </form>
            <button type="button" name="remove">Удалить</button>
        </div>
    </div>
</main>
<footer>
    <p>Ошибки:</p>
    <code>${codeFile.status}</code>
</footer>
<script src="${contextPath}/resources/js/jQuery.js"></script>
<script src="${contextPath}/resources/js/user.js"></script>
<script>hljs.initHighlightingOnLoad();</script>
</body>
</html>
