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
    <link href="<%=request.getContextPath()%>/css/join.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/radio_check_action.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/checkbox_check_action.css" rel="stylesheet">

    <script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/header.js"></script>
    <script src="<%=request.getContextPath()%>/js/join.js"></script>
    

    <title>회원가입</title>
    <style>
        #section {
            width: 100%;
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
    <div id="pop_up_parent">
        <div id="pop_up_1">
            <div>
                <div id="pop_up_1_content">
                    <div id="pop_up_1_content_text">6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합</div>
                    <div>
                        <button type="button" onclick="close_pop_up_1()">확인</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="pop_up_2">
            <div>
                <div id="pop_up_2_content">
                    <div id="pop_up_2_content_text">이메일을 입력해 주세요.</div>
                    <div>
                        <button type="button" onclick="close_pop_up_2()">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
    
		<%@ include file="/WEB-INF/view/header.jsp"%>
		
        <div id="section">
            <div>
                <div id="section_child_1">
                    <span>회원가입</span>
                </div>
                <div id="section_child_2">
                    <div id="form_area">
                        <div>
                            <span>* </span>필수입력사항
                        </div>
                        <form action="<%=request.getContextPath()%>/join.do" method="post">
                            <div id="login_tbl_frame">
                                <table id="login_tbl">
                                    <tr>
                                        <td><label>아이디<span>*</span></label></td>
                                        <td><input type="text" id="input_id" name="mid" placeholder="아이디를 입력해주세요" autocomplete="off" oninput="id_script(this, 6, 17)" maxlength="16" required><p id="input_id_p"></p></td>
                                        <td><button type="button" class="info_check_button" onclick="open_pop_up_1()"><span>중복확인</span></button></td>
                                    </tr>
                                    <tr>
                                        <td><label>비밀번호<span>*</span></label></td>
                                        <td><input type="password" id="input_pw" name="mpw" placeholder="비밀번호를 입력해주세요" autocomplete="off" oninput="input_pw_script(this, 10)" maxlength="16" required><p id="input_pw_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>비밀번호확인<span>*</span></label></td>
                                        <td><input type="password" id="input_pw_check" name="mpw_check" placeholder="비밀번호를 한번 더 입력해주세요" autocomplete="off" maxlength="16" oninput="input_pw_check_script(this)"  maxlength="16" required><p id="input_pw_check_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>이름<span>*</span></label></td>
                                        <td><input type="text" id="input_user_name" name="mname" placeholder="이름을 입력해 주세요" autocomplete="off" oninput="input_user_name_script(this)" required><p id="input_user_name_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>이메일<span>*</span></label></td>
                                        <td><input type="text" id="input_mail" name="memail" placeholder="예: palette@palette.com" autocomplete="off" oninput="input_mail_script(this)" required><p id="input_mail_p"></p></td>
                                        <td><button type="button" class="info_check_button" onclick="open_pop_up_2()"><span>중복확인</span></button></td>
                                    </tr>
                                    <tr>
                                        <td><label>주소<span>*</span></label></td>
                                        <td><input id="numberAddress" name="maddr1" placeholder="주소를 검색해 주세요" type="text" readonly required></td>
                                        <td><button type="button" class="info_check_button" id="search_loc"><span><img src=".\images\ico_search.svg"> 주소 검색</span></button></td>
                                    </tr>
                                    <tr>
                                    	<td><label><span></span></label></td>
                                    	<td><input id="subAddress" name="maddr2" placeholder="나머지 주소를 입력해주세요" type="text" required></td>
                                    </tr>
                                    <tr>
                                        <td><label>성별</label></td>
                                        <td>
                                            <div id="radio_button_parent">
                                                <label class="radio_button"><input type="radio" name="mgender" value="M"><span>남자</span></label>
                                                <label class="radio_button"><input type="radio" name="mgender" value="F"><span>여자</span></label>
                                                <label class="radio_button"><input type="radio" name="mgender" value="0" checked><span>선택 안함</span></label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><label>생년월일</label></td>
                                        <td>
                                            <div id="input_birthday_area">
                                                <input type="text" id="input_birth_year" name="mbyear" placeholder="YYYY" autocomplete="off" oninput="input_birth_script()" maxlength="4"><span>/</span>
                                                <input type="text" id="input_birth_month" name="mbmonth" placeholder="MM" autocomplete="off" oninput="input_birth_script()" maxlength="2"><span>/</span>
                                                <input type="text" id="input_birth_date" name="mbdate" placeholder="DD" autocomplete="off" oninput="input_birth_script()" maxlength="2">
                                            </div>
                                            <p id="input_birth_p"></p>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div id="info_agreement">
                                <div><span>이용약관동의</span><span>*</span></div>
                                <div>
                                    <div>
                                        <div>
                                            <label onclick="agree_all()"><input type="checkbox" name="" id="agree_all"><span>전체 동의합니다.</span></label>
                                            <p id="agreement_warn">선택항목에 동의하지 않은 경우도 회원가입 및 일반적인 서비스를 이용할 수 있습니다.</p>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <label><input type="checkbox" name="" class="agree_check" required><span>이용약관 동의</span></label><span class="user_select">(필수)</span>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <label><input type="checkbox" name="" class="agree_check" required><span>개인정보 수집&#8729;이용 동의</span></label><span class="user_select">(필수)</span>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <label><input type="checkbox" name="mconsent" value="1" class="agree_check"><span>개인정보 수집&#8729;이용 동의</span></label><span class="user_select">(선택)</span>
                                        </div>
                                    </div>
                                    <div id="sms_agreement">
                                        <div>
                                            <label onclick="sms_all()"><input type="checkbox" name="" class="agree_check" id="sms_all"><span>무료배송, 할인쿠폰 등 혜택/정보 수신 동의</span></label><span class="user_select">(선택)</span>
                                        </div>
                                        <div>
                                            <label><input type="checkbox" name="mconsent" value="2" class="agree_check sms_each"><span>SMS</span></label>
                                            <label><input type="checkbox" name="mconsent" value="3" class="agree_check sms_each"><span>이메일</span></label>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <label><input type="checkbox" name="" class="agree_check" required><span>본인은 14세 이상입니다.</span></label><span class="user_select">(필수)</span>
                                        </div>
                                    </div>
                                </div>
    
                            </div>
                            <div id="submit_area">
                                <button type="submit" id="submit">
                                    <span>가입하기</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </div>
        
		<%@ include file="/WEB-INF/view/footer.jsp"%>
    </div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){
	
	// 카카오 주소찾기 api
    $("#search_loc").click(function(){ //주소검색버튼을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("numberAddress").value = data.address; // 주소 넣기
                document.querySelector("input[name=maddr2]").focus(); //상세입력 포커싱
            }
        }).open();
    });
    
    // checkbox 체크된 값 더하기 // TODO
    $("#submit").click(function(){
    	var checkValue = 0;
    	
    	$("input[name='mconsent']:checked").each(function(){
    		console.log($(this).val());
    		checkValue += Number($(this).val());
        })
    	//합계를 출력
    	$("input[name='mconsent']").val(checkValue); // mconsent의 value에 합계 입력
    });
    
    
    
    
    
    
    
    
    
    
});
</script>
</html>