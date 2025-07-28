<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <h4 class="mb-4 text-primary fw-bold">출고관리</h4>

  <form id="dispatchForm" action="${pageContext.request.contextPath}/dispatch/create.do" method="post">
    <h6 class="mb-3">출고대상목록</h6>

    <table class="table table-bordered table-hover align-middle">
      <thead class="table-light">
        <tr>
          <th class="text-center" style="width: 60px;">선택</th>
          <th class="text-center">주문ID</th>
          <th class="text-center">제목</th>
          <th class="text-center">상태</th>
          <th class="text-center">등록자</th>
          <th class="text-center">생성일시</th>
          <th class="text-center">출고창고명</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="order" items="${orderList}">
          <c:if test="${order.status == 'READY' || order.status == 'PICKUP'}">
            <tr>
              <td class="text-center">
                <input type="checkbox" name="selectedOrderIds" value="${order.orderId}" class="order-checkbox form-check-input" />
              </td>
              <td class="text-center">${order.orderId}</td>
              <td>${order.title}</td>
              <td class="text-center">
                <c:choose>
                  <c:when test="${order.status eq 'READY'}">준비중</c:when>
                  <c:when test="${order.status eq 'PICKUP'}">픽업요청</c:when>
                  <c:otherwise>${order.status}</c:otherwise>
                </c:choose>
              </td>
              <td>${order.userName} (${order.userId})</td>
              <td class="text-center">${order.createdAt}</td>
              <td>
                <input type="text" name="warehouseNames" class="form-control form-control-sm" placeholder="창고명입력" disabled />
              </td>
            </tr>
          </c:if>
        </c:forEach>
        <c:if test="${empty orderList}">
          <tr><td colspan="7" class="text-center">출고 대상 주문이 없습니다.</td></tr>
        </c:if>
      </tbody>
    </table>

    <h6 class="mb-3 mt-5">출고완료목록</h6>
    <table class="table table-bordered table-hover align-middle">
      <thead class="table-light">
        <tr>
          <th class="text-center">출고ID</th>
          <th class="text-center">주문ID</th>
          <th class="text-center">창고명</th>
          <th class="text-center">출고일</th>
          <th class="text-center">출고 담당자</th>
          <th class="text-center">생성일시</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dispatch" items="${dispatchList}">
          <tr>
            <td class="text-center">${dispatch.dispatchId}</td>
            <td class="text-center">${dispatch.orderId}</td>
            <td>${dispatch.warehouseName}</td>
            <td class="text-center">${dispatch.dispatchDate}</td>
            <td>${dispatch.dispatcher}</td>
            <td class="text-center">${dispatch.createdAt}</td>
          </tr>
        </c:forEach>
        <c:if test="${empty dispatchList}">
          <tr><td colspan="6" class="text-center">출고 완료 내역이 없습니다.</td></tr>
        </c:if>
      </tbody>
    </table>

    <button type="submit" class="btn btn-primary">출고등록</button>
  </form>
</div>

<script>
  const checkboxes = document.querySelectorAll('.order-checkbox');
  checkboxes.forEach((cb) => {
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
