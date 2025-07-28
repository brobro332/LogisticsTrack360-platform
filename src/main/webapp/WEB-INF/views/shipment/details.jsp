<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="max-width: 600px;">
  <h4 class="mb-4 text-center text-primary fw-bold">운송 상세/수정</h4>

  <form action="${pageContext.request.contextPath}/shipment/update.do" method="post" class="needs-validation" novalidate>
    <input type="hidden" name="shipmentId" value="${shipment.shipmentId}">

    <div class="mb-3">
      <label for="orderId" class="form-label">주문ID</label>
      <input type="text" id="orderId" name="orderId" class="form-control" value="${shipment.orderId}" readonly>
    </div>

    <div class="mb-3">
      <label for="carrierName" class="form-label">운송사</label>
      <input type="text" id="carrierName" name="carrierName" class="form-control" value="${shipment.carrierName}">
    </div>

    <div class="mb-3">
      <label for="trackingNumber" class="form-label">송장번호</label>
      <input type="text" id="trackingNumber" name="trackingNumber" class="form-control" value="${shipment.trackingNumber}">
    </div>

    <div class="mb-3">
      <label for="shippedAt" class="form-label">발송일</label>
      <input type="datetime-local" id="shippedAt" name="shippedAt" class="form-control" value="${shipment.shippedAt}">
    </div>

    <div class="mb-3">
      <label for="arrivalEstimate" class="form-label">도착예정일</label>
      <input type="date" id="arrivalEstimate" name="arrivalEstimate" class="form-control" value="${shipment.arrivalEstimate}">
    </div>

    <div class="mb-4">
      <label for="shipmentStatus" class="form-label">상태</label>
      <select id="shipmentStatus" name="shipmentStatus" class="form-select">
		<option value="READY" ${shipment.shipmentStatus == 'READY' ? 'selected' : ''}>준비중</option>
		<option value="IN_TRANSIT" ${shipment.shipmentStatus == 'IN_TRANSIT' ? 'selected' : ''}>배송중</option>
		<option value="DELIVERED" ${shipment.shipmentStatus == 'DELIVERED' ? 'selected' : ''}>배송완료</option>
      </select>
    </div>

    <div class="d-grid">
      <button type="submit" class="btn btn-primary btn-lg">수정</button>
    </div>
  </form>
</div>
