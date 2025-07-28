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

<div class="order-container">
    <h2>주문관리</h2>

    <div class="form-group">
        <a href="${pageContext.request.contextPath}/order/create.do">주문생성</a>
    </div>

    <table border="1" style="border-collapse: collapse;">
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
                            <c:when test="${order.status eq 'DELIVERED'}">배송완료</c:when>
                            <c:when test="${order.status eq 'COMPLETED'}">주문확정</c:when>
                            <c:when test="${order.status eq 'DELETED'}">삭제완료</c:when>
                            <c:otherwise>${order.status}</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${order.userName} (${order.userId})</td>
                    <td>${order.createdAt}</td>
                    <td>
                        <button type="button" onclick="viewDetail('${order.orderId}')">상세</button>
                        <c:if test="${isAdmin}">
                        	<button type="button" onclick="updateStatus('${order.orderId}')">상태변경</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<c:if test="${isAdmin}">
	<div id="statusModal" style="display:none;">
	    <div style="background-color: white; padding: 20px; border: 1px solid #ccc; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);">
	        <h3>상태변경</h3>
	        <label for="statusSelect">상태선택</label>
	        <select id="statusSelect">
	        	<option value="READY">준비중</option>
	            <option value="PICKUP">픽업요청</option>
	            <option value="DISPATCHED">출고완료</option>
	            <option value="DELIVERED">배송완료</option>
	            <option value="COMPLETED">주문확정</option>
	            <option value="DELETED">삭제완료</option>
	        </select><br><br>
	
	        <button type="button" onclick="submitStatusChange()">상태변경</button>
	        <button type="button" onclick="closeModal()">취소</button>
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
        document.getElementById('statusModal').style.display = 'block';  // Modal 표시
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

        closeModal();
    }

    function closeModal() {
        document.getElementById('statusModal').style.display = 'none';
    }
</script>
