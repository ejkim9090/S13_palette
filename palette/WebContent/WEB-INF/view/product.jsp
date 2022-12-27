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
                                <a href="#detail"><span>상세정보</span></a>
                            </div>
                            <div class="prod_tab">
                                <a href="#review"><span>후기</span><span class="number">(9,999+)</span></a>
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
                            
                        </div>

                        <!-- 상세정보 (최경선) -->
<!--                         <div id="detail" style="position: relative; top: -200px;"></div>
                        <div class="detail_wrap">

                            상세정보 이미지 
                            <div class="detail_image_wrap">
                                <img src="https://img-cf.kurly.com/shop/data/goodsview/20221024/gv10000439272_1.jpg"
                                    alt="자세히보기 이미지" class="detail_image">
                            </div>
                    
                            상품고시정보
                            <div class="prod_info_wrap">
                                <h3>상품고시정보</h3>
                    
                                <ul class="prod_info_list_wrap">
                                    <li>제품명</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>식품의 유형</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>생산자및소재지(수입품의경우생산자,수입자및제조국)</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>제조연월일,유통기한또는품질유지기한</li>
                                    <li>제품 별도 라벨 표기 참조</li>
                                    <li>포장단위별 내용물의 용량(중량), 수량</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>원재료명및함량(농수산물의원산지표시에관한법률에따른원산지표시포함)</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>영양성분(식품등의표시·광고에관한법률에 따른 영양성분 표시대상 식품에 한함)</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>유전자변형식품에해당하는경우의표시</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>소비자안전을 위한 주의사항</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>수입식품에 해당하는 경우 “수입식품안전관리특별법에 따른 수입신고를 필함”의 문구</li>
                                    <li>상품설명 및 상품이미지 참조</li>
                                    <li>소비자상담관련전화번호</li>
                                    <li>마켓컬리 고객행복센터 (1644-1107)</li>
                                    <li></li>
                                </ul>
                            </div>
                            판매자정보
                            <div class="prod_info_wrap">
                                <h3>판매자정보</h3>
                    
                                <ul class="prod_info_list_wrap">
                                    <li>판매자</li>
                                    <li>컬리</li>
                                </ul>
                            </div>
                    
                    
                            WHY KURLY
                            <div class="why_kurly_wrap">
                    
                                <div class="why_kurly_title_wrap">
                                    <span>WHY KURLY</span>
                                </div>
                    
                                <div class="why_kurly_list_wrap">
                                    <dl>
                                        <dt class="why_kurly_list_1">깐깐한 상품위원회</dt>
                                        <dd>나와 내 가족이 먹고 쓸 상품을 고르는<br>마음으로 매주 상품을 직접 먹어보고,<br>
                                            경험해보고 성분, 맛, 안정성 등 다각도의<br>기준을 통과한 상품만을 판매합니다.
                                            <span>(온라인 기준 / 자사몰, 직구 제외)</span>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt class="why_kurly_list_2">차별화된 Kurly Only 상품</dt>
                                        <dd>전국 각지와 해외의 훌륭한 생산자가<br>믿고 선택하는 파트너, 마켓컬리.<br>
                                            3천여 개가 넘는 컬리 단독 브랜드, 스펙의<br>Kurly Only 상품을 믿고 만나보세요.
                                            <span>(온라인 기준 / 자사몰, 직구 제외)</span>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt class="why_kurly_list_3">신선한 풀콜드체인 배송</dt>
                                        <dd>온라인 업계 최초로 산지에서 문 앞까지<br>상온, 냉장, 냉동 상품을 분리 포장 후<br>
                                            최적의 온도를 유지하는 냉장 배송 시스템,<br>풀콜드체인으로 상품을 신선하게 전해드립니다.
                                            <span>(샛별배송에 한함)</span>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt class="why_kurly_list_4">고객, 생산자를 위한 최선의 가격</dt>
                                        <dd>매주 대형 마트와 주요 온라인 마트의 가격<br>변동 상황을 확인해 신선식품은 품질을<br>
                                            타협하지 않는 선에서 최선의 가격으로,<br>가공식품은 언제나 합리적인 가격으로<br>정기 조정합니다.
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt class="why_kurly_list_5">환경을 생각하는 지속 가능한 유통</dt>
                                        <dd>친환경 포장재부터 생산자가 상품에만<br>집중할 수 있는 직매입 유통구조까지,<br>
                                            지속 가능한 유통을 고민하며 컬리를 있게<br>하는 모든 환경(생산자, 커뮤니티, 직원)이<br>더 나아질 수 있도록 노력합니다.
                                        </dd>
                                    </dl>
                                </div>
                            </div>
                    
                    
                            고객행복센터
                            <div class="customer_center_wrap">
                    
                                <div class="customer_center_title">
                                    <h5>고객행복센터</h5>
                                    <p>궁금하신 점이나 서비스 이용에 불편한 점이 있으신가요?
                                        <span>문제가 되는 부분을 사진으로 찍어 아래 중 편하신 방법으로 접수해 주시면 빠르게 도와드리겠습니다.</span>
                                    </p>
                                </div>
                    
                                <ul class="customer_center_list_wrap">
                                    <li>
                                        <strong>전화 문의 1644-1107</strong>
                                        <span>월~토요일 오전 7시 - 오후 6시</span>
                                    </li>
                                    <li>
                                        <strong>카카오톡 문의</strong>
                                        <span>월~토요일 오전 7시 - 오후 6시</span>
                                        <span>일/공휴일 오전 7시 - 오후 1시</span>
                                        <span class="add">카카오톡에서 '마켓컬리' 를 검색 후<br>대화창에 문의 및 불편사항을<br>남겨주세요.</span>
                                    </li>
                                    <li>
                                        <strong>홈페이지 문의</strong>
                                        <span>365일</span>
                                        <span>로그인 &gt; 마이컬리 &gt; 1:1 문의</span>
                                        <span class="add">고객센터 운영 시간에 순차적으로<br>답변해드리겠습니다.</span>
                                    </li>
                                </ul>
                            </div>
                            
                    
                            <div>
                    
                                교환 및 환불 안내
                                <div class="exch_refund_title_wrap">
                                    <strong>교환 및 환불 안내</strong>
                                    <p>교환 및 환불이 필요하신 경우 고객행복센터로 문의해주세요.</p>
                                    <button type="button" id="btn_close_1" class="show" onclick="toggle_1()">닫기</button>
                                </div>
                    
                                <div id="exch_refund_wrap">
                    
                                    <div class="exch_refund_wrap">
                                        <strong>01. 상품에 문제가 있는 경우</strong>
                                        <p>받으신 상품이 표시·광고 내용 또는 계약 내용과 다른 경우에는 상품을 받은 날부터 3개월 이내,
                                            그 사실을 알게 된 날부터 30일 이내에 교환 및 환불을 요청하실 수 있습니다.
                                            상품의 정확한 상태를 확인할 수 있도록 사진을 함께 보내주시면 더 빠른 상담이 가능합니다.
                    
                                            ※ 상품에 문제가 있는 것으로 확인되면 배송비는 컬리가 부담합니다.
                                        </p>
                                    </div>
                                    <div class="exch_refund_wrap">
                                        <strong>02. 단순 변심, 주문 착오의 경우</strong>
                                        <p><bold class="bold">신선 / 냉장 / 냉동 식품</bold>재판매가 불가한 상품의 특성상, 단순 변심, 주문 착오 시 교환 및 반품이 어려운 점 양해 부탁드립니다.
                                            상품에 따라 조금씩 맛이 다를 수 있으며, 개인의 기호에 따라 같은 상품도 다르게 느끼실 수 있습니다.
                                            <bold class="bold">유통기한 30일 이상 식품 (신선 / 냉장 / 냉동 제외) &amp; 기타 상품</bold>상품을 받은 날부터 7일 이내에 고객행복센터로 문의해주세요.
                                            ※ 단순 변심으로 인한 교환 또는 환불의 경우 고객님께서 배송비 6,000원을 부담하셔야 합니다.
                                            (주문 건 배송비를 결제하셨을 경우 3,000원)
                                        </p>
                                    </div>
                    
                                    <div class="exch_refund_wrap">
                                        <strong>03. 교환·반품이 불가한 경우</strong>
                                        <p>다음에 해당하는 교환·환불 신청은 처리가 어려울 수 있으니 양해 부탁드립니다.
                    
                                            <span>- 고객님의 책임 있는 사유로 상품이 멸실되거나 훼손된 경우
                                            (단, 상품의 내용을 확인하기 위해 포장 등을 훼손한 경우는 제외)</span>
                                            <span>- 고객님의 사용 또는 일부 소비로 상품의 가치가 감소한 경우</span>
                                            <span>- 시간이 지나 다시 판매하기 곤란할 정도로 상품의 가치가 감소한 경우</span>
                                            <span>- 복제가 가능한 상품의 포장이 훼손된 경우</span>
                                            <span>- 고객님의 주문에 따라 개별적으로 생산되는 상품의 제작이 이미 진행된 경우</span>
                                        </p>
                                    </div>
                                </div>
                                
                                주문 취소 안내
                                <div class="cancel_title_wrap">
                                    <strong>주문 취소 안내</strong>
                                    <p><bold>- [주문완료] 상태일 경우에만 주문 취소 가능합니다. 
                                            <br>- [마이컬리 &gt; 주문내역 상세페이지] 에서 직접 취소하실 수 있습니다.</bold>
                                    </p>
                                    <button type="button" id="btn_close_2" class="show" onclick="toggle_2()">닫기</button>
                                </div>
                    
                                <div id="cancel_wrap">
                    
                                    <div class="cancel_wrap">
                                        <strong>주문 취소 관련</strong>
                                        <p> - [배송준비중] 부터는 취소가 불가하니, 반품으로 진행해주세요. (상품에 따라 반품이 불가할 수 있습니다.)
                                            - 주문마감 시간에 임박할수록 취소 가능 시간이 짧아질 수 있습니다.
                                            - 비회원은 App 또는 모바일 웹사이트에서 [마이컬리 &gt; 비회원 주문조회 페이지] 에서 취소가 가능합니다.
                                            - 일부 예약상품은 배송 3~4일 전에만 취소 가능합니다.
                                            - 주문상품의 부분취소는 불가능합니다. 전체 주문 취소 후 다시 구매 해주세요.
                                        </p>
                                    </div>
                                    <div class="cancel_wrap">
                                        <strong>결제 승인 취소 / 환불 관련</strong>
                                        <p>- 카드 환불은 카드사 정책에 따르며, 자세한 사항은 카드사에 문의해주세요. 
                                            - 결제 취소 시, 사용하신 적립금과 쿠폰도 모두 복원됩니다.</p>
                                    </div>
                                </div>
                    
                                    배송관련 안내
                                    <div class="delivery_title_wrap">
                                        <strong>배송관련 안내</strong>
                                        <p>배송 과정 중 기상 악화 및 도로교통 상황에 따라 부득이하게 지연 배송이 발생될 수 있습니다.</p>
                                        <div id="review"></div>
                                    </div>
                    
                            </div>
                        </div>
 -->
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
                                
                                <form name="review" action="product/review/insert.do" method="post" enctype="multipart/form-data">
                                	
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
                                                        <button type="submit">
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
                    
                                <!-- 상품후기 바로 밑 사진 1~8개-->
                                <div class="review_photo">
<c:forEach items="${rimagelist}" var="vo" begin="1" end="8">  
									<img src="<%=request.getContextPath()%>/${vo.rfilepath}">
</c:forEach>
                                    <!-- +더보기 링크 -->
                                    <button class="review_more_link"><span>+더보기</span></button>
                                </div>
                    
                                <div class="user_review_div">
                                    <!-- 총 게시물 수 -->
                                    <div class="total_post">
                                        <span class="total_post_span">총 ${fn:length(reviewlist) }개</span>
                                    </div>
                                </div>
<c:choose>
	<c:when test="${empty reviewlist}">
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
                                            배송관련, 주문(취소/교환/환불)관련 문의 및 요청사항은 마이컬리 내
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
                                                <td>Marketkurly</td>
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
</html>