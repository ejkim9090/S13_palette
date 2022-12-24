<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
    
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollup.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/main.js"></script>


    <title>로그인 - 컬리</title>
    <style>
        #section {
            width: 100%;
        }
        html{
            scroll-behavior: smooth;
        }
    </style>
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
            <div id="section_child_1">
                <div class="login_area" id="login_txt">로그인</div>
                <div class="login_area" id="login_user_area">
                    <form action="<%=request.getContextPath()%>/login.do" method="post">
                        <div class="input_area">
                            <input type="text" id="input_ID" name="mid" placeholder="아이디를 입력해주세요">
                            <input type="password" id="input_PW" name="mpw" placeholder="비밀번호를 입력해주세요">
                        </div>
                        <div id="submit_area">
                            <button type="submit" id="login_btn">
                                <span>로그인</span>
                            </button>
                            <button type="button" id="join_btn" onclick="location.href='<%=request.getContextPath()%>/join.html'">
                                <span>회원가입</span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <%@ include file="/WEB-INF/view/footer.jsp"%>
    </div>
</body>
</html>