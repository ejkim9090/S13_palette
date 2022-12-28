<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/header_footer.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/scrollup.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/category.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/radio_check_action.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/checkbox_check_action.css" rel="stylesheet">

    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <script defer src="<%=request.getContextPath()%>/js/category.js"></script>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, p, span {
            font-family: "Noto Sans KR";
        }
    </style>
    <title>category</title>
</head>
<body>
    <div>
        <!-- header -->
		<%@ include file="/WEB-INF/view/header.jsp"%>
		
        <!-- section -->
        <div id="section">

            <div class="category_wrapper">

                <div id="container">

                    <!-- 상단 소분류 -->
                    <h3 class="cat_header_title">${parent.cname }</h3>

                    <ul class="cat_header_list">
                    
<c:forEach items="${categorylist}" var="vo">
	<c:choose>
		<c:when test="${vo.cid == currentCid}">
                        <li class="cat_header_item"><a class="cat_header_link active" href="<%=request.getContextPath()%>/category?cid=${vo.cid}">${vo.cname }</a></li>
		</c:when>
		<c:otherwise>
                        <li class="cat_header_item"><a class="cat_header_link" href="<%=request.getContextPath()%>/category?cid=${vo.cid}">${vo.cname }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>

                    </ul>

                    <div class="cat_contents_wrap">

                        <!-- 필터 -->
                        <div class="filter_wrap">
                
                            <!-- 필터 제목 & 초기화 버튼 -->
                            <div class="filter_title"><span>필터</span>
                                <button id="filter_reset">
                                    <svg width="12" height="12" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M13.78 3.96303C12.504 2.16973 10.4086 1 8.04 1C4.15192 1 1 4.15192 1 8.04C1 11.9281 4.15192 15.08 8.04 15.08C11.9281 15.08 15.08 11.9281 15.08 8.04" stroke="#ddd" stroke-width="1.6" stroke-linecap="square" stroke-linejoin="round"></path>
                                        <path d="M14.4933 1L14.4933 4.52H10.9733" stroke="#ddd" stroke-width="1.6" stroke-linecap="square" stroke-linejoin="round"></path>
                                    </svg><span>초기화</span>
                                </button>
                            </div>
                            
                            <div>
                            	
                            	<!-- 배송 -->
                                <div class="filter_event">
                
                                    <!-- 배송 제목 -->
                                    <button id="btn_showHide3">
                                        <div>배송</div>
                                        <svg width="18" height="18" viewBox="0 0 18 18" fill="none"stroke="#999" xmlns="http://www.w3.org/2000/svg" style="transform: rotate(0deg);">
                                            <path d="M5 11L9 7L13 11" stroke="#999" stroke-width="1.2"></path>
                                        </svg>
                                    </button>
                
                                    <!-- 배송 리스트 -->
                                    <ul class="filter_event_list" style="max-height: 100vh; opacity: 1;">
                                        <li class="list">
<c:choose>
	<c:when test="${empty currentPdelivery}">                                        
											<label onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=1&pprice=${currentPprice }&sort=${currentSort }'">
												<input type="checkbox" name="pdelivery" class="agree_check" value="">
												<span>무료배송</span>
											</label>
	</c:when>
	<c:otherwise>
											<label onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=&pprice=${currentPprice }&sort=${currentSort }'">
												<input type="checkbox" name="pdelivery" class="agree_check" value="1" checked>
												<span>무료배송</span>
											</label>
	</c:otherwise>										
</c:choose>											
                                        </li>
                                    </ul>
                                </div>
 
                                <!-- 가격 -->
                                <div class="filter_price">
                
                                    <!-- 가격 제목 -->
                                    <button id="btn_showHide2">
                                        <div>가격</div>
                                        <svg width="18" height="18" viewBox="0 0 18 18" fill="none" stroke="#999" xmlns="http://www.w3.org/2000/svg" style="transform: rotate(0deg);">
                                            <path d="M5 11L9 7L13 11" stroke="#999" stroke-width="1.2"></path>
                                        </svg>
                                    </button>
                
                                    <!-- 가격 리스트 -->
                                    <ul class="filter_price_list" style="max-height: 100vh; opacity: 1;">
                                        <li class="list">
                                        	<label class="radio_button" onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=0&sort=${currentSort }'">
                                        		<input type="radio" name="pprice" value="0" <%if(request.getAttribute("currentPprice").equals("0")){%>checked<%}else{} %>>
                                        		<span>전체</span>
                                        	</label>
                                        </li>	
                                       	<li class="list">
                                        	<label class="radio_button" onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=1&sort=${currentSort }'">
	                                        	<input type="radio" name="pprice" value="1" <%if(request.getAttribute("currentPprice").equals("1")){%>checked<%}else{} %>>
	                                        	<span>10,000원 이하</span>
                                        	</label>
                                        </li>
                                        <li class="list">
                                            <label class="radio_button" onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=2&sort=${currentSort }'">
                                            	<input type="radio" name="pprice" value="2" <%if(request.getAttribute("currentPprice").equals("2")){%>checked<%}else{} %>>
                                            	<span>10,000원 ~ 30,000원</span>
                                            </label>
                                        </li>
                                        <li class="list">
                                            <label class="radio_button" onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=3&sort=${currentSort }'">
                                            	<input type="radio" name="pprice" value="3" <%if(request.getAttribute("currentPprice").equals("3")){%>checked<%}else{} %>>
                                            	<span>30,000원 ~ 50,000원</span>
                                            </label>
                                        </li>
                                        <li class="list">
                                            <label class="radio_button" onclick="location.href='<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=4&sort=${currentSort }'">
                                            	<input type="radio" name="pprice" value="4" <%if(request.getAttribute("currentPprice").equals("4")){%>checked<%}else{} %>>
                                            	<span>50,000원 이상</span>
                                            </label>
                                        </li>
                
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!-- 상품목록 -->
                        <div class="contents_wrap">

                            <div id="contents_list">
                            
                                <!-- 총 상품 수 -->
                                <div class="contents_total">총 ${fn:length(productlist) }건</div>
                         
                                <!-- 높은가격순, 낮은가격순 -->
                                <ul class="contents_list_option">
<c:choose>
	<c:when test="${empty currentSort }">
                                    <li class="content_list">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=1" class="content_low_price">낮은가격순</a>
                                    </li>
                                    <li class="content_list">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=2" class="content_high_price">높은가격순</a>
                                    </li>
	</c:when>
	<c:when test="${currentSort == '1' }">
                                    <li class="content_list active">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=1" class="content_low_price">낮은가격순</a>
                                    </li>
                                    <li class="content_list">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=2" class="content_high_price">높은가격순</a>
                                    </li>
	</c:when>
	<c:when test="${currentSort == '2' }">
                                    <li class="content_list">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=1" class="content_low_price">낮은가격순</a>
                                    </li>
                                    <li class="content_list active">
                                        <a href="<%=request.getContextPath()%>/category?cid=${currentCid}&pdelivery=${currentPdelivery }&pprice=${currentPprice}&sort=2" class="content_high_price">높은가격순</a>
                                    </li>
	</c:when>
</c:choose>
                    
                                </ul>
                            </div>

                            <!-- 상품목록 -->
                            <div class="contents_pictures1">
<c:forEach items="${productlist}" var="vo">
                            	
                                <div class="contents_pricture1_div">
                                    <div class="contents_pricture1_div2">
                                        <img src="<%=request.getContextPath()%>/${vo.pimg1}" onclick="location.href='<%=request.getContextPath()%>/product?pid=${vo.pid }';" alt="상품 이미지" loading="lazy">
                                    </div>
                                    <div class="contents_pricture1_explantion" onClick="location.href='<%=request.getContextPath()%>/product?pid=${vo.pid }';">
                                        <span class="contents_1">${vo.pname }</span>
                                        <div class="contents_1_price_div">
                                            <div></div>
                                            <span class="contents_1_price">${vo.pprice } 원</span>
                                        </div>
                                    </div>
                                </div>
</c:forEach>                               
                            </div>

                    </div>
                </div>

            </div>  

			<%@ include file="/WEB-INF/view/scrollup.jsp"%>
			
        </div>

        <!-- footer -->
        <%@ include file="/WEB-INF/view/footer.jsp"%>
    </div>
</body>
</html>