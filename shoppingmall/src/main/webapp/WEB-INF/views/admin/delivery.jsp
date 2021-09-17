<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 배송업체</title>
    <link rel="stylesheet" href="/assets/css/table.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/delivery.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">배송업체 관리</h1>
    <div>
        <table class="delivery_table">
            <tbody>
                <tr>
                    <td>배송사 명</td>
                    <td><input type="text" id="delivery_name"></td>
                    <td><button id="check_name">중복확인</button></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" id="delivery_phone"></td>
                </tr>
                <tr>
                    <td>배송비</td>
                    <td><input type="text" id="delivery_price"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button id="delivery_add">등록하기</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="delivery_list">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>배송사 명</td>
                    <td>전화번호</td>
                    <td>배송비</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="delivery_list_body">

            </tbody>
        </table>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
