<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마켓컬리 :: 로그인</title>
    <link rel="stylesheet" href="/assets/css/login.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/login.js"></script>
    <script>
        <c:if test="${member != null}">
            location.href = "/";
        </c:if>
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>

    <h1 class="title">로그인</h1>
    <table class="login_table">
        <tbody>
            <tr>
                <td colspan="4">
                    <input type="text" id="member_id" placeholder="아이디를 입력해주세요">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="password" id="member_pwd" placeholder="비밀번호를 입력해주세요">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="login">로그인</button>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="join" onclick="location.href='/join'">회원가입</button>
                </td>
            </tr>
        </tbody>
    </table>
    
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
