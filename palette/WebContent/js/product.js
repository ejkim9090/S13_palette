// 상단
$(function(){
    $(".prod_button_area > .button_wish").click(function(){

        if($(this).hasClass("red")){
            $("#wish_img").attr("src", "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K");
            $(this).removeClass("red");
        } else {
            $("#wish_img").attr("src", "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBmaWxsPSIjRkY1QTVBIiBzdHJva2U9IiNGRjVBNUEiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K");
            $(this).addClass("red");
        }
    });
});
// ----------------------------------------------------------------------------------------------
// 상품설명/상세정보/후기/문의 탭 누를시 색 변경

$(".prod_tab").click(function(){

    // 다른 prod_tab에서 selected 삭제
    $(".prod_tab").not($(this)).removeClass("selected");

    // 클릭한 prod_tab에서 selected 추가
    $(this).addClass("selected");
    
});

// ----------------------------------------------------------------------------------------------

// 상세정보
// 닫기버튼 누르면 하단 안보이게 / 자세히보기버튼 누르면 하단 보이게

// $("#btn_close_1").click(function(){

//     if($("#btn_close_1").hasClass("hide")) {
//         $("#btn_close_1").removeClass("hide");
//         $(".exch_refund_wrap").hide();
//     } else {
//         $("#btn_close_1").addClass("hide");
//         $(".exch_refund_wrap").show();
//     }
// });

function toggle_1() {

    var x = document.getElementById("exch_refund_wrap");
    var btn = document.getElementById("btn_close_1")

    if(x.style.display === "none") {
        x.style.display = "block";
        // 닫기 + 화살표 위
        btn.innerText = '닫기';
        btn.className = "show"        
    }
    else {
        x.style.display = "none";
        // 자세히보기 + 화살표 아래
        btn.innerText = '자세히 보기';
        btn.className = "hide"
    }
}
function toggle_2() {

    var x = document.getElementById("cancel_wrap");
    var btn = document.getElementById("btn_close_2")

    if(x.style.display === "none") {
        x.style.display = "block";
        // 닫기 + 화살표 위
        btn.innerText = '닫기';
        btn.className = "show"        
    }
    else {
        x.style.display = "none";
        // 자세히보기 + 화살표 아래
        btn.innerText = '자세히 보기';
        btn.className = "hide"
    }
}

// ----------------------------------------------------------------------------------------------
// 공감 하트
$(".helpful").click(function(){
    if($(this).hasClass("purple")){
        var imageUrl = "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTQiIGhlaWdodD0iMTQiIHZpZXdCb3g9IjAgMCAxNCAxNCIgZmlsbD0ibm9uZSIKICAgICB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgogIDxwYXRoCiAgICBkPSJNNC4wNDgzNyAxMi45OTk4SDIuMjE5MzVDMS41NDU5MiAxMi45OTk4IDEgMTIuNDYyNiAxIDExLjc5OTlWNy41OTk5MkMxIDYuOTM3MTggMS41NDU5MiA2LjM5OTkzIDIuMjE5MzUgNi4zOTk5M0g0LjA0ODM3TTguMzE2MDggNS4xOTk5NVYyLjc5OTk4QzguMzE2MDggMS44MDU4OCA3LjQ5NzIgMSA2LjQ4NzA2IDFMNC4wNDgzNyA2LjM5OTkzVjEyLjk5OTlIMTAuOTI1NUMxMS41MzM1IDEzLjAwNjYgMTIuMDUzNyAxMi41NzE1IDEyLjE0NDggMTEuOTc5OUwxMi45ODYyIDYuNTc5OTNDMTMuMDM5OSA2LjIzMTg1IDEyLjkzNTUgNS44NzgxMiAxMi43MDA4IDUuNjEyNDVDMTIuNDY2IDUuMzQ2NzggMTIuMTI0NiA1LjE5NTk2IDExLjc2NjggNS4xOTk5NUg4LjMxNjA4WiIKICAgIHN0cm9rZT0iIzk5OTk5OSIgc3Ryb2tlLXdpZHRoPSIxLjEiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIKICAgIHN0cm9rZS1saW5lam9pbj0icm91bmQiLz4KPC9zdmc+Cg==";
        $(this).find(".user_heplful").css("backgroundImage", "url('" + imageUrl +"')");
        $(this).css("color", "gray");
        $(this).removeClass("purple");
    } else {
        var imageUrl = "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTQiIGhlaWdodD0iMTQiIHZpZXdCb3g9IjAgMCAxNCAxNCIgZmlsbD0ibm9uZSIKICAgICB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgogIDxwYXRoCiAgICBkPSJNNC4wNDgzNyAxMi45OTk4SDIuMjE5MzVDMS41NDU5MiAxMi45OTk4IDEgMTIuNDYyNiAxIDExLjc5OTlWNy41OTk5MkMxIDYuOTM3MTggMS41NDU5MiA2LjM5OTkzIDIuMjE5MzUgNi4zOTk5M0g0LjA0ODM3TTguMzE2MDggNS4xOTk5NVYyLjc5OTk4QzguMzE2MDggMS44MDU4OCA3LjQ5NzIgMSA2LjQ4NzA2IDFMNC4wNDgzNyA2LjM5OTkzVjEyLjk5OTlIMTAuOTI1NUMxMS41MzM1IDEzLjAwNjYgMTIuMDUzNyAxMi41NzE1IDEyLjE0NDggMTEuOTc5OUwxMi45ODYyIDYuNTc5OTNDMTMuMDM5OSA2LjIzMTg1IDEyLjkzNTUgNS44NzgxMiAxMi43MDA4IDUuNjEyNDVDMTIuNDY2IDUuMzQ2NzggMTIuMTI0NiA1LjE5NTk2IDExLjc2NjggNS4xOTk5NUg4LjMxNjA4WiIKICAgIHN0cm9rZT0iIzVmMDA4MCIgc3Ryb2tlLXdpZHRoPSIxLjEiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIKICAgIHN0cm9rZS1saW5lam9pbj0icm91bmQiLz4KPC9zdmc+Cg==";
        $(this).find(".user_heplful").css("backgroundImage", "url('" + imageUrl +"')");
        $(this).css("color", "purple");
        $(this).addClass("purple");
    }
});

// 처음에 글 안보이게
$(document).ready(function(){
    $(".notice_content.first").hide();
})

$(document).ready(function(){
    $(".notice_content.second").hide();
})

// 공지글
function notice_click1(){
    if($(".notice_content.first").css('display') == 'none'){
        $(".notice_content.first").show();
    }else{
        $(".notice_content.first").hide();
    }
}

function notice_click2(){
    if($(".notice_content.second").css('display') == 'none'){
        $(".notice_content.second").show();
    }else{
        $(".notice_content.second").hide();
    }
}

// 제일 먼저 추천순이 보이게
$(document).ready(function(){
    $(".user_post_div_first.second").hide();
})

// 최근 등록순
$(document).ready(function(){
    $(".last_registration").click(function(){
        $(".user_post_div_first.second").show();
        $(".user_post_div_first.first").hide();
        $(".last_registration").css("color", "rgb(51, 51, 51)");
        $(".number_of_recommendations").css("color", "rgb(153, 153, 153)");
        $(".notice_content.first").hide();
        $(".notice_content.second").hide();

    })
})

// 추천순
$(document).ready(function(){
    $(".number_of_recommendations").click(function(){
        $(".user_post_div_first.first").show();
        $(".user_post_div_first.second").hide();
        $(".last_registration").css("color", "rgb(153, 153, 153)");
        $(".number_of_recommendations").css("color", "rgb(51,51,51)");
        $(".notice_content.first").hide();
        $(".notice_content.second").hide();
    })
})

// 더보기
$(document).ready(function(){
    $("#review_more_user").hide();
    $(".review_more_link").click(function(){
        $("#review_more_user").show();
    });
    $("#review_more_user_off").click(function(){
        $("#review_more_user").hide();
    });
});
// ----------------------------------------------------------------------------------------------
// 문의하기 버튼 누르면 팝업

function open_pop() {
    document.getElementById('popup').style.display = "block";
    document.body.style.overflow = "hidden"; //팝업창 뜨면 스크롤 제거
}


// X 버튼 누르면 팝업 닫기
function close_pop() {
    document.getElementById('popup').style.display = "none";
    document.body.style.overflow = "visible"; //팝업 닫으면 다시 스크롤 생성
}
//--------------------------------------------------------------------------------------------------
// 리뷰 첨부파일 개수 제한
$(function(){
	    $("input[type=file][multiple=multiple]").on("change",FileNumCheck);
	});
function FileNumCheck(){ //리뷰 첨부파일 개수 제한
	    var maxFileCnt = 5;   // 첨부파일 최대 개수
	    var curFileCnt = $(this).get(0).files.length;  // 현재 선택된 첨부파일 개수
		console.log(curFileCnt);
	    // 첨부파일 개수 확인
	    if (curFileCnt > maxFileCnt) {
	        alert("사진은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
	        $(this).get(0).value = ""; //5개 초과시 선택된 파일 다 취소
	    } 
	}