<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-5" style="max-width: 900px;">
  <h2 class="mb-4 text-primary fw-bold">주문상세정보</h2>

  <table class="table table-bordered mb-4">
    <tbody>
      <tr>
        <th class="text-center" scope="row" style="width: 25%;">주문ID</th>
        <td>${order.orderId}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">제목</th>
        <td>${order.title}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">설명</th>
        <td>${order.description}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">상태</th>
        <td>
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
      </tr>
      <tr>
        <th class="text-center" scope="row">등록자ID</th>
        <td>${order.userId}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">등록자</th>
        <td>${order.userName}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">생성일시</th>
        <td>${order.createdAt}</td>
      </tr>
      <tr>
        <th class="text-center" scope="row">수정일시</th>
        <td>${order.updatedAt}</td>
      </tr>
    </tbody>
  </table>

  <h3 class="mb-3 text-primary fw-semibold">상품목록</h3>
  <table class="table table-bordered table-striped mb-4">
    <thead class="table-light">
      <tr>
        <th class="text-center">상품명</th>
        <th class="text-center">수량</th>
        <th class="text-center">단위</th>
        <th class="text-center">중량</th>
        <th class="text-center">HS코드</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${itemList}">
        <tr>
          <td>${item.name}</td>
          <td class="text-center">${item.quantity}</td>
          <td class="text-center">${item.unit}</td>
          <td class="text-center">${item.weight}</td>
          <td class="text-center">${item.hsCode}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <h3 class="mb-3 text-primary fw-semibold">상태이력</h3>
  <table class="table table-bordered table-striped">
    <thead class="table-light">
      <tr>
        <th class="text-center">상태</th>
        <th class="text-center">등록자</th>
        <th class="text-center">등록일시</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="history" items="${historyList}">
        <tr>
          <td class="text-center">
            <c:choose>
              <c:when test="${history.status eq 'READY'}">준비중</c:when>
              <c:when test="${history.status eq 'PICKUP'}">픽업요청</c:when>
              <c:when test="${history.status eq 'DISPATCHED'}">출고완료</c:when>
              <c:when test="${history.status eq 'DELIVERED'}">배송완료</c:when>
              <c:when test="${history.status eq 'COMPLETED'}">주문확정</c:when>
              <c:when test="${history.status eq 'DELETED'}">삭제완료</c:when>
              <c:otherwise>${history.status}</c:otherwise>
            </c:choose>
          </td>
          <td>${history.updatedBy}</td>
          <td class="text-center">${history.updatedAt}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
