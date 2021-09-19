<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 :: 상품</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/product.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/admin/main.jsp" %>
    <h1 class="title">상품 관리</h1>
    <div class="product_form">
        <table class="product_table">
            <tbody>
                <tr>
                    <td>상품명</td>
                    <td><input type="text" id="product_name"></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="text" id="product_price"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select id="product_category">
                            <c:forEach items="${clist}" var="category">
                                <option value="${category.cate_seq}">${category.cate_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>재고</td>
                    <td><input type="number" id="product_stock"></td>
                </tr>
                <tr>
                    <td>업체명</td>
                    <td>
                        <select id="product_seller">
                            <c:forEach items="${slist}" var="seller">
                                <option value="${seller.si_seq}">${seller.si_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>할인률</td>
                    <td><input type="number" id="product_discount" min="0" max="100"></td>
                </tr>
                <tr>
                    <td>적립률</td>
                    <td><input type="number" id="product_point" min="0" max="100"></td>
                </tr>
                <tr>
                    <td>주의사항</td>
                    <td>
                        <textarea id="product_caution"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>무게(g)</td>
                    <td><input type="number" id="product_weight"></td>
                </tr>
                <tr>
                    <td>배송사</td>
                    <td>
                        <select id="product_delivery">
                            <c:forEach items="${dlist}" var="delivery">
                                <option value="${delivery.di_seq}">${delivery.di_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button id="save">등록하기</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
