<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 상품</title>
    <link rel="stylesheet" href="/assets/css/product.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/product.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">상품 관리</h1>
    <div class="add_button_area">
        <button id="add_product">상품 추가</button>
    </div>
    <div class="product_form">
        <h1>상품 추가</h1>
        <table class="product_table">
            <tbody>
                <tr>
                    <td>상품명</td>
                    <td><input type="text" id="product_name"></td>
                    <td>가격</td>
                    <td><input type="text" id="product_price"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select id="product_category">
                            <option value="null">카테고리 선택</option>
                            <c:forEach items="${clist}" var="category">
                                <option value="${category.cate_seq}">${category.cate_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>판매자</td>
                    <td>
                        <select id="product_seller">
                            <option value="null">판매자 선택</option>
                            <c:forEach items="${slist}" var="seller">
                                <option value="${seller.si_seq}">${seller.si_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>재고수량</td>
                    <td><input type="number" id="product_stock"></td>
                    <td>무게(g)</td>
                    <td><input type="number" id="product_weight"></td>
                </tr>
                <tr>
                    <td>할인률(%)</td>
                    <td><input type="number" id="product_discount" min="0" max="100"></td>
                    <td>적립률(%)</td>
                    <td><input type="number" id="product_point" min="0" max="100"></td>
                </tr>
                <tr>
                    <td>배송업체</td>
                    <td colspan="3">
                        <select id="product_delivery">
                            <option value="null">배송업체 선택</option>
                            <c:forEach items="${dlist}" var="delivery">
                                <option value="${delivery.di_seq}">${delivery.di_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>주의사항</td>
                    <td colspan="3">
                        <textarea id="product_caution"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>제품 이미지</td>
                </tr>
                <tr>
                    <td class="img_form_td" colspan="4">
                        <span id="img_preview">

                        </span>
                        <form id="image_form">
                            <input type="file" accept="image/gif, image/jpeg, image/png, image/jpg" name="file">
                            <button type="button" id="img_save">등록</button>
                            <button type="button" id="img_delete" disabled>삭제</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <button id="save">등록하기</button>
                        <button id="modify">수정하기</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <button id="close">&times;</button>
    </div>

    <div class="product_list">
        <div class="search_area">
            <span>카테고리 선택</span>
            <select id="cate_search">
                <option>전체</option>
                <c:forEach items="${clist}" var="cate">
                    <option value="${cate.cate_seq}">${cate.cate_name}</option>
                </c:forEach>
            </select>
            <input type="text" id="search_keyword" placeholder="제품명 검색">
            <button id="search">검색</button>
        </div>
    </div>
    <table id="product_list_table">
        <thead id="product_thead">
            <tr>
                <td>번호</td>
                <td>제품명</td>
                <td>제품이미지</td>
                <td>카테고리</td>
                <td>재고</td>
                <td>업체명</td>
                <td>등록일</td>
                <td>할인율</td>
                <td>적립율</td>
                <td>주의사항</td>
                <td>무게</td>
                <td>배송사</td>
                <td>제품가격</td>
                <td></td>
                <td></td>
            </tr>
        </thead>
        <tbody id="product_tbody">

        </tbody>
    </table>

    <%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>
