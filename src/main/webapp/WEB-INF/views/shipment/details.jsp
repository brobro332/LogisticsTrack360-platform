<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>운송 상세/수정</h2>

<form action="${pageContext.request.contextPath}/shipment/update.do" method="post">
    <input type="hidden" name="shipmentId" value="${shipment.shipmentId}">

    <label>주문ID</label>
    <input type="text" name="orderId" value="${shipment.orderId}" readonly><br>

    <label>운송사</label>
    <input type="text" name="carrierName" value="${shipment.carrierName}"><br>

    <label>송장번호</label>
    <input type="text" name="trackingNumber" value="${shipment.trackingNumber}"><br>

    <label>발송일</label>
    <input type="datetime-local" name="shippedAt" value="${shipment.shippedAt}"><br>

    <label>도착예정일</label>
    <input type="date" name="arrivalEstimate" value="${shipment.arrivalEstimate}"><br>

    <label>상태</label>
    <select name="shipmentStatus">
        <option value="READY" ${shipment.shipmentStatus == 'READY' ? 'selected' : ''}>준비중</option>
        <option value="IN_TRANSIT" ${shipment.shipmentStatus == 'IN_TRANSIT' ? 'selected' : ''}>배송중</option>
        <option value="DELIVERED" ${shipment.shipmentStatus == 'DELIVERED' ? 'selected' : ''}>배송완료</option>
    </select><br>
    <br>
    <button type="submit">수정</button>
</form>
