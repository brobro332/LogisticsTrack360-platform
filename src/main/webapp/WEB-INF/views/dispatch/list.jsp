<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="dispatch-container">
    <h2>출고관리</h2>

    <form id="dispatchForm" action="${pageContext.request.contextPath}/dispatch/create.do" method="post">
        <h3>출고할 주문 선택</h3>
        <table border="1" style="border-collapse: collapse; width: 100%;">
            <thead>
                <tr>
                    <th>선택</th>
                    <th>주문ID</th>
                    <th>제목</th>
                    <th>상태</th>
                    <th>등록자</th>
                    <th>생성일시</th>
                    <th>출고 창고명</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <c:if test="${order.status == 'READY' || order.status == 'PICKUP'}">
                        <tr>
                            <td>
                                <input type="checkbox" name="selectedOrderIds" value="${order.orderId}" class="order-checkbox" />
                            </td>
                            <td>${order.orderId}</td>
                            <td>${order.title}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.status eq 'READY'}">준비중</c:when>
                                    <c:when test="${order.status eq 'PICKUP'}">픽업요청</c:when>
                                    <c:otherwise>${order.status}</c:otherwise>
                                </c:choose>
                            </td>
                            <td>${order.userName} (${order.userId})</td>
                            <td>${order.createdAt}</td>
                            <td>
                                <input type="text" name="warehouseNames" placeholder="창고명입력" disabled />
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                <c:if test="${empty orderList}">
                    <tr><td colspan="7">출고 대상 주문이 없습니다.</td></tr>
                </c:if>
            </tbody>
        </table>
        
        <br />
        
   		<h3>출고 완료 목록</h3>
		<table border="1" style="border-collapse: collapse; width: 100%;">
		    <thead>
		        <tr>
		            <th>출고ID</th>
		            <th>주문ID</th>
		            <th>창고명</th>
		            <th>출고일</th>
		            <th>출고 담당자</th>
		            <th>생성일시</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="dispatch" items="${dispatchList}">
		            <tr>
		                <td>${dispatch.dispatchId}</td>
		                <td>${dispatch.orderId}</td>
		                <td>${dispatch.warehouseName}</td>
		                <td>${dispatch.dispatchDate}</td>
		                <td>${dispatch.dispatcher}</td>
		                <td>${dispatch.createdAt}</td>
		            </tr>
		        </c:forEach>
		        <c:if test="${empty dispatchList}">
		            <tr><td colspan="7">출고 완료 내역이 없습니다.</td></tr>
		        </c:if>
		    </tbody>
		</table>

        <br />
        <button type="submit">출고등록</button>
    </form>
</div>

<script>
    const checkboxes = document.querySelectorAll('.order-checkbox');
    checkboxes.forEach((cb, idx) => {
        cb.addEventListener('change', function() {
            const warehouseInput = this.closest('tr').querySelector('input[name="warehouseNames"]');
            warehouseInput.disabled = !this.checked;
            if (!this.checked) {
                warehouseInput.value = '';
            }
        });
    });

    document.getElementById('dispatchForm').addEventListener('submit', function(e) {
        const checkedBoxes = document.querySelectorAll('.order-checkbox:checked');
        if (checkedBoxes.length === 0) {
            e.preventDefault();
            alert('하나 이상의 주문을 선택하세요.');
            return;
        }
        for (const cb of checkedBoxes) {
            const warehouseInput = cb.closest('tr').querySelector('input[name="warehouseNames"]');
            if (!warehouseInput.value.trim()) {
                e.preventDefault();
                alert('선택한 주문에 대한 창고명을 모두 입력하세요.');
                warehouseInput.focus();
                return;
            }
        }
    });
</script>
