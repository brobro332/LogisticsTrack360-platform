<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    request.setAttribute("username", username);
%>

<div class="container d-flex justify-content-between align-items-center" style="max-width: 900px;">
  
  <div class="d-flex align-items-center gap-4">
    <a href="${pageContext.request.contextPath}/main.do" class="text-white text-decoration-none fw-bold fs-4">
      LogisticsTrack360
    </a>
    <nav>
      <ul class="nav m-0">
        <li class="nav-item">
          <a href="${pageContext.request.contextPath}/user/profile.do" class="nav-link text-white px-2 py-0">
            프로필
          </a>
        </li>
      </ul>
    </nav>
  </div>

  <div class="d-flex align-items-center gap-3">
    <span class="fw-semibold">${username}</span>
    <a href="${pageContext.request.contextPath}/logout.do" class="btn btn-outline-light btn-sm">
      로그아웃
    </a>
  </div>
</div>
