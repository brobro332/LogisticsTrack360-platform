<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="login-container">
    <h2>로그인</h2>
    
    <form action="${pageContext.request.contextPath}/login.do" method="POST">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" class="form-control" required placeholder="아이디를 입력하세요." />
        </div>

        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" class="form-control" required placeholder="비밀번호를 입력하세요." />
        </div>

        <button type="submit" class="btn btn-primary">로그인</button>
    </form>

    <div class="login-links">
        <a href="${pageContext.request.contextPath}/user/join.do">회원가입</a>
    </div>
</div>
