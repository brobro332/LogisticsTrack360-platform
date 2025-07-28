<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class="container">
  <div class="card-body">
    <div class="d-flex justify-content-between align-items-center mb-4">
      <h4 class="text-primary fw-bold">주문관리</h4>
      <a href="${pageContext.request.contextPath}/order/create.do" class="btn btn-primary btn-sm">
        주문 생성
      </a>
    </div>

    <div class="table-responsive">
      <table class="table table-bordered table-hover align-middle">
        <thead class="table-light">
          <tr>
            <th class="text-center">주문ID</th>
            <th class="text-center">제목</th>
            <th class="text-center">상태</th>
            <th class="text-center">등록자</th>
            <th class="text-center">생성일시</th>
            <th class="text-center">기능</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="order" items="${orderList}">
            <tr>
              <td class="text-center">${order.orderId}</td>
              <td>${order.title}</td>
              <td class="text-center">
                <c:choose>
                  <c:when test="${order.status eq 'READY'}">준비중</c:when>
                  <c:when test="${order.status eq 'PICKUP'}">픽업요청</c:when>
                  <c:when test="${order.status eq 'DISPATCHED'}">출고완료</c:when>
                  <c:when test="${order.status eq 'DELIVERED'}">배송완료</c:when>
                  <c:when test="${order.status eq 'COMPLETED'}">주문확정</c:when>
                  <c:when test="${order.status eq 'DELETED'}">삭제완료</c:when>
                  <c:otherwise>${order.status}</c:otherwise>
                </c:choose>
              </td>
              <td>${order.userName} (${order.userId})</td>
              <td class="text-center">${order.createdAt}</td>
              <td class="text-center">
                <button class="btn btn-outline-primary btn-sm me-1" onclick="viewDetail('${order.orderId}')">상세</button>
                <c:if test="${isAdmin}">
                  <button class="btn btn-outline-secondary btn-sm" onclick="updateStatus('${order.orderId}')">상태변경</button>
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<c:if test="${isAdmin}">
  <div class="modal fade" id="statusModal" tabindex="-1" aria-labelledby="statusModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="statusModalLabel">상태변경</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
        </div>
        <div class="modal-body">
          <label for="statusSelect" class="form-label">상태</label>
          <select class="form-select" id="statusSelect">
            <option value="READY">준비중</option>
            <option value="PICKUP">픽업요청</option>
            <option value="DISPATCHED">출고완료</option>
            <option value="DELIVERED">배송완료</option>
            <option value="COMPLETED">주문확정</option>
            <option value="DELETED">삭제완료</option>
          </select>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
          <button type="button" class="btn btn-primary" onclick="submitStatusChange()">상태 변경</button>
        </div>
      </div>
    </div>
  </div>
</c:if>

<script>
  let currentOrderId = null;

  function viewDetail(orderId) {
    window.location.href = "${pageContext.request.contextPath}/order/details.do?orderId=" + encodeURIComponent(orderId);
  }

  function updateStatus(orderId) {
    currentOrderId = orderId;
    const modal = new bootstrap.Modal(document.getElementById('statusModal'));
    modal.show();
  }

  function submitStatusChange() {
    const status = document.getElementById('statusSelect').value;
    if (!status) {
      alert("상태를 선택하세요.");
      return;
    }

    $.ajax({
      url: "${pageContext.request.contextPath}/order/status.do",
      type: "POST",
      data: {
        orderId: currentOrderId,
        status: status
      },
      success: function () {
        alert("상태 변경 완료");
        location.reload();
      },
      error: function () {
        alert("상태 변경 실패");
      }
    });
  }
</script>
