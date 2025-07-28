<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="padding: 30px;">
  <h2>프로필</h2>
  
  <table border="1" style="border-collapse: collapse; width: 400px;">
    <tr>
      <th>사용자ID</th>
      <td><c:out value="${userInfo.userId}"/></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><c:out value="${userInfo.name}"/></td>
    </tr>
    <tr>
      <th>역할</th>
      <td><c:out value="${userInfo.role}"/></td>
    </tr>
    <tr>
      <th>이메일</th>
      <td><c:out value="${userInfo.email}"/></td>
    </tr>
    <tr>
      <th>전화번호</th>
      <td><c:out value="${userInfo.phone}"/></td>
    </tr>
  </table>
</div>	