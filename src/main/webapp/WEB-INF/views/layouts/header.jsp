<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    request.setAttribute("username", username);
%>

<header>
    <div class="logo">
        <a href="${pageContext.request.contextPath}/main.do">LogiticsTrack360</a>
    </div>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user/profile.do">내 정보 조회</a></li>
        </ul>
    </nav>
    <div class="user-info">
        <span>${username}</span>
        <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
    </div>
</header>