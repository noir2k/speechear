$(document).ready(function(){
    $('.sub-menu ul').hide();
    $(".sub-menu a").click(function () {
        $(this).parent(".sub-menu").children("ul").slideToggle("100");
        $(this).find(".right").toggleClass("fa-caret-up fa-caret-down");
    });
    checkNewMember()
})
//학습 진도 확인
function checkNewMember() {
    $.ajax({
        type:"POST",
        url:"/home/checkNewMember"
    });
}

function Function1(){
    window.location.href="/function/Function1D";
}

function Function2(){
    window.location.href="/function/Function2D";
}

function Function3(){
    window.location.href="/function/Function3D";
}

function Function4(){
    window.location.href="/function/Function4D";
}

function Function5(){
    window.location.href="/function/Function5C";
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