<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<sec:authorize access="hasRole('ADMIN')">
  <%
    response.sendRedirect("/main");
  %>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
  <%
    response.sendRedirect("/login");
  %>
</sec:authorize>
<sec:authorize access="isAuthenticated() && !hasRole('ADMIN')">
  <%
    response.sendRedirect("/code");
  %>
</sec:authorize>