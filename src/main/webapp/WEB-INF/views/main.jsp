<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    request.setAttribute("username", username);
%>

<div class="container" style="padding: 30px;">
  <h2>환영합니다, ${username} 님!</h2>
  <p>물류 오더 관리 시스템에 오신 것을 환영합니다.</p>
</div>
