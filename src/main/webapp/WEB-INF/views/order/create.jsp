<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="order-container">
    <h2>주문생성</h2>

    <form id="orderForm" action="${pageContext.request.contextPath}/order/create.do" method="post">
        <div>
            <label>제목</label>
            <input type="text" name="title" required />
        </div>

        <div>
            <label>설명</label>
            <textarea name="description" rows="3" cols="50"></textarea>
        </div>

        <h3>아이템목록</h3>
        <table border="1" id="itemTable" style="border-collapse: collapse;">
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>단위</th>
                    <th>중량</th>
                    <th>HS코드</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="items[0].name" required /></td>
                    <td><input type="number" name="items[0].quantity" required /></td>
                    <td>
                        <select name="items[0].unit">
                            <option value="EA">EA</option>
                            <option value="KG">KG</option>
                        </select>
                    </td>
                    <td><input type="number" step="0.01" name="items[0].weight" /></td>
                    <td><input type="text" name="items[0].hsCode" /></td>
                    <td><button type="button" onclick="removeItemRow(this)">삭제</button></td>
                </tr>
            </tbody>
        </table>
        <button type="button" onclick="addItemRow()">아이템추가</button>

        <br><br>
        <button type="submit">주문등록</button>
        <a href="${pageContext.request.contextPath}/order/list.do">← 목록으로</a>
    </form>
</div>

<script>
    let itemIndex = 1;

    function addItemRow() {
        const row = `
            <tr>
                <td><input type="text" name="items[` + itemIndex + `].name" required /></td>
                <td><input type="number" name="items[` + itemIndex + `].quantity" required /></td>
                <td>
                    <select name="items[` + itemIndex + `].unit">
                        <option value="EA">EA</option>
                        <option value="KG">KG</option>
                    </select>
                </td>
                <td><input type="number" step="0.01" name="items[` + itemIndex + `].weight" /></td>
                <td><input type="text" name="items[` + itemIndex + `].hsCode" /></td>
                <td><button type="button" onclick="removeItemRow(this)">삭제</button></td>
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