<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container my-5" style="max-width: 500px;">
  <div class="card shadow-sm border-0">
    <div class="card-body p-3">
      <h3 class="text-center mb-2 text-primary fw-bold">회원가입</h3>

      <form action="${pageContext.request.contextPath}/user/join.do" method="post">
        <div class="mb-3">
          <label for="userId" class="form-label">아이디</label>
          <input type="text" id="userId" name="userId" class="form-control" required placeholder="아이디를 입력하세요.">
        </div>

        <div class="mb-3">
          <label for="password" class="form-label">비밀번호</label>
          <input type="password" id="password" name="password" class="form-control" required placeholder="비밀번호를 입력하세요.">
        </div>

        <div class="mb-3">
          <label for="name" class="form-label">이름</label>
          <input type="text" id="name" name="name" class="form-control" required placeholder="이름을 입력하세요.">
        </div>

        <div class="mb-3">
          <label for="role" class="form-label">역할</label>
          <select id="role" name="role" class="form-select" required>
            <option value="">선택하세요</option>
            <option value="CUSTOMER">협력사</option>
            <option value="ADMIN">관리자</option>
          </select>
        </div>

        <div class="mb-3">
          <label for="email" class="form-label">이메일</label>
          <input type="email" id="email" name="email" class="form-control" required placeholder="이메일을 입력하세요.">
        </div>

        <div class="mb-3">
          <label for="phone" class="form-label">전화번호</label>
          <input type="text" id="phone" name="phone" class="form-control" required placeholder="전화번호를 입력하세요.">
        </div>

        <button type="submit" class="btn btn-primary w-100">회원가입</button>
      </form>

      <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/user/login.do" class="text-decoration-none text-secondary small">
          이미 계정이 있으신가요? 로그인
        </a>
      </div>
    </div>
  </div>
</div>
