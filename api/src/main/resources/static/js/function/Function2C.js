$(document).ready(function(){
    getUTP();
})

$(document).on("click", ".stat", function(){
    $('.content_wrap .text_navi li').find('a').removeClass('on');
    $(this).find('a').addClass('on');
});

function Chapter(n) {
    let d = getLevel();
    window.location.href = "/function/Function2?d="+d+"&c="+n;
}

function getLevel() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

function getUTP() {
    var data = {
        training_id : "f2",
        training_category : getLevel()
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
    let context =  "<div class='list_wrap1_progress pro_sub1' style='margin-bottom: 100px;'><ul class='list_wrap1_progress_gnb1'><li>구분</li><li>학습률</li><li></li></ul>";;
    for(var i = 0; i < result.length; i++){
        context +=   "<ul class='list_wrap1_progress_gnb2'>"
                +        "<li> "+ (i+1) + "</li>"
                +        "<li>"
                +            "<progress id='progress' value='" + ((result[i].user_act/result[i].chapter_length)*100) + "' min='0' max='100'></progress>"
                +            "<span>" + ((result[i].user_act/result[i].chapter_length)*100) + "%</span>"
                +        "</li>"
                +        "<li>"
                +            "<a href='javascript:Chapter(" + i + ")'>"
                +                "<img src='../img/function/learning_but.png' alt=''>"
                +                "학습하기"
                +            "</a>"
                +        "</li>"
                +    "</ul>";
    }
    context += "</div>"

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