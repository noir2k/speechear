$(document).ready(function(){
    
});

function changeSetting() {
    var nt_target = document.getElementById("noise_type");
    var nt_text = nt_target.options[nt_target.selectedIndex].text;

    var ps_target = document.getElementById("play_speed");
    var ps_text = ps_target.options[ps_target.selectedIndex].text;

    $.ajax({
        type:"POST",
        url:"/home/saveUS",
        data:{
            noise_type : nt_text,
            play_speed : ps_text
        }
    });
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