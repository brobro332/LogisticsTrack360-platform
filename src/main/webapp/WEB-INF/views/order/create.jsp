<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="max-width: 1100px;">
  <h4 class="mb-4 text-primary fw-bold">주문생성</h4>

  <form id="orderForm" action="${pageContext.request.contextPath}/order/create.do" method="post">
    <div class="mb-3">
      <label class="form-label">제목</label>
      <input type="text" name="title" class="form-control" required />
    </div>

    <div class="mb-3">
      <label class="form-label">설명</label>
      <textarea name="description" rows="3" class="form-control"></textarea>
    </div>

    <h4 class="mb-3 text-primary fw-semibold">아이템목록</h4>
    <table class="table table-bordered" id="itemTable">
      <thead class="table-light">
        <tr>
          <th>상품명</th>
          <th>수량</th>
          <th>단위</th>
          <th>중량</th>
          <th>HS코드</th>
          <th style="width: 80px;">삭제</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><input type="text" name="items[0].name" class="form-control" required /></td>
          <td><input type="number" name="items[0].quantity" class="form-control" required /></td>
          <td>
            <select name="items[0].unit" class="form-select">
              <option value="EA">EA</option>
              <option value="KG">KG</option>
            </select>
          </td>
          <td><input type="number" step="0.01" name="items[0].weight" class="form-control" /></td>
          <td><input type="text" name="items[0].hsCode" class="form-control" /></td>
          <td>
            <button type="button" class="btn btn-danger btn-sm" onclick="removeItemRow(this)">삭제</button>
          </td>
        </tr>
      </tbody>
    </table>

    <button type="button" class="btn btn-secondary mb-4" onclick="addItemRow()">아이템추가</button>

    <div class="d-flex justify-content-between align-items-center">
      <button type="submit" class="btn btn-primary">주문등록</button>
      <a href="${pageContext.request.contextPath}/order/list.do" class="text-decoration-none">&larr; 주문목록</a>
    </div>
  </form>
</div>

<script>
  let itemIndex = 1;

  function addItemRow() {
    const row = `
      <tr>
        <td><input type="text" name="items[` + itemIndex + `].name" class="form-control" required /></td>
        <td><input type="number" name="items[` + itemIndex + `].quantity" class="form-control" required /></td>
        <td>
          <select name="items[` + itemIndex + `].unit" class="form-select">
            <option value="EA">EA</option>
            <option value="KG">KG</option>
          </select>
        </td>
        <td><input type="number" step="0.01" name="items[` + itemIndex + `].weight" class="form-control" /></td>
        <td><input type="text" name="items[` + itemIndex + `].hsCode" class="form-control" /></td>
        <td><button type="button" class="btn btn-danger btn-sm" onclick="removeItemRow(this)">삭제</button></td>
      </tr>`;
    $('#itemTable tbody').append(row);
    itemIndex++;
  }

  function removeItemRow(button) {
    $(button).closest('tr').remove();
    reindexItemRows();
  }

  function reindexItemRows() {
    $('#itemTable tbody tr').each(function(index, row) {
      $(row).find('input, select').each(function() {
        const oldName = $(this).attr('name');
        if (oldName) {
          const newName = oldName.replace(/items\[\d+\]/g, `items[${index}]`);
          $(this).attr('name', newName);
        }
      });
    });
    itemIndex = $('#itemTable tbody tr').length;
  }

  $('#orderForm').on('submit', function() {
    $('#itemTable tbody tr input, #itemTable tbody tr select').each(function() {
      console.log($(this).attr('name'), $(this).val());
    });
  });
</script>
