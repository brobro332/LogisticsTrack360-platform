<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <h4 class="mb-4 text-primary fw-bold">출고완료목록</h4>

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
              <c:when test="${order.status eq 'DELIVERED'}">배송중</c:when>
              <c:when test="${order.status eq 'COMPLETED'}">완료</c:when>
              <c:otherwise>${order.status}</c:otherwise>
            </c:choose>
          </td>
          <td>${order.userName} (${order.userId})</td>
          <td class="text-center">${order.createdAt}</td>
          <td class="text-center">
            <a href="${pageContext.request.contextPath}/shipment/create.do?orderId=${order.orderId}" class="btn btn-sm btn-outline-primary">
              운송등록
            </a>
          </td>
        </tr>
      </c:forEach>
      <c:if test="${empty orderList}">
        <tr>
          <td colspan="6" class="text-center">출고 완료 상태 주문이 없습니다.</td>
        </tr>
      </c:if>
    </tbody>
  </table>

  <h4 class="mt-5 mb-4 text-primary fw-bold">운송목록</h4>

  <table class="table table-bordered table-hover align-middle">
    <thead class="table-light">
      <tr>
        <th class="text-center">운송ID</th>
        <th class="text-center">주문ID</th>
        <th class="text-center">운송사</th>
        <th class="text-center">송장번호</th>
        <th class="text-center">발송일</th>
        <th class="text-center">도착예정일</th>
        <th class="text-center">상태</th>
        <th class="text-center">수정</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="shipment" items="${shipmentList}">
        <tr>
          <td class="text-center">${shipment.shipmentId}</td>
          <td class="text-center">${shipment.orderId}</td>
          <td>${shipment.carrierName}</td>
          <td>${shipment.trackingNumber}</td>
          <td class="text-center">${shipment.shippedAt}</td>
          <td class="text-center">${shipment.arrivalEstimate}</td>
          <td class="text-center">
	          <c:choose>
			    <c:when test="${shipment.shipmentStatus == 'READY'}">준비중</c:when>
			    <c:when test="${shipment.shipmentStatus == 'IN_TRANSIT'}">배송중</c:when>
			    <c:when test="${shipment.shipmentStatus == 'DELIVERED'}">배송완료</c:when>
			    <c:otherwise>${shipment.shipmentStatus}</c:otherwise>
			  </c:choose>
		  </td>
          <td class="text-center">
            <a href="${pageContext.request.contextPath}/shipment/details.do?shipmentId=${shipment.shipmentId}" class="btn btn-sm btn-outline-secondary">
              상세/수정
            </a>
          </td>
        </tr>
      </c:forEach>
      <c:if test="${empty shipmentList}">
        <tr>
          <td colspan="8" class="text-center">운송 내역이 없습니다.</td>
        </tr>
      </c:if>
    </tbody>
  </table>
</div>
