<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>운송 등록</h2>

<form action="${pageContext.request.contextPath}/shipment/create.do" method="post">
    <label>주문ID</label>
    <input type="text" id="orderId" name="orderId" value="${orderId}" readonly /><br>

    <label>운송사</label>
    <input type="text" name="carrierName"><br>

    <label>송장번호</label>
    <input type="text" name="trackingNumber"><br>

    <label>발송일</label>
    <input type="datetime-local" name="shippedAt"><br>

    <label>도착예정일</label>
    <input type="date" name="arrivalEstimate"><br>

    <label>상태</label>
    <select name="shipmentStatus">
        <option value="READY">준비중</option>
        <option value="IN_TRANSIT">배송중</option>
        <option value="DELIVERED">배송완료</option>
    </select><br>
    <br>
    <button type="submit">등록</button>
</form>