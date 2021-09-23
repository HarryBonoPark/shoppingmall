<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/header.js"></script>
</head>
<body>
    <header>
        <div class="header_content">
            <div class="hc_top">
                <a href="#" id="delivery">
                    <img src="/assets/images/샛별_ 택배 배송안내.png">
                </a>
                <div class="user_menu">
                    <c:if test="${member == null}">
                        <a href="/login">로그인</a>
                        <span>|</span>
                        <a href="/join">회원가입</a>
                    </c:if>
                    <c:if test="${member != null}">
                        <a href="#">${member.mi_name}님</a>
                        <span>|</span>
                        <a href="/logout" id="logout">로그아웃</a>
                    </c:if>
                    <span>|</span>
                    <a href="#">고객센터</a>
                </div>
            </div>
            <div class="hc_mid">
                <a href="/" id="logo">
                    <img src="/assets/images/마켓컬리 로고.png">
                </a>
            </div>
            <div class="hc_bot">
                <div class="main_menu">
                    <a href="#">전체 카테고리</a>
                    <a href="#">신상품</a>
                    <a href="#">베스트</a>
                    <a href="#">알뜰 쇼핑</a>
                    <a href="#">특가/혜택</a>
                </div>
                <div class="search_area">
                    <div class="search_box">
                        <input type="text" id="keyword">
                        <button id="search_btn">
                            <img src="/assets/images/ico_search_x2.png">
                        </button>
                    </div>
                    <a href="#">
                        <img src="/assets/images/ico_delivery_setting.svg">
                    </a>
                    <a href="#">
                        <img src="/assets/images/ico_cart.svg">
                    </a>
                </div>
            </div>
            <div class="categories">

            </div>
        </div>
    </header>
</body>
</html>