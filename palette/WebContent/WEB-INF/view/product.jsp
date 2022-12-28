<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/header_footer.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/scrollup.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/product.css" rel="stylesheet">
    
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script defer src="<%=request.getContextPath()%>/js/product.js"></script>


    <style>
        html, body {
            scroll-behavior: smooth; -webkit-scroll-behavior: smooth;
        }
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, p, span {
            font-family: "Noto Sans KR";
        }
        
    </style>

</head>
<body>
    <div>
        <!-- header -->
		<%@ include file="/WEB-INF/view/header.jsp"%>
		
        <!-- section -->
        <div id="section">
            <div class="prod_detail_wrap">
                <!-- 내용 -->
                <div id="container_wrapper">

                    <!-- 상단 (박민지) -->
                    <article id="product-atf" class="prod_detail_header">
                        <div class="prod_img_box"><img src="<%=request.getContextPath()%>/${product.pimg1}"></div>
                        <div class="header_contents">
                            <div class="prod_detail_view_area">
                                <div class="prod_info"></div> 
                                <div class="prod_info_title_wrap">                    
                                    <div class="prod_info_title"> 
                                        <h2 class="prod_info_name">${product.pname }</h2>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="prod_price">
                            	<span class="percent_val">${product.pprice }</span>
                                <span class="unit">원</span>
                            </div>                    
                            
                            <!-- 상품 상세 정보 영역 -->
                            <div class="prod_guide_wrap">
                                <dl class="prod_guide_box">                     
                                    <dt class="prod_guide_title">혜택</dt>
                                    <dd class="packaging_guide_text">                                
                                        <p class="packaging_paper">${product.pbenefit }</p>
                                    </dd>
                                </dl>
                                <dl class="prod_guide_box">                            
                                    <dt class="prod_guide_title">배송비</dt>
                                    <dd class="delivery_guide_text">                                
                                        <p class="delivery_type">${product.pdelivery }</p>
                                    </dd>
                                </dl>
                            </div>
                            <!--상품 선택 영역-->
                            <div class="prod_select_wrap">
                                <div class="prod_select_row">
                                    <dl class="prod_select_box">                         
                                        <dt class="prod_guide_title">상품선택</dt>
                                        <div class="prod_select_area"> 
                                            <div class="select_text">
                                                <span class="select_info">${product.pname }</span>
                                            </div>
                                            <!--수량 체크 영역-->
                                            <div class="select_count">
                                                <div class="select_button_box">
                                                    <button type="button" aria-label="수량내리기" disabled=""
                                                        class="button_down"></button>
                                                    <div class="count_number">1</div><button type="button"
                                                        aria-label="수량올리기" class="button_up"></button>
                                                </div>
                                                <div><span class="sale_val">${product.pprice }원</span></div>
                                            </div>
                                        </div>
                                    </dl>
                                </div>
                                <div class="prod_price_area">
                                    <div class="prod_price_box">
                                        <div class="prod_info_price">
                                            <span class="total_price">총 상품금액 :</span>
                                            <span class="total_val">${product.pprice }</span><span class="unit">원</span>
                                        </div>
                                    </div>
                                </div>
                                <!--버튼 영역-->
                                <div class="prod_button_area">
                                	<button class="button_wish" type="button" width="56" height="56" radius="3">
                                		<span class="ico_wish">
                                            <img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K"
                                                alt="" id="wish_img">
                                        </span>
                                    </button>
                                    <button class="button_notice"
                                        type="button" disabled="" width="56" height="56" radius="3">
                                        <span class="ico_notice">
                                        	<img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxnIHN0cm9rZT0iI0NDQyIgc3Ryb2tlLXdpZHRoPSIxLjYiIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTEyLjY2NiAyM2EzLjMzMyAzLjMzMyAwIDEgMCA2LjY2NiAwIi8+CiAgICAgICAgPHBhdGggZD0iTTI1Ljk5OCAyMi43MzhINmwuMDEzLS4wM2MuMDc2LS4xMzUuNDcxLS43MDQgMS4xODYtMS43MDlsLjc1LTEuMDV2LTYuNjM1YzAtNC40ODUgMy40MzgtOC4xNCA3Ljc0MS04LjMwOEwxNiA1YzQuNDQ2IDAgOC4wNSAzLjcyMiA4LjA1IDguMzE0djYuNjM0bDEuNzA3IDIuNDExYy4xNzMuMjUzLjI1NC4zOC4yNDIuMzh6IiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS1saW5lam9pbj0icm91bmQiLz4KICAgIDwvZz4KPC9zdmc+Cg=="
                                                alt="" class="css-0">
                                        </span>
                                    </button>
                                    <div class="prod_basket_area">
                                    	<button class="button_basket" type="button" radius="3"><span class="text">장바구니 담기</span></button>
                                    </div>                        
                                </div>
                                <div id="product_info"></div>
                            </div>
                        </div>
                    </article>

                    <!-- 상품설명/상세정보/후기/문의 탭버튼 -->
                    
                    <nav class="prod_nav_wrap">

                        <nav>

                            <div class="prod_tab selected">
                                <a href="#product_info" class="active"><span>상품설명</span></a>
                            </div>
                            <div class="prod_tab">
                                <a href="#review"><span>후기</span><span class="number">(${fn:length(reviewlist) })</span></a>
                            </div>
                            <div class="prod_tab">
                                <a href="#inquiry"><span>문의</span></a>
                            </div>

                        </nav>

                    </nav>

                    <!-- 상품설명/상세정보/후기/문의 전체 -->
                    <div class="prod_contents_wrap">

                        <!-- 상품설명 (최경선) -->
                        <div id="description" class="description_wrap">

                            <div class="goods_wrap">${product.pdetail }</div>
                            
                            <div id="review"></div>
                            
                        </div>

                        <!-- 후기 (최지민) -->
                        <div class="wrap detail">
                            <div class="wrap review">
                            
                                <!-- 후기작성 버튼 -->
                                <div class="btn_inquiry_wrap">
                                    <button type="button" width="120" height="40" onclick="open_pop()">
                                        <span>후기작성</span>
                                    </button>
                                </div>
                                
                            	<!-- 후기작성 팝업창 -->
                                <div id="popup" role="presentation" style="position: fixed; z-index: 1300; inset: 0px; display: none;">
                                
                                <form name="review" method="post" enctype="multipart/form-data" id="reviewForm">
                                	
                                    <div class="MuiBackdrop_root" aria-hidden="true" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
                                    <div tabindex="0" data-test="sentinelStart"></div>
                                    <div class="MuiDialog_container" role="none presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
                                        <div class="MuiDialog_root" role="dialog">
                                            <div class="MuiDialogContent_root">
                                                <div>
                                                    <!-- 헤더 -->
                                                    <div class="dialog_header">
                                                        <div>후기 작성</div>
                                                        <span id="btn_close" onclick="close_pop()"></span>
                                                    </div>
                    
                                                    <!-- 이미지 -->
                                                    <div class="dialog_image">
                                                        <div><img src="<%=request.getContextPath()%>/${product.pimg1}"></div>
                                                        <div><span>${product.pname}</span></div>
                                                    </div>
                                                    
                                                    <!-- 후기번호 -->
                                                    <input type="hidden" name="rno" value="0">
                                                    
                                                    <!-- 상품아이디 -->
                                                    <input type="hidden" name="pid" value="${product.pid }">

                                                    <!-- 내용 -->
                                                    <div class="dialog_content">
                                                        <div><span>내용</span></div>
                                                        <div class="dialog_content_textarea">
                                                            <div>
                                                                <textarea id="textarea" inputmode="text" name="rcontent" placeholder="자세한 후기는 다른 고객의 구매에 많은 도움이 됩니다."></textarea>
                                                                <span class="content_length_counter"> 0 / 5,000</span>
                                                            </div>
                                                        </div>
                                                    </div>
 
                                                    <!-- 사진 첨부 -->
													<div class="file_wrapper">
														<div></div>
														<div>
															<div class="image_wrap">
																<div>
																	<label for="photo-picker">
																		<button type="button" class="file_button" onclick="$('#file').trigger('click');" >
																			<span></span>
																		</button>
																		<input type="file" multiple="multiple" name="uploadFile" id="file" accept="image/*">
																	</label>
																</div>
															</div>
															<div class="text_wrap">
																<div>
																	<span></span>10MB 이하의 이미지만 업로드 가능합니다.
																</div>
																<div>
																	<span></span>사진은 최대 5장까지 등록가능합니다.
																</div>
															</div>
														</div>
													</div>

													<!-- 취소/등록 -->
                                                    <div class="dialog_cancel_submit">
                                                        <button type="button" onclick="close_pop()">
                                                            <span>취소</span>
                                                        </button>
                                                        <button onclick="ajaxUpload(event)">
                                                            <span>등록</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div tabindex="0" data-test="sentinelEnd"></div>
   								</form>
                                </div>
   								
                                <div>
                                    <h2 class="product_review">상품 후기</h2><br>
                                </div>
                                <div>
                                    <ul class="review_ul">
                                        <li class="review_ul_li"><b>·</b> 후기 작성은 배송완료일로부터 30일 이내 가능합니다.</li>
                                        <li class="review_ul_li"><b>·</b> 작성하신 후기는 확인 후 적립금이 지급됩니다. (영업일 기준 평균 1~2일 소요)</li>
                                    </ul>
                                </div>
                    
                                <!-- 사진 더보기 -->
<c:choose>
	<c:when test="${empty rimagelist}">
								<div class="review_photo">
								</div>
	</c:when>
	
	<c:otherwise>
                                <div class="review_photo">
	<c:forEach items="${rimagelist}" var="vo" begin="0" end="7">  
									<img src="<%=request.getContextPath()%>/${vo.rfilepath}">
	</c:forEach>
                                    <!-- +더보기 링크 -->
                                    <button class="review_more_link"><span>+더보기</span></button>
                                </div>
    </c:otherwise>
</c:choose>                
                                <div class="user_review_div">
                                    <!-- 총 게시물 수 -->
                                    <div class="total_post">
                                        <span class="total_post_span">총 ${fn:length(reviewlist) }개</span>
                                    </div>
                                </div>
<c:choose>
	<c:when test="${empty reviewlist}">
								<div class="review_empty">
									<img src="<%=request.getContextPath()%>/images/review_empty.svg">
									<p>따끈한 첫 후기를 기다리고 있어요.</p>
								</div>
	</c:when>
	
	<c:otherwise>
		<c:forEach items="${reviewlist}" var="vo">                    
                                <!-- 사용자 후기 -->
                                <div class="user_post_div_first first">
                                    <div class="user_post_div_second first">
                                        <div class="user_best_purple first">
                                            <span class="user_name first">${vo.mname }</span>
                                        </div>
                                    </div>
                                    <div>
                                        <!-- 글 제목, 내용, 사진, 요일 등등 -->
                                        <div class="user_content_div_first first">
                                            <div>
                                                <div class="user_content_title_div first">
                                                    <h3 class="user_content_title first">${vo.pname }</h3>
                                                </div>
                                                <p class="content_writing first">${vo.rcontent }</p>
                                                <div class="user_photo first">
			<c:forEach items="${vo.rfilepath}" var="filepath">
													<img src="<%=request.getContextPath()%>/${filepath}">
			</c:forEach>
                                                </div>
                                                <div class="user_footer first">
                                                    <div>
                                                        <span class="user_update first">${vo.rdate }</span>
                                                    </div>
                                                    <!-- 도움이 돼요 -->
                                                    <button class="helpful first">
                                                        <span class="user_heplful first"></span>
                                                        <span>도움이 돼요</span>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
      		</c:forEach>
      </c:otherwise> 
</c:choose>              
							<!-- 사진 더보기 모달창 -->
                            <div role="presentation" class="view_more_user_wrap" id="review_more_user" style="display: none;">
                                <div aria-hidden="true" class="view_more_user_div1"
                                    style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
                                <div tabindex="0" data-test="sentinelStart"></div>
                                <div class="iew_more_user_div2" role="presentation" tabindex="-1"
                                    style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;" >
                                    <div class="view_more_user_div_wrap"
                                        role="dialog" aria-labelledby="mui-5">
                                        <div class="view_more_size">
                                            <header class="view_more_header"><span class="view_more_picture_review">사진 후기
                                                    전체보기</span><button class="view_more_all_look"><svg width="32" height="32"
                                                        viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg" id="review_more_user_off">
                                                        <g clip-path="url(#clip0_2073_60924)">
                                                            <path d="M26 26L6 6" stroke="#999" stroke-linecap="square" stroke-width="0">
                                                            </path>
                                                            <path d="M6 26L26 6" stroke="#999" stroke-linecap="square" stroke-width="0">
                                                            </path>
                                                        </g>
                                                        <path fill-rule="evenodd" clip-rule="evenodd"
                                                            d="M6.28431 5.58859L6.35355 5.64645L16 15.293L25.6464 5.64645C25.8417 5.45118 26.1583 5.45118 26.3536 5.64645C26.5271 5.82001 26.5464 6.08944 26.4114 6.28431L26.3536 6.35355L16.707 16L26.3536 25.6464C26.5488 25.8417 26.5488 26.1583 26.3536 26.3536C26.18 26.5271 25.9106 26.5464 25.7157 26.4114L25.6464 26.3536L16 16.707L6.35355 26.3536C6.15829 26.5488 5.84171 26.5488 5.64645 26.3536C5.47288 26.18 5.4536 25.9106 5.58859 25.7157L5.64645 25.6464L15.293 16L5.64645 6.35355C5.45118 6.15829 5.45118 5.84171 5.64645 5.64645C5.82001 5.47288 6.08944 5.4536 6.28431 5.58859Z"
                                                            fill="#999"></path>
                                                    </svg></button></header>
                                            <div class="view_more_box_wrap">
                                                <div class="view_more_div_picture">
                                                    <div class="view_more_div_picture_wrap">
                                                    
<c:forEach items="${rimagelist}" var="vo">  
														<div aria-hidden="true" tabindex="0"
															class="view_more_div_picture_div">
															<span style="box-sizing: border-box; display: inline-block; overflow: hidden; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; position: relative; max-width: 100%;">
																<span style="box-sizing: border-box; display: block; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; max-width: 100%;">
																	<img alt="" aria-hidden="true" src="data:image/svg+xml,%3csvg%20xmlns=%27http://www.w3.org/2000/svg%27%20version=%271.1%27%20width=%27120%27%20height=%27120%27/%3e"
																		style="display: block; max-width: 100%; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px;">
																</span>
																<img src="<%=request.getContextPath()%>/${vo.rfilepath}" decoding="async" data-nimg="intrinsic"
																	style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover;">
															</span>
														</div>
</c:forEach>															
													</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div tabindex="0" data-test="sentinelEnd"></div>
                            </div>
                        </div>
                        </div>

                        <!-- 문의 (최경선) -->
                        
                        <div id="inquiry" style="position: relative; top: -150px;"></div>
                        <div class="inquiry_wrap">
                
                            <div class="inquiry_content">
                                
                                <!-- 문의하기 버튼 -->
                                <div class="btn_inquiry_wrap">
                                    <button type="button" width="120" height="40" onclick="open_pop()">
                                        <span>문의하기</span>
                                    </button>
                                </div>
                    
                                <!-- 문의하기 팝업창 -->
                                <div id="popup" role="presentation" style="position: fixed; z-index: 1300; inset: 0px; display: none;">
                                    
                                    <div class="MuiBackdrop_root" aria-hidden="true" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
                                    
                                    <div tabindex="0" data-test="sentinelStart"></div>
                                    
                                    <div class="MuiDialog_container" role="none presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
                                        
                                        <div class="MuiDialog_root" role="dialog">
                                            
                                            <div class="MuiDialogContent_root">
                    
                                                <div>
                    
                                                    <!-- 상품 문의하기 -->
                                                    <div class="dialog_header">
                                                        <div>상품 문의하기</div>
                                                        <span id="btn_close" onclick="close_pop()"></span>
                                                    </div>
                    
                                                    <!-- 이미지 -->
                                                    <div class="dialog_image">
                                                        <div><img src="https://img-cf.kurly.com/shop/data/goods/164820616351l0.jpeg"></div>
                                                        <div><span>[최현석의 쵸이닷] 새우 봉골레 파스타</span></div>
                                                    </div>
                    
                                                    <!-- 제목 -->
                                                    <div class="dialog_title">
                                                        <div><span>제목</span></div>
                                                        <div class="dialog_title_textarea">
                                                            <div>
                                                                <input data-testid="input-box" name="subject" placeholder="제목을 입력해 주세요" type="text" height="42" value="">
                                                            </div>
                                                        </div>
                                                    </div>
                    
                                                    <!-- 내용 -->
                                                    <div class="dialog_content">
                                                        <div><span>내용</span></div>
                                                        <div class="dialog_content_textarea">
                                                            <div>
                                                                <textarea inputmode="text" aria-label="textarea-message" name="content"></textarea>
                                                                <div class="placeholder">
                                                                    <div><strong>상품문의 작성 전 확인해 주세요</strong><br>
                                                                        <ul>
                                                                            <li>- 답변은 영업일 기준 2~3일 소요됩니다.</li>
                                                                            <li>- 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.</li>
                                                                            <li>- 배송관련, 주문(취소/교환/환불)관련 문의 및 요청사항은 마이컬리 내 1:1 문의에 남겨주세요.</li>
                                                                        </ul><br><strong>제품</strong>
                                                                        <ul>
                                                                            <li>- 입고일 : 품절 상품 입고 일이 확정된 경우, 섬네일에 기재되어 있습니다. (종 모양을 클릭하여, 재입고 알림 설정
                                                                                가능)</li>
                                                                            <li>- 제품 상세정보 : 영양성분 및 함량, 용량, 보관 및 취급 방법 등 제품 정보는 상세이미지 또는 상세정보에서 확인
                                                                                가능합니다.</li><br>
                                                                        </ul><strong>주문취소</strong>
                                                                        <ul>
                                                                            <li>- 배송 단계별로 주문취소 방법이 상이합니다.</li>
                                                                            <li>- [입금확인] 단계 : [마이컬리 &gt; 주문내역 상세페이지] 에서 직접 취소 가능</li>
                                                                            <li>- [입금확인] 이후 단계 : 고객센터로 문의</li>
                                                                            <li>- 생산이 시작된 [상품 준비중] 이후에는 취소가 제한되는 점 고객님의 양해 부탁드립니다.</li>
                                                                            <li>- 비회원은 모바일 App 또는 모바일 웹사이트에서 [마이컬리 &gt; 비회원 주문 조회 페이지]에서 취소가
                                                                                가능합니다.</li>
                                                                            <li>- 일부 예약상품은 배송 3~4일 전에만 취소 가능합니다.</li>
                                                                        </ul>
                                                                        <p>※ 주문상품의 부분 취소는 불가능합니다. 전체 주문 취소 후 재구매 해주세요.</p><br>
                                                                        <strong>배송</strong>
                                                                        <ul>
                                                                            <li>- 주문 완료 후 배송 방법(샛별/택배)은 변경이 불가능합니다.</li>
                                                                            <li>- 배송일 배송시간 지정은 불가능합니다. (예약배송 포함)</li>
                                                                        </ul>
                                                                        <p>※ 전화번호, 이메일, 주소, 계좌번호 등의 상세 개인정보가 문의 내용에 저장되지 않도록 주의해 주시기 바랍니다.</p>
                                                                    </div>
                                                                </div><span class="content_length_counter"> 0 / 5,000</span>
                                                            </div>
                                                        </div>
                                                    </div>
                    
                                                    <!-- 비밀글로 문의하기 -->
                                                    <div class="dialog_secret">
                                                        <div></div>
                                                        <div>
                                                            <label>
                                                            <input name="isSecret" type="checkbox">
                                                                <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGcgc3Ryb2tlPSIjREREIj4KICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICA8Zz4KICAgICAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtNjY5LjAwMDAwMCwgLTEwOTAuMDAwMDAwKSB0cmFuc2xhdGUoMTAwLjAwMDAwMCwgOTM2LjAwMDAwMCkgdHJhbnNsYXRlKDU1My4wMDAwMDAsIDE0Mi4wMDAwMDApIHRyYW5zbGF0ZSgxNi4wMDAwMDAsIDEyLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICA8Y2lyY2xlIGN4PSIxMiIgY3k9IjEyIiByPSIxMS41Ii8+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIxLjUiIGQ9Ik03IDEyLjY2N0wxMC4zODUgMTYgMTggOC41Ii8+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K" alt="">
                                                                <span>비밀글로 문의하기</span>
                                                            </label>
                                                        </div>
                                                    </div>
                    
                                                    <!-- 취소/등록 -->
                                                    <div class="dialog_cancel_submit">
                                                        <button type="button">
                                                            <span>취소</span>
                                                        </button>
                                                        <button type="button" disabled="">
                                                            <span>등록</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div tabindex="0" data-test="sentinelEnd"></div>
                                </div>
                    
                                <!-- 제목 부분 -->
                                <div id="inquiry" class="inquiry_title_wrap">
                                    <strong>상품 문의</strong>
                                    <ul>
                                        <li>
                                            상품에 대한 문의를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.
                                        </li>
                                        <li>
                                            배송관련, 주문(취소/교환/환불)관련 문의 및 요청사항은
                                            <a href="#"> 1:1 문의</a>에 남겨주세요.
                                        </li>
                                    </ul>
                                </div>
                    
                    
                                <!-- 게시글 부분 -->
                                <div class="inquiry_post_wrap">
                    
                                    <table class="inquiry_post_table">
                    
                                        <thead>
                                            <tr>
                                                <th class="title">제목</th>
                                                <th class="author">작성자</th>
                                                <th class="created-date">작성일</th>
                                                <th class="status">답변상태</th>
                                            </tr>
                                        </thead>
                    
                                        <tbody>
                                            <tr class="inquiry_post">
                                                <td class="notice">
                                                    <span>공지</span> 판매(일시)중단 제품 안내 (22.11.04 업데이트)
                                                </td>
                                                <td>Palette</td>
                                                <td>2017.02.01</td>
                                                <td>-</td>
                                            </tr>
                                            <tr class="inquiry_post">
                                                <td class="secret">
                                                    <div>
                                                        <span>비밀글입니다.</span><span class="secret_icon"></span>
                                                    </div>
                                                </td>
                                                <td>김*은</td>
                                                <td>2022.10.25</td>
                                                <td class="answered">답변완료</td>
                                            </tr>
                                            <tr class="inquiry_post">
                                                <td class="secret">
                                                    <div>
                                                        <span>비밀글입니다.</span><span class="secret_icon"></span>
                                                    </div>
                                                </td>
                                                <td>김*숙</td>
                                                <td>2022.10.24</td>
                                                <td>답변대기</td>
                                            </tr>
                                            <tr class="inquiry_post">
                                                <td>상세페이지에 제품표기사항이 다른게 들어있습니다.</td>
                                                <td>박*안</td>
                                                <td>2022.10.22</td>
                                                <td>답변대기</td>
                                            </tr>
                                            <tr class="inquiry_post">
                                                <td>현재 품절인데 언제 재입고 되나요?</td>
                                                <td>김*주</td>
                                                <td>2022.10.17</td>
                                                <td class="answered">답변완료</td>
                                            </tr>
                    
                                        </tbody>
                    
                                    </table>
                                </div>
                    
                                <!-- 하단 좌우 버튼 -->
                                <div class="btn_pre_next_wrapper">
                    
                                    <button disabled type="button" class="btn_pre"></button>
                                    <button type="button" class="btn_next"></button>
                                    
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                
            </div>
            
            <!-- 위로가기 버튼 -->
            <%@ include file="/WEB-INF/view/scrollup.jsp"%>
        </div>

        <!-- footer -->
		<%@ include file="/WEB-INF/view/footer.jsp"%>  
    </div>
</body>
<script>
function ajaxUpload(e){
	e.preventDefault(); // form 안에 submit 역할을 하는 버튼을 누르면 창이 새로고침하여 실행되는데, 새로 실행하지 않게 하고싶을 경우 (submit은 작동됨)
	
	var form = document.getElementById('reviewForm');
	form.method = 'post';
	form.enctype = 'multipart/form-data';
	var fileData = new FormData(form);
	
    $.ajax({
  		url : "<%=request.getContextPath()%>/product_review_insert.lo",
  		type : "post",
  		enctype: 'multipart/form-data',
  	    cache: false,
  		data: fileData, // url로 전달'할' 데이터
  		async: false,
  	    contentType : false,
  	    processData : false, 
  	    dataType: 'json',
  		success: function(data){ // (data) : url로부터 전달'받은' 데이터
			if(data > 0) {
				alert("후기 등록 성공")
			} else {
				alert("후기 등록 실패")
			}
			$('#reviewForm')[0].reset(); // 폼내용 삭제
			close_pop(); // 폼 닫기
			location.reload(); // 새로고침 f5
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
};
</script>
</html>