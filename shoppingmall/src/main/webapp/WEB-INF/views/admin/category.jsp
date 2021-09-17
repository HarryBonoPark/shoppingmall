<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 카테고리</title>
    <link rel="stylesheet" href="/assets/css/admin.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/category.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">카테고리 관리</h1>
    <div class="cate_wrap">
        <span>카테고리 명</span>
        <input type="text" id="cate_name">
        <button id="add_button">추가</button>
    </div>

    <div class="list">
        <table id="cate_table">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>이름</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="cate_table_body">

            </tbody>
        </table>    
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
