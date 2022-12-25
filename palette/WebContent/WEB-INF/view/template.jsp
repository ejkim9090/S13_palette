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
    <!-- TODO 여기에 해당 파일의 css -->
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <!-- TODO 여기에 해당 파일의 js -->
    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
    <title>TODO</title>
</head>
<body>
    <div>
		<%@ include file="/WEB-INF/view/header.jsp"%>
		
        <div id="section">
            <div class="main_section">
                <!-- 맨위 상단 섹션-->
                <!-- 첫번째 섹션 -->
                <!-- 상단 버튼 추가 섹션 -->
                <!-- 상단 버튼 추가 섹션 -->
                <!-- 컬리의 레시피 section -->
                <!-- 광고 -->
                <!-- 3번째 section - instagram -->
            </div>
        	
        	<%@ include file="/WEB-INF/view/scrollup.jsp"%>
        </div>
        
        <%@ include file="/WEB-INF/view/footer.jsp"%>
    </div>
</body>
</html>