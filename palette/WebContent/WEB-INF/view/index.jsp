<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/header_footer.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/scrollup.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">
    
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/main.js"></script>
    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
    <title>main</title>
</head>
<body>
    <div>
		<%@ include file="/WEB-INF/view/header.jsp"%>
		
        <div id="section">
            <div class="main_section">
                <!-- 맨위 상단 섹션-->
                <div>
                    <div class="m_s_top">
                        <div class="m_s_top_swiper_wrap">
                            <div class="m_s_top_swiper">
                                <div><a><img src="<%=request.getContextPath()%>/images/main.avif"></a></div>
                                <div><a><img src="<%=request.getContextPath()%>/images/main2.avif"></a></div>
                                <div><a><img src="<%=request.getContextPath()%>/images/main3.avif"></a></div>
                                <div><a><img src="<%=request.getContextPath()%>/images/main4.avif"></a></div>
                            </div>
                            <button id="m_s_top_bLeft"></button>
                            <button id="m_s_top_bRight"></button>
                            <div class="m_s_top_text">1 / 3</div>
                        </div>
                    </div>
                </div>
                <!-- BEST 섹션 -->
                <div>               
                    <div class="m_s_1">
                        <div class="m_s_1_title">
                            <div class="m_s_1_title_1">
                                <span class="m_s_1_title_1_span">
                                    BEST
                                </span>
                            </div>
                        </div>
                        <div class="m_s_1_list">
                            <div class="m_s_1_list_swiper">
                                <div class="m_s_1_list_swiper_wrap">     
                                    <div class="m_s_1_list_1">
                                        <div class="m_s_1_list_1_product">
                                            <div class="m_s_1_list_1_product_1">
                                                <div class="m_s_1_list_1_product_1_img">
                                                    <img src="//image.artbox.co.kr/upload/C00001/goods/224_224/365/211202001512365.jpg?s=/goods/org/365/211202001512365.jpg" alt="상품 이미지">
                                                </div>
                                                <div class="m_s_1_list_1_product_1_content">
                                                    <h3 class="m_s_1_list_1_product_1_content_title">
                                                        충전식 온수팩 곰돌이 (57001154)
                                                    </h3>
                                                    <div class="m_s_1_list_1_product_1_content_price">
                                                        <div class="m_s_1_list_1_product_1_content_price_1">
                                                            <span class="m_s_1_list_1_product_1_content_price_1_1">
                                                                19,900 원
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m_s_1_list_1">
                                        <div class="m_s_1_list_1_product">
                                            <div class="m_s_1_list_1_product_1">
                                                <div class="m_s_1_list_1_product_1_img">
                                                    <img src="//image.artbox.co.kr/upload/C00001/goods/224_224/878/221108003148878.jpg?s=/goods/org/878/221108003148878.jpg" alt="상품 이미지">
                                                </div>
                                                <div class="m_s_1_list_1_product_1_content">
                                                    <h3 class="m_s_1_list_1_product_1_content_title">
                                                        뜨겁곰 양손핫팩 (34011183)
                                                    </h3>
                                                    <div class="m_s_1_list_1_product_1_content_price">
                                                        <div class="m_s_1_list_1_product_1_content_price_1">
                                                            <span class="m_s_1_list_1_product_1_content_price_1_1">
                                                                1,200 원
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m_s_1_list_1">
                                        <div class="m_s_1_list_1_product">
                                            <div class="m_s_1_list_1_product_1">
                                                <div class="m_s_1_list_1_product_1_img">
                                                    <img src="//image.artbox.co.kr/upload/C00001/goods/224_224/170/221014003075170.jpg?s=/goods/org/170/221014003075170.jpg" alt="상품 이미지">
                                                </div>
                                                <div class="m_s_1_list_1_product_1_content">
                                                    <h3 class="m_s_1_list_1_product_1_content_title">
                                                        2023 디어마이데이즈 다이어리 핑크 (04011769)
                                                    </h3>
                                                    <div class="m_s_1_list_1_product_1_content_price">
                                                        <div class="m_s_1_list_1_product_1_content_price_1">
                                                            <span class="m_s_1_list_1_product_1_content_price_1_1">
                                                                15,800 원
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m_s_1_list_1">
                                        <div class="m_s_1_list_1_product">
                                            <div class="m_s_1_list_1_product_1">
                                                <div class="m_s_1_list_1_product_1_img">
                                                    <img src="//image.artbox.co.kr/upload/C00001/goods/224_224/003/221019003084003.jpg?s=/goods/org/003/221019003084003.jpg" alt="상품 이미지">
                                                </div>
                                                <div class="m_s_1_list_1_product_1_content">
                                                    <h3 class="m_s_1_list_1_product_1_content_title">
                                                        2023 책읽는푸들 탁상달력 (04011856)
                                                    </h3>
                                                    <div class="m_s_1_list_1_product_1_content_price">
                                                        <div class="m_s_1_list_1_product_1_content_price_1">
                                                            <span class="m_s_1_list_1_product_1_content_price_1_1">
                                                                5,800 원
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
        	<%@ include file="/WEB-INF/view/scrollup.jsp"%>
        </div>
        
        <%@ include file="/WEB-INF/view/footer.jsp"%>
    </div>
</body>
</html>