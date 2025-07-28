<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-5" style="max-width: 600px;">
  <div class="card shadow-sm border-0">
    <div class="card-body p-4">
      <h4 class="card-title text-center text-primary fw-bold mb-4">프로필</h4>

      <table class="table table-bordered align-middle">
        <tbody>
          <tr>
            <th class="bg-light text-center" style="width: 30%;">사용자ID</th>
            <td><c:out value="${userInfo.userId}" /></td>
          </tr>
          <tr>
            <th class="bg-light text-center">이름</th>
            <td><c:out value="${userInfo.name}" /></td>
          </tr>
          <tr>
            <th class="bg-light text-center">역할</th>
            <td><c:out value="${userInfo.role}" /></td>
          </tr>
          <tr>
            <th class="bg-light text-center">이메일</th>
            <td><c:out value="${userInfo.email}" /></td>
          </tr>
          <tr>
            <th class="bg-light text-center">전화번호</th>
            <td><c:out value="${userInfo.phone}" /></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
