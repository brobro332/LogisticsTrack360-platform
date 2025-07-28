<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container vh-100 d-flex align-items-center justify-content-center">
  <div class="card shadow-sm border-0" style="width: 100%; max-width: 400px;">
    <div class="card-body p-4">
      <h3 class="text-center mb-4 text-primary fw-bold">로그인</h3>

      <form action="${pageContext.request.contextPath}/login.do" method="POST">
        <div class="mb-3">
          <label for="username" class="form-label">아이디</label>
          <input type="text" id="username" name="username" class="form-control" required placeholder="아이디를 입력하세요.">
        </div>

        <div class="mb-3">
          <label for="password" class="form-label">비밀번호</label>
          <input type="password" id="password" name="password" class="form-control" required placeholder="비밀번호를 입력하세요.">
        </div>

        <button type="submit" class="btn btn-primary w-100">로그인</button>
      </form>

      <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/user/join.do" class="text-decoration-none text-secondary small">
          아직 회원이 아니신가요? 회원가입
        </a>
      </div>
    </div>
  </div>
</div>