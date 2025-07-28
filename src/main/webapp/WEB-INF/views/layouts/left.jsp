<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<style>
  .sidebar {
   	width: 219px;
    background-color: #e9f0fb;
    border-right: 0;
  }
  
  .sidebar nav ul {
    list-style: none;
    padding-left: 0;
  }
  
  .sidebar nav ul li a {
    color: #0d6efd;
    font-weight: 600;
    text-decoration: none;
    display: block;
    padding: 0.5rem 1.25rem;
    border-radius: 0.375rem;
    transition: background-color 0.2s ease;
    text-overflow: ellipsis;
  }
  .sidebar nav ul li a:hover,
  .sidebar nav ul li a.active {
    background-color: #0d6efd;
    color: white;
  }
</style>

<aside class="sidebar">
  <nav>
    <ul>
      <li>
        <a href="${pageContext.request.contextPath}/order/list.do"
           class="<c:if test='${fn:contains(pageContext.request.servletPath, "/order") }'>active</c:if>">
          주문관리
        </a>
      </li>
      <c:if test="${isAdmin}">
        <li>
          <a href="${pageContext.request.contextPath}/dispatch/list.do"
             class="<c:if test='${fn:contains(pageContext.request.servletPath, "/dispatch") }'>active</c:if>">
            출고관리
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/shipment/list.do"
             class="<c:if test='${fn:contains(pageContext.request.servletPath, "/shipment") }'>active</c:if>">
            운송관리
          </a>
        </li>
      </c:if>
    </ul>
  </nav>
</aside>