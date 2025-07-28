<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = false;
    for (GrantedAuthority authority : auth.getAuthorities()) {
        if ("ADMIN".equals(authority.getAuthority())) {
            isAdmin = true;
            break;
        }
    }
    request.setAttribute("isAdmin", isAdmin);
%>

<aside class="sidebar">
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/order/list.do">주문관리</a></li>

            <c:if test="${isAdmin}">
                <li><a href="${pageContext.request.contextPath}/dispatch/list.do">출고관리</a></li>
                <li><a href="#">운송관리</a></li>
                <li><a href="#">통관관리</a></li>
            </c:if>
        </ul>
    </nav>
</aside>
