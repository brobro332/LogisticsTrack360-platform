<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="join-container">
    <h2>회원가입</h2>

    <form action="${pageContext.request.contextPath}/user/join.do" method="post">
        <div class="form-group">
            <label for="userId">아이디</label>
            <input type="text" id="userId" name="userId" class="form-control" required placeholder="아이디를 입력하세요." />
        </div>

        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" class="form-control" required placeholder="비밀번호를 입력하세요." />
        </div>

        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" class="form-control" required placeholder="이름을 입력하세요." />
        </div>

        <div class="form-group">
            <label for="role">역할</label>
            <select id="role" name="role" class="form-control" required>
                <option value="">선택하세요</option>
                <option value="USER">일반 사용자</option>
                <option value="ADMIN">관리자</option>
            </select>
        </div>

        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" class="form-control" required placeholder="이메일을 입력하세요." />
        </div>

        <div class="form-group">
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" class="form-control" required placeholder="전화번호를 입력하세요." />
        </div>

        <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
    
    <div class="join-links">
        <a href="${pageContext.request.contextPath}/user/login.do">이미 계정이 있으신가요? 로그인</a>
    </div>
</div>

<script>
    $('#joinForm').on('submit', function(e) {
        e.preventDefault();

        const formData = {
            userId: $('#userId').val(),
            password: $('#password').val(),
            name: $('#name').val(),
            role: $('#role').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/join.do',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                alert("회원가입이 완료되었습니다.");
                window.location.href = '${pageContext.request.contextPath}/user/login.do';
            },
            error: function(xhr) {
                alert("회원가입 실패: " + xhr.responseText);
            }
        });
    });
</script>