<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>출고 완료 주문 목록</h2>
<table border="1" style="border-collapse: collapse; width: 100%;">
    <thead>
        <tr>
            <th>주문ID</th>
            <th>제목</th>
            <th>상태</th>
            <th>등록자</th>
            <th>생성일시</th>
            <th>기능</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.title}</td>
                <td>
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
                <td>${order.createdAt}</td>
                <td>
				    <a href="${pageContext.request.contextPath}/shipment/create.do?orderId=${order.orderId}">
				        <button>운송등록</button>
				    </a>
				</td>
            </tr>
        </c:forEach>
        <c:if test="${empty orderList}">
            <tr><td colspan="5">출고 완료 상태 주문이 없습니다.</td></tr>
        </c:if>
    </tbody>
</table>

<br/>

<h2>운송목록</h2>

<table border="1" style="border-collapse: collapse; width: 100%;">
    <thead>
        <tr>
            <th>운송ID</th>
            <th>주문ID</th>
            <th>운송사</th>
            <th>송장번호</th>
            <th>발송일</th>
            <th>도착예정일</th>
            <th>상태</th>
            <th>수정</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="shipment" items="${shipmentList}">
            <tr>
                <td>${shipment.shipmentId}</td>
                <td>${shipment.orderId}</td>
                <td>${shipment.carrierName}</td>
                <td>${shipment.trackingNumber}</td>
                <td>${shipment.shippedAt}</td>
                <td>${shipment.arrivalEstimate}</td>
                <td>${shipment.shipmentStatus}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/shipment/details.do?shipmentId=${shipment.shipmentId}">상세/수정</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>