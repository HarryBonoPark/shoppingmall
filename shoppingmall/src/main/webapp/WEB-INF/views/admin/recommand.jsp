<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 추천상품</title>
    <link rel="stylesheet" href="/assets/css/recommand.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/recommand.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">추천상품 관리</h1>
    <div class="add_button_area">
        <button id="add_recommand_button">추천 상품 추가</button>
    </div>
    <table id="recommand_table">
        <thead id="recommand_thead">
            <tr>
                <td>번호</td>
                <td>제품명</td>
                <td>제품이미지</td>
                <td>카테고리</td>
                <td>업체명</td>
                <td></td>
            </tr>
        </thead>
        <tbody id="recommand_tbody">

        </tbody>
    </table>
    <div class="add_recommand">
        <div class="add_recommand_wrap">
            <h1 class="pop_title">추천상품 추가</h1>
            <button class="close">닫기</button>
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>제품명</td>
                        <td>제품이미지</td>
                        <td>카테고리</td>
                        <td>업체명</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody class="not_recommand_list">

                </tbody>
            </table>
        </div>
    </div>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
