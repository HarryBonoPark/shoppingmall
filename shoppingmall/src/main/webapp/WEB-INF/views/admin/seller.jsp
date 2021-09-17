<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 판매자</title>
    <link rel="stylesheet" href="/assets/css/table.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/seller.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">판매자 관리</h1>
    <div>
        <table class="seller_table">
            <tbody>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="seller_id"></td>
                    <td><button id="id_check">중복확인</button></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="seller_pwd"></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" id="seller_pwd_confirm"></td>
                </tr>
                <tr>
                    <td>업체명</td>
                    <td><input type="text" id="seller_name"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" id="seller_address"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" id="seller_email"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" id="seller_phone"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button id="regist">등록하기</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="seller_list">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>
                    <td>업체명</td>
                    <td>주소</td>
                    <td>이메일</td>
                    <td>전화번호</td>
                    <td>등급</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="seller_list_body">

            </tbody>
        </table>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
