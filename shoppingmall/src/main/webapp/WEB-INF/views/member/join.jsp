<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마켓컬리 :: 회원가입</title>
    <link rel="stylesheet" href="/assets/css/join.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/join.js"></script>
    <script>
        <c:if test="${member != null}">
            location.href = "/";
        </c:if>
    </script>
</head>
<body>

    <h1 class="title">회원가입</h1>
    <p><span class="red">*</span> 표시 항목은 필수 입력 항목입니다.</p>
    <table class="join_table">
        <tbody>
            <tr>
                <td>아이디 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="text" id="member_id">
                </td>
                <td>
                    <button id="check_id">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>비밀번호 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="password" id="member_pwd">
                </td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td colspan="3">
                    <input type="password" id="member_pwd_confirm">
                </td>
            </tr>
            <tr>
                <td>이름 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="text" id="member_name">
                </td>
            </tr>
            <tr>
                <td>이메일 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="text" id="member_email">
                </td>
                <td>
                    <button id="check_email">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>생년월일 <span class="red">*</span></td>
                <td>
                    <input type="text" id="member_birth_year">
                    <span>년</span>
                </td>
                <td>
                    <input type="text" id="member_birth_month">
                    <span>월</span>
                </td>
                <td>
                    <input type="text" id="member_birth_date">
                    <span>일</span>
                </td>
            </tr>
            <tr>
                <td>성별 <span class="red">*</span></td>
                <td colspan="3">
                    <select id="member_gen">
                        <option value="0">남</option>
                        <option value="1">여</option>
                        <option value="2">선택안함</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>주소 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="text" id="member_address">
                </td>
            </tr>
            <tr>
                <td>전화번호 <span class="red">*</span></td>
                <td colspan="3">
                    <input type="text" id="member_phone" placeholder="'-'는 제외하고 입력해주세요.">
                </td>
            </tr>
            <tr>
                <td>카드번호</td>
                <td colspan="3">
                    <input type="text" id="member_card">
                </td>
            </tr>
            <tr>
                <td>계좌번호</td>
                <td colspan="3">
                    <input type="text" id="member_account">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="join">회원가입</button>
                </td>
            </tr>
        </tbody>
    </table>
    
    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>