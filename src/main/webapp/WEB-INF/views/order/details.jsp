<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="order-detail-container">
    <h2>주문상세정보</h2>

    <table border="1" style="border-collapse: collapse; width: 100%; max-width: 800px;">
        <tr><th>주문ID</th><td>${order.orderId}</td></tr>
        <tr><th>제목</th><td>${order.title}</td></tr>
        <tr><th>설명</th><td>${order.description}</td></tr>
        <tr>
            <th>상태</th>
            <td>
                <c:choose>
                    <c:when test="${order.status eq 'READY'}">준비중</c:when>
                    <c:when test="${order.status eq 'PICKUP'}">픽업요청</c:when>
                    <c:when test="${order.status eq 'DISPATCHED'}">출고완료</c:when>
                    <c:when test="${order.status eq 'DELIVERED'}">배송중</c:when>
                    <c:when test="${order.status eq 'COMPLETED'}">배송완료</c:when>
                    <c:when test="${order.status eq 'DELETED'}">삭제완료</c:when>
                    <c:otherwise>${order.status}</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr><th>등록자ID</th><td>${order.userId}</td></tr>
        <tr><th>등록자</th><td>${order.userName}</td></tr>
        <tr><th>생성일시</th><td>${order.createdAt}</td></tr>
        <tr><th>수정일시</th><td>${order.updatedAt}</td></tr>
    </table>

    <br>

    <h3>상품목록</h3>
    <table border="1" style="border-collapse: collapse; width: 100%; max-width: 800px;">
        <thead>
            <tr><th>상품명</th><th>수량</th><th>단위</th><th>중량</th><th>HS코드</th></tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${itemList}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.unit}</td>
                    <td>${item.weight}</td>
                    <td>${item.hsCode}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>

    <h3>상태이력</h3>
    <table border="1" style="border-collapse: collapse; width: 100%; max-width: 800px;">
        <thead>
            <tr><th>상태</th><th>수정자</th><th>수정일시</th></tr>
        </thead>
        <tbody>
            <c:forEach var="history" items="${historyList}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${history.status eq 'READY'}">준비중</c:when>
                            <c:when test="${history.status eq 'PICKUP'}">픽업요청</c:when>
                            <c:when test="${history.status eq 'DISPATCHED'}">출고완료</c:when>
                            <c:when test="${history.status eq 'DELIVERED'}">배송중</c:when>
                            <c:when test="${history.status eq 'COMPLETED'}">배송완료</c:when>
                            <c:when test="${history.status eq 'DELETED'}">삭제완료</c:when>
                            <c:otherwise>${history.status}</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${history.updatedBy}</td>
                    <td>${history.updatedAt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
