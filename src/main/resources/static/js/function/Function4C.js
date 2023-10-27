$(document).ready(function(){
    getUTP();
    makeNavigationBar();
})

$(document).on("click", ".stat", function(){
    $('.content_wrap .text_navi li').find('a').removeClass('on');
    $(this).find('a').addClass('on');
});

function Chapter(n) {
    let d = getLevel();
    window.location.href = "/function/Function4?d="+d+"&c="+n;
}

function getLevel() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

// 네비게이션 그리기
function makeNavigationBar() {
    var page;
    if(getLevel() == 3) {
        page = 2
    }
    else if(getLevel() == 4){
        page = 3
    }
    else {
        page = 0
    }
    let context = "<ul class='text_navi'>";
    for(let i = 0; i < page; i++) {
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
        training_id : "f4",
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
    var page=0;
    if(getLevel() == 3) {
        page = 2
    }
    else if(getLevel() == 4){
        page = 3
    }
    else {
        page = 1
    }
    let context = "";
    let count = 0;
    for(let i = 0; i < page; i++){
        context += "<div class='list_wrap1_progress pro_sub"+(i+1)+"' style='margin-bottom: 100px;'><ul class='list_wrap1_progress_gnb1'><li>구분</li><li>학습률</li><li></li></ul>";
        if(result.length > 11) {
            if (parseInt(result.length/10) == i) {
                target = parseInt(result.length%10)
            }
            else {
                target = 10;
            }
        }
        else {
            target = 11;
        }
        for(let j = 0; j < target; j++) {
            context += "<ul class='list_wrap1_progress_gnb2'>"
                    +       "<li> "+ (count+1) + "</li>"
                    +       "<li>"
                    +           "<progress id='progress' value='" + Math.round((result[count].user_act/result[count].chapter_length)*100) + "' min='0' max='100'></progress>"
                    +           "<span>" + Math.round((result[count].user_act/result[count].chapter_length)*100) + "%</span>"
                    +       "</li>"
                    +       "<li>"
                    +           "<a href='javascript:Chapter(" + count + ")'>"
                    +               "<img src='../img/function/learning_but.png' alt=''>"
                    +               "학습하기"
                    +           "</a>"
                    +       "</li>"
                    +   "</ul>";
                    count++;
        }
        context += "</div>"
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