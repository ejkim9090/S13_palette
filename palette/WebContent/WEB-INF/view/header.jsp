<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	   <div id="header">
           <div class="h_first">
               <div class="h_f_1">
                   <div>
                   	<c:choose>
                   		<c:when test="${empty loginSsInfo }">
	                        <a href="${pageContext.request.contextPath }/join">회원가입</a>
	                        <div>|</div>
	                        <a href="${pageContext.request.contextPath }/login">로그인</a>
	                        <div>|</div>
                   		</c:when>
                   		<c:otherwise>
                            <a href="${pageContext.request.contextPath }/mypage_wish">
                                ${loginSsInfo.mname} 님
                            </a>
							<div>|</div>
                            <a href="${pageContext.request.contextPath }/logout">로그아웃</a>
	                        <div>|</div>
                   		</c:otherwise>
                   	</c:choose>
                       <div>
                           <a href="${pageContext.request.contextPath }/notice">고객센터
                               <img src="https://res.kurly.com/pc/ico/1908/ico_down_16x10.png">
                           </a>
                           <div class="h_f_1_a3_hover" onclick="location.href='${pageContext.request.contextPath }/notice';">
                               <div>공지사항</div>
                               <div>자주하는 질문</div>
                               <div>1:1 문의</div>
                               <div>대량주문 문의</div>
                           </div>
                       </div>
                   </div>
               </div>
               <div class="h_f_2">
                   <div id="main_logo" onclick="location.href='${pageContext.request.contextPath }/main';">
                       <img src="${pageContext.request.contextPath }/images/palette_logo.png" alt="main_logo">
                   </div>
                   <div id="search" style="border: 1px solid rgb(219, 115, 150);">
                       <input type="text" placeholder="">
                       <button type="button"><img src="${pageContext.request.contextPath }/images/search_logo.svg"></button>
                   </div>
                   <div id="buttons">
                       <button type="button" onclick="location.href='${pageContext.request.contextPath }/mypage_wish';"></button>
                       <button type="button"></button>
                   </div>
               </div>
           </div>
           <div id="h_second">
               <div class="h_s_1">
                   <div id="s_category">
                       <span></span>
                       <span>카테고리</span>
                       <div>
                           <div>
                               <ul id="s_c_list">
                                   <li class="s_c_list_li">
                                       <div>
                                           <span>노트/다이어리</span>
                                       </div>
                                       <ul>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=11';"><div><span>노트</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=12';"><div><span>단어장/수첩</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=13';"><div><span>메모지</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=14';"><div><span>다이어리</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=15';"><div><span>스케줄러/플래너</span></div></li>
                                       </ul>
                                   </li>
                                   <li class="s_c_list_li">
                                       <div>
                                           <span>문구</span>
                                       </div>
                                       <ul>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=21';"><div><span>필기구</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=22';"><div><span>필통</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=23';"><div><span>스티커</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=24';"><div><span>마스킹테이프</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=25';"><div><span>파일</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=26';"><div><span>사무용품</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=27';"><div><span>데스크소품</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=28';"><div><span>카드/편지지</span></div></li>
                                       </ul>
                                   </li>
                                   <li class="s_c_list_li">
                                       <div>
                                           <span>취미</span>
                                       </div>
                                       <ul>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=31';"><div><span>FUN/TOY</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=32';"><div><span>DIY 취미</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=33';"><div><span>PARTY</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=34';"><div><span>피규어</span></div></li>
                                       </ul>
                                   </li>
                                   <li class="s_c_list_li">
                                       <div>
                                           <span>키친/홈데코</span>
                                       </div>
                                       <ul>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=41';"><div><span>키친용품</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=42';"><div><span>텀블러</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=43';"><div><span>머그/컵</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=44';"><div><span>시계</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=45';"><div><span>조명</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=46';"><div><span>디퓨저/방향제</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=47';"><div><span>인테리어소품</span></div></li>
                                       </ul>
                                   </li>
                                   <li class="s_c_list_li">
                                       <div>
                                           <span>패브릭/생활</span>
                                       </div>
                                       <ul>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=51';"><div><span>담요/방석</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=52';"><div><span>욕실용품</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=53';"><div><span>청소/정리용품</span></div></li>
                                           <li onclick = "location.href='${pageContext.request.contextPath }/category?cid=54';"><div><span>칫솔 케이스/살균기</span></div></li>
                                       </ul>
                                   </li>
                               </ul>
                           </div>
                       </div>
                   </div>
                   <ul id="s_list">
                       <li onclick = "location.href='${pageContext.request.contextPath }/category.html';"><span class="s_click">BEST</span></li>
                       <li onclick = "location.href='${pageContext.request.contextPath }/category.html';"><span class="s_click">NEW</span></li>
                       <li onclick = "location.href='${pageContext.request.contextPath }/category.html';"><span class="s_click">SALE</span></li>
                   </ul>
                   <div id="s_link">
                       <a><span></span>WALLPAPER</a>
                   </div>
               </div>
           </div>
       </div>