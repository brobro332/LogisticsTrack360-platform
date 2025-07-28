<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="max-width: 480px;">
  <h4 class="mb-4 text-primary fw-bold">운송등록</h4>

  <form action="${pageContext.request.contextPath}/shipment/create.do" method="post" class="needs-validation" novalidate>
    <div class="mb-3">
      <label for="orderId" class="form-label">주문ID</label>
      <input type="text" id="orderId" name="orderId" value="${orderId}" readonly class="form-control" />
    </div>

    <div class="mb-3">
      <label for="carrierName" class="form-label">운송사</label>
      <input type="text" id="carrierName" name="carrierName" class="form-control" />
    </div>

    <div class="mb-3">
      <label for="trackingNumber" class="form-label">송장번호</label>
      <input type="text" id="trackingNumber" name="trackingNumber" class="form-control" />
    </div>

    <div class="mb-3">
      <label for="shippedAt" class="form-label">발송일</label>
      <input type="datetime-local" id="shippedAt" name="shippedAt" class="form-control" />
    </div>

    <div class="mb-3">
      <label for="arrivalEstimate" class="form-label">도착예정일</label>
      <input type="date" id="arrivalEstimate" name="arrivalEstimate" class="form-control" />
    </div>

    <div class="mb-3">
      <label for="shipmentStatus" class="form-label">상태</label>
      <select id="shipmentStatus" name="shipmentStatus" class="form-select">
        <option value="READY">준비중</option>
        <option value="IN_TRANSIT">배송중</option>
        <option value="DELIVERED">배송완료</option>
      </select>
    </div>

    <button type="submit" class="btn btn-primary w-100">등록</button>
  </form>
</div>
