var speechcontext = [];
var answer = [];
var saudioData = [];
var qaudioData = [];
var checkShow = false;
var currentIndex = 0;
var startTime;
var score = [];
var play = false;
// var fastWinding = false;

$(document).ready(function(){
    data = {
        category : getCategory(),
        chapter : getChapter()
    };
    
    $.ajax({
        type:"POST",
        url:"/function/Function2/getAudioInfo",
        data:data,
        success: function(result)
        {
            $("#answer").text(result[0].answer);
            $("#saudio").attr("src",result[0].saudio);
            $("#qaudio").attr("src",result[0].qaudio);
            $("#speechcontext").text(result[0].speechcontext + '\n' + result[0].questioncontext);
            for(var i = 0; i < result.length; i++) {
                speechcontext[i] = result[i].speechcontext + '\n' + result[i].questioncontext;
                answer[i] = result[i].answer;
                saudioData[i] = result[i].saudio;
                qaudioData[i] = result[i].qaudio;
            }

            let now = new Date();   
            startTime = now;
        },
        beforeSend:function()
        {    
            $('.wrap-loading').removeClass('display-none');
        },
        complete:function()
        {
            $('.wrap-loading').addClass('display-none');
        }
    })
})

function returnToChapter() {
    location.href="/function/Function2C?d="+getCategory();
}

function getChapter() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('c');
}

function getCategory() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

function playAudioFile() {
    var name = "saudio";
    var name2 = "qaudio";

    if(!play && document.getElementById(name2).currentTime == 0) {
        play = true;
        
        $("#startBar").css('backgroundColor', '#74cdb8');
        $("#saudioImg").attr('src','/img/function/pause.png');
        document.getElementById(name).play();
        document.getElementById(name).addEventListener("ended",
            function()
            {
                document.getElementById("qaudio").play();
                document.getElementById(name2).addEventListener("ended",
                    function()
                    {
                        $("#startBar").css('backgroundColor', '#63A4DB');
                        $("#saudioImg").attr('src','/img/function/play2.png');
                        play = false;
                    }
                );
            }
        );
    }
    else if (!play && document.getElementById(name2).currentTime != 0) {
        play = true;
        $("#startBar").css('backgroundColor', '#74cdb8');
        $("#saudioImg").attr('src','/img/function/pause.png');
        document.getElementById(name2).play();
        document.getElementById(name2).addEventListener("ended",
            function()
            {
                document.getElementById(name2).currentTime = 0;
                $("#startBar").css('backgroundColor', '#63A4DB');
                $("#saudioImg").attr('src','/img/function/play2.png');
                play = false;
            }
        );
    }
    else {
        $("#startBar").css('backgroundColor', '#63A4DB');
        $("#saudioImg").attr('src','/img/function/play2.png');
        document.getElementById(name).pause();
        document.getElementById(name2).pause();
        play = false;
    }
}

function pauseAudioFile() {
    var name = "saudio";
    var name2 = "qaudio";
    $("#startBar").css('backgroundColor', '#63A4DB');
    $("#saudioImg").attr('src','/img/function/play2.png');
    document.getElementById(name).pause();
    document.getElementById(name).currentTime=0;
    document.getElementById(name2).pause();
    document.getElementById(name2).currentTime=0;
    play = false;
}

// 드롭다운 메뉴 js
function showContext() {
    if(!checkShow) {
        checkShow = true;
        $('.drop-down1').stop().slideDown();
    }
    else {
        checkShow = false;
        $('.drop-down1').stop().slideUp();
    }
}

// function fastWind() {
//     if(!fastWinding) {
//         document.getElementById("saudio").playbackRate = 1.8;
//         document.getElementById("qaudio").playbackRate = 1.8;
//         document.getElementById("saudio").preservesPitch = true;
//         document.getElementById("qaudio").preservesPitch = true;
//         document.getElementById("fastWindButton").style.opacity = "1.0";
//         document.getElementById("fastWindButton").onmouseover = undefined;
//         document.getElementById("fastWindButton").onmouseleave = undefined;
//         fastWinding = true;
//     }
//     else {
//         document.getElementById("saudio").playbackRate = 1.0;
//         document.getElementById("qaudio").playbackRate = 1.0;
//         // document.getElementById("saudio").preservesPitch = false;
//         // document.getElementById("qaudio").preservesPitch = false;
//         document.getElementById("fastWindButton").style.opacity = "0.6";
//         document.getElementById("fastWindButton").onmouseover = function(){this.style.opacity = "1.0";}
//         document.getElementById("fastWindButton").onmouseleave = function(){this.style.opacity = "0.6";}
//         fastWinding = false;
//     }
// }

function Scoring(n) {
    if (n == 1) {
        score[currentIndex] = 1;
        document.getElementById("correctCheck").style.opacity = "1.0"
        document.getElementById("wrongCheck").style.opacity = "0.6"
        document.getElementById("correctCheck").onmouseover = undefined;
        document.getElementById("correctCheck").onmouseleave = undefined;
        document.getElementById("wrongCheck").onmouseover = function(){this.style.opacity = "1.0";}
        document.getElementById("wrongCheck").onmouseleave = function(){this.style.opacity = "0.6";}
    }
    else {
        score[currentIndex] = 0;
        document.getElementById("correctCheck").style.opacity = "0.6"
        document.getElementById("wrongCheck").style.opacity = "1.0"
        document.getElementById("wrongCheck").onmouseover = undefined;
        document.getElementById("wrongCheck").onmouseleave = undefined;
        document.getElementById("correctCheck").onmouseover = function(){this.style.opacity = "1.0";}
        document.getElementById("correctCheck").onmouseleave = function(){this.style.opacity = "0.6";}
    }
}

function changeFile(index) {
    if(score[currentIndex] == null) {
        alert("채점을 진행해주십시오.");
        return;
    }
    pauseAudioFile();

    document.getElementById("correctCheck").style.opacity = "0.6"
    document.getElementById("wrongCheck").style.opacity = "0.6"
    document.getElementById("correctCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("correctCheck").onmouseleave = function(){this.style.opacity = "0.6";}
    document.getElementById("wrongCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("wrongCheck").onmouseleave = function(){this.style.opacity = "0.6";}

    // fastWinding = false;
    // document.getElementById("saudio").playbackRate = 1.0;
    // document.getElementById("qaudio").playbackRate = 1.0;
    // document.getElementById("fastWindButton").style.opacity = "0.6";
    // document.getElementById("fastWindButton").onmouseover = function(){this.style.opacity = "1.0";}
    // document.getElementById("fastWindButton").onmouseleave = function(){this.style.opacity = "0.6";}

    if(index > 0) {
        if(currentIndex >= answer.length-1) {
            currentIndex += 1;
            $("#qnumber").text(currentIndex+1);
            alert("모두 끝났습니다.");
            location.href="/home/FunctionSelect";
            return;
        }

        currentIndex += 1;
    }
    else {
        if(currentIndex == 0) {
            alert("첫 문제입니다.");
            return;
        }

        currentIndex -= 1;
    }
    checkShow = false;
    $('.drop-down1').stop().slideUp();
    $("#qnumber").text(currentIndex+1);
    $("#saudio").attr("src",saudioData[currentIndex]);
    $("#qaudio").attr("src",qaudioData[currentIndex]);
    
    $("#accordion-2").prop("checked",false)
    setTimeout(
        function() {
            $("#speechcontext").text(speechcontext[currentIndex]);
            $("#answer").text(answer[currentIndex]);
        },
    1000);
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

window.addEventListener('unload', function() {
    let now = new Date();
    let result = (now-startTime)/1000;
    navigator.sendBeacon("/function/Function2/UserActivity",result);

    let utp = "f2-" + getCategory() + "-" + getChapter() + "-" + $("#qnumber").text();
    navigator.sendBeacon("/home/saveUTP",utp);

    if(score.length != 0) {
        let scoreSum = 0;
        for(var i = 0; i < score.length; i++) {
            scoreSum += score[i];
        }
        let uts = "f2-" + getCategory() + "-" + getChapter() + "-" + scoreSum;
        navigator.sendBeacon("/home/saveUTS",uts);
    }
});