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
    <link href="<%=request.getContextPath()%>/css/mypage.css" rel="stylesheet">

    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <script src="<%=request.getContextPath()%>/js/mypage.js"></script>

    <title>mypage</title>
    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
</head>
<body>
    <div>
		<%@ include file="/WEB-INF/view/header.jsp"%>   
		     
        <div id="section">
            <div class="mypage_top">
                <div class="mypage_top_info">
                    <div class="mypage_top_info_name">
                        <div class="mypage_top_info_name_1">
                            <div class="mypage_top_info_name_1_1">silver</div>
                            <div class="mypage_top_info_name_1_2"><strong>${loginSsInfo.mname}님</strong></div>
                        </div>
                    </div>
                    <div class="mypage_top_info_2">
                        <div class="mypage_top_info_button">
                            <button class="mypage_top_info_button_1">
                                <div class="mypage_top_info_button_1_1">적립금<span></span></div>
                                <div class="mypage_top_info_button_1_2">0<span>원</span></div>
                            </button>
                        </div>
                        <div class="mypage_top_info_button">
                            <button class="mypage_top_info_button_1">
                                <div class="mypage_top_info_button_1_1">쿠폰<span></span></div>
                                <div class="mypage_top_info_button_1_2">0<span>개</span></div>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mypage_mid">
                <div class="mypage_mid_l">
                    <div class="mypage_mid_l_div"></div>
                    <ul class="mypage_mid_l_ul">
                        <li class="mypage_mid_l_ul_li" onclick="location.href='<%=request.getContextPath()%>/mypage_wish'"><a class="active mypage_mid_l_ul_li_a">찜한 상품<span></span></a></li>
                        <li class="mypage_mid_l_ul_li" onclick="location.href='<%=request.getContextPath()%>/mypage_review'"><a class="mypage_mid_l_ul_li_a">상품 후기<span></span></a></li>
                    </ul>
                    <a href="#" class="mypage_mid_l_3">
                        <div class="mypage_mid_l_3_1" onclick="location.href='<%=request.getContextPath()%>/notice'">
                            <span class="mypage_mid_l_3_1_1">도움이 필요하신가요 ?</span>
                            <span class="mypage_mid_l_3_1_2">1:1 문의하기</span>
                        </div>
                        <span class="mypage_mid_l_3_2"></span>
                    </a>
                </div>
                <div class="mypage_mid_r">
                    <div class="mypage_mid_r_t">
                        <div class="mypage_mid_r_t_l">
                            <h2>찜한 상품</h2>
                            <span>찜한 상품은 최대 200개까지 저장됩니다.</span>
                        </div>
                    </div>
                    <div class="mypage_mid_r_m"></div>
<c:choose>
	<c:when test="${empty wishlist}">
                    <div class="mypage_mid_r_b_1">
                        <div class="mypage_mid_r_b_1_1">
                        	<img src="<%=request.getContextPath()%>/images/wish_empty.svg">
                            <p class="mypage_mid_r_b_1_text">
                                찜한 상품이 없습니다.
                            </p>
                        </div>
                    </div>
	</c:when>
	<c:otherwise>                        	
					<div class="wish_wrapper" style="position: relative;">
						<div style="overflow: visible; width: 0px;">
							<div>
								<div aria-label="grid" aria-readonly="true" class="ReactVirtualized__Grid ReactVirtualized__List" role="grid" tabindex="0" style="box-sizing: border-box; direction: ltr; height: auto; position: relative; width: 780px; will-change: transform; overflow: hidden;">
									<div class="ReactVirtualized__Grid__innerScrollContainer" role="rowgroup" style="width: auto; height: 384px; max-width: 780px; max-height: 384px; overflow: hidden; position: relative;">
										
    	<c:forEach items="${wishlist}" var="wishlist">
										
										<div class="wish" style="height: 128px; left: 0px; position: absolute; top: 0px; width: 100%;">
											<a href="/product?pid=${wishlist.pid }" class="wish_img">
												<span width="60" height="78">
												<span style="box-sizing: border-box; display: block; overflow: hidden; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; position: absolute; inset: 0px;">
												<img alt="" src="<%=request.getContextPath()%>/${wishlist.pimg1}" decoding="async" data-nimg="fill" sizes="100vw"
														style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover;"></span></span></a>
											<div class="wish_info">
												<div>
													<div class="wish_name">
														<a href="/product?pid=${wishlist.pid }">${wishlist.pname }</a>
													</div>
													<div class="wish_price">
														<span>${wishlist.pprice }</span>
													</div>
												</div>
												<div class="wish_btn">
													<button type="button" width="104" height="36" radius="4" onclick="location.href='mypage_wish/delete.do';">
														<span>삭제</span>
													</button>
												</div>
											</div>
										</div>
		</c:forEach>                        
									</div>
								</div>
							</div>
						</div>
						<div class="resize-triggers">
							<div class="expand-trigger"></div>
							<div class="contract-trigger"></div>
						</div>
					</div>
    </c:otherwise>
</c:choose>                        
                </div>
            </div>
            <!-- 여기까지 마이페이지 -->
            
			<%@ include file="/WEB-INF/view/scrollup.jsp"%>
        </div>

		<%@ include file="/WEB-INF/view/footer.jsp"%>    
    </div>
</body>
</html>