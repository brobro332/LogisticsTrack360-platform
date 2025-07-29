<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    request.setAttribute("username", username);
%>

<div class="container my-5" style="max-width: 900px;">
  <div class="bg-white border border-primary rounded-4 p-5">
    <div class="text-center mb-4">
      <i class="fas fa-dolly fa-3x text-primary mb-3"></i>
      <h4 class="fw-bold">환영합니다, <span class="text-primary">${username}</span> 님!</h4>
      <p class="text-secondary">물류 관리 시스템 LogisticsTrack360에 오신 것을 환영합니다.</p>
    </div>

    <div class="row justify-content-center">
      <div class="col-md-4 mb-4">
        <div class="border rounded-3 p-3 h-100">
          <h6 class="text-primary"><i class="fas fa-clipboard-list me-2"></i> 주문관리</h6>
          <p class="text-muted mb-0" style="font-size: 0.8rem;">주문등록 및 상태관리 기능</p>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="border rounded-3 p-3 h-100">
          <h6 class="text-primary"><i class="fas fa-flask me-2"></i> 학습용 MVP 버전</h6>
          <p class="text-muted mb-0" style="font-size: 0.8rem;">물류 도메인에 대한 이해를 위한 <br/> 최소한의 기능 구현</p>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="border rounded-3 p-3 h-100">
          <h6 class="text-primary"><i class="fas fa-route me-2"></i> 물류 프로세스 모사</h6>
          <p class="text-muted mb-0" style="font-size: 0.8rem;">주문 → 픽업 → 출고 → 운송 등 <br/> 주요 흐름을 단순화하여 구현</p>
        </div>
      </div>
    </div>
    <div class="text-center">
      <a href="${pageContext.request.contextPath}/order/list.do" class="btn btn-primary px-4 py-2">
        시작하기
      </a>
    </div>
  </div>
</div>