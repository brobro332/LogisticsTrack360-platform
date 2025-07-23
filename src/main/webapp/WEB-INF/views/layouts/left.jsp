<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = false;
    for (GrantedAuthority authority : auth.getAuthorities()) {
        if ("ROLE_ADMIN".equals(authority.getAuthority())) {
            isAdmin = true;
            break;
        }
    }
    request.setAttribute("isAdmin", isAdmin);
%>

<aside class="sidebar">
    <nav>
        <ul>
            <li><a href="#">내 오더 조회</a></li>
            <li><a href="#">오더 등록</a></li>

            <c:if test="${isAdmin}">
                <li><a href="#">전체 오더 관리</a></li>
                <li><a href="#">운송 정보 관리</a></li>
                <li><a href="#">통관 정보 관리</a></li>
                <li><a href="#">ERP 연동 로그</a></li>
                <li><a href="#">사용자 관리</a></li>
            </c:if>
        </ul>
    </nav>
</aside>
