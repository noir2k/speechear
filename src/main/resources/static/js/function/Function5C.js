const dictionary = { a: 0, b: 1, c: 2, d: 3, e: 4, f: 5, g: 5, h: 5}

$(document).ready(function(){
    getUTP();
    makeNavigationBar();
})

$(document).on("click", ".stat", function(){
    $('.content_wrap .text_navi li').find('a').removeClass('on');
    $(this).find('a').addClass('on');
});

function Chapter(n) {
    window.location.href = "/function/Function5?c="+n;
}

function getLevel() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

// 네비게이션 그리기
function makeNavigationBar() {
    let context = "<ul class='text_navi'>";
    for(let i = 0; i < 2; i++) {
        context += "<li class = 'stat'><a ";
        if(i == 0) {
            context += "class = 'on'";
        }
        context += "href='javascript:changeChapterTable("+ i +")'>"+(i+1)+"</a></li>";
    }
    context += "</ul>";
    
    $("#navigationBar").append(context);
}

// 내비게이션 바꾸기
function changeChapterTable(n) {
    $('.list_wrap1_progress').hide();
    let cls = ".platform_wrap .list_wrap1 .pro_sub"+(n+1);
    $(cls).css('display','block')
}

function getUTP() {
    var data = {
        training_id : "f5"
    }
    $.ajax({
        type:"POST",
        url:"/home/getUTP",
        data:data,
        success: function(result)
        {
            makeChapterTable(result);
        }
    });
}

// 챕터 테이블 그리기
function makeChapterTable(result) {
    let context = "";
    for(let i = 0; i < 2; i++){
        context += "<table class='list_wrap1_progress pro_sub"+(i+1)+"' style='margin-bottom: 100px;'><tbody><tr><td colspan='10'>오늘 풀어볼 퀴즈를 고르세요</td></tr>";
        for(let j = 50*i; j < 50*(i+1); j++) {
            if(j % 10 == 0) {
                context += "<tr>";
            }
            context += "<td style='width: 160px"
            if(result[j].user_act == 1) {
                context += "; background-color: #add8e6"
            }
            context += "'><a href = 'javascript:Chapter(" + (j+1) + ")'>퀴즈 " + (j+1) + "</a>"+
                       "</td>";
            if(i % 10 == 9) {
                context += "</tr>";
            }
        }
        context += "</tbody></table>"
    }
    $("#chapterTable").prepend(context);
}

// (공통) 내 정보 확인 팝업
window.addEventListener('click',(e) => {
    if(e.target.id == "user"){
        $(".pop").css("display","block");
        return 0;
    }

    if( $(".pop").css("display") == "block" &&
        e.target.parentNode.className != "pop" &&
        e.target.parentNode.className != "user" &&
        e.target.parentNode.className != "photo") {
        $(".pop").css("display","none");
    }
})