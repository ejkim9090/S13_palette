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
                        <li class="mypage_mid_l_ul_li" onclick="location.href='<%=request.getContextPath()%>/mypage_wish'"><a class="mypage_mid_l_ul_li_a">찜한 상품<span></span></a></li>
                        <li class="mypage_mid_l_ul_li" onclick="location.href='<%=request.getContextPath()%>/mypage_review'"><a class="active mypage_mid_l_ul_li_a">상품 후기<span></span></a></li>
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
                            <h2>상품 후기</h2>
                        </div>
                    </div>
                    <div class="mypage_mid_r_m"></div>
<c:choose>
	<c:when test="${empty reviewlist}">
                    <div class="mypage_mid_r_b_1">
                        <div class="mypage_mid_r_b_1_1">
                        	<img src="<%=request.getContextPath()%>/images/mypage_주문목록.svg">
                            <p class="mypage_mid_r_b_1_text">
                                작성한 후기가 없습니다.
                            </p>
                        </div>
                    </div>
	</c:when>
	<c:otherwise>                        	
					<div class="wish_wrapper" style="position: relative;">
										
    	<c:forEach items="${reviewlist}" var="reviewlist">
										
						<div class="wish" style="left: 0px; width: 100%;">
						
							<a href="<%=request.getContextPath()%>/product?pid=${reviewlist.pid }" class="wish_img">
								<span width="60" height="78">
								<span style="box-sizing: border-box; display: block; overflow: hidden; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; position: absolute; inset: 0px;">
								<img src="<%=request.getContextPath()%>/${reviewlist.pimg1}" decoding="async" data-nimg="fill" sizes="100vw" style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover;"></span></span></a>
							<div class="wish_info">
								<div>
									<div class="wish_name">
										<a href="<%=request.getContextPath()%>/product?pid=${reviewlist.pid }">${reviewlist.pname }</a>
									</div>
									<input type="hidden" name="rno" id="rno" value="${reviewlist.rno }">
									<div class="review_content">
										<span>${reviewlist.rcontent }</span>
									</div>
									<div class="review_img">
			<c:forEach items="${reviewlist.rfilepath}" var="rfilepath">
										<span><img src="<%=request.getContextPath()%>/${rfilepath}"></span>
			</c:forEach>										
									</div>
									<div class="review_date">
										<span>${reviewlist.rdate }</span>
									</div>
								</div>
								<div class="wish_btn">
									<button type="button" id="delete" width="104" height="36" radius="4">
										<span>삭제</span>
									</button>
								</div>
							</div>
						</div>
		</c:forEach>                        
					</div>
					
					<div class="button_wrapper">
                        <div class="button">
		<c:if test="${currentPage ne 1}">
                            <button type="button" class="button_previous" onclick="location.href='mypage_review?pagenum=${currentPage-1 }'">
                                <div class="button_text">이전</div>
                            </button>
		</c:if>     

		<c:if test="${currentPage < pageCnt}">
                            <button type="button" class="button_next" onclick="location.href='mypage_review?pagenum=${currentPage+1 }'">
                                <div class="button_text">다음</div>
                            </button>
		</c:if>                            
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
<script>
$(function(){
	
	$("#delete").on("click", function(){
	    
	    $.ajax({
      		url : "<%=request.getContextPath()%>/mypage_review_delete.lo",
      		type : "post",
      		data: {rno : $("#rno").val()}, // url로 전달'할' 데이터. Object 타입으로 전달됨
      		success: function(data){ // (data) : url로부터 전달'받은' 데이터
      					if(data == 1) {
							alert("후기 삭제 성공")
						} else {
							alert("후기 삭제 실패")
						}
      					location.reload(); // f5 새로고침 효과
      				 },
      		error : function(request, status, error){
      					console.log(request);	
      					console.log(status);	
      					console.log(error);	
      					alert("code:"+request.status+"\n"
      							+"message"+request.responseText+"\n"
      							+"error"+error);
      				}
      	});  
	});
});
</script>
</html>