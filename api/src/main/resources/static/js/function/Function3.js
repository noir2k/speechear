var speechcontext = [];
var questioncontext = [];
var answer = [];
var audioData = [];
var questionArray;
var checkShow = false;
var checkShow2 = false;
var startIndex = 0;
var startTime;
var score = [];
var play = false;
// var fastWinding = false;
var qnumber = 1;

$(document).ready(function(){
    data = {
        code : getCategory()+(parseInt(getChapter())+1)
    };
    
    $.ajax({
        type:"POST",
        url:"/function/Function3/getAudioInfo",
        data:data,
        success: function(result)
        {
            for(var i = 0; i < result.length; i++) {
                speechcontext[i] = result[i].speechcontext;
                questioncontext[i] = result[i].questioncontext;
                answer[i] = result[i].answer;
                audioData[i] = result[i].audio;
            }
            questioncontext = setQCOrder(questioncontext);
            answer = setQCOrder(answer);
            getQuestionArray();

            document.getElementById("speechcontext").innerText = result[0].speechcontext.replaceAll('. ','.\n');
            $("#answer").text(result[0].answer);
            $("#audio").attr("src",result[0].audio);
            setQuestionContext();

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

function setQCOrder(arr) {
    var arr2 = [];
    for (var i = 0; i < arr.length; i++) {
        arr2[i] = arr[arr.length-(i+1)];
    }
    return arr2;
}

function returnToChapter() {
    location.href="/function/Function3C?d="+getCategory();
}

function getChapter() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('c');
}

function getCategory() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

function getQuestionArray() {
    var count = 1;
    var qArr = [];
    for(var i = 0; i < speechcontext.length; i++) {
        if (speechcontext[i] == speechcontext[i+1]) {
            count++;
        }
        else if ((speechcontext[i] != speechcontext[i+1]) || (i+1 == result.length)){
            qArr.push(count);
            count = 1;
        }
    }

    questionArray = qArr;
}

function setQuestionContext() {
    var context = "<ul class='content2_s2' id = 'qc' hidden = true>";
    for(var i = startIndex; i < startIndex+questionArray[0]; i++) {
        context
        += "<li>"
        +       "<h3>"
        +           "<a href='#'>? </a>"
        +           questioncontext[i]
        +       "</h3>"
        +       "<div>"
        +           "<a href='javascript:showAnswer(" + (i+1) + ")'>"
        +               "<img src='/img/function/check_1.png' alt='체크'>"
        +           "</a>"
        +           "<div class='content2_s2_text text_q1'>"
        +               "<span id = 'answer" + (i+1) + "'>"
        +                   "텍스트입력1"
        +               "</span>"
        +               "<ul class='text_ox hidden_ox1' id = 'ox" + (i+1) + "'>"
        +                   "<li id = 'correctCheck" + i + "'>"
        +                       "<a href='javascript:Scoring(" + i + ",1)'>O</a>"
        +                   "</li>"
        +                   "<li id = 'wrongCheck" + i + "'>"
        +                       "<a href='javascript:Scoring(" + i + ",0)'>X</a>"
        +                   "</li>"
        +               "</ul>"
        +           "</div>"
        +       "</div>"
        +  "</li>"
        ;
    }
    context += "</ul>";
    
    $("#questioncontext").append(context);
}

function playAudioFile() {
    var name = "audio";
    
    if(!play) {
        play = true;
        document.getElementById("audioButton").src = "/img/function/bnt_4.png"
        document.getElementById(name).play();
        document.getElementById(name).addEventListener("ended",
            function() {
                document.getElementById("audioButton").src = "/img/function/bnt_3.png"
                play = false;
            }
        );
    }
    else {
        play = false;
        pauseAudioFile();
    }
}

function pauseAudioFile() {
    var name = "audio";
    document.getElementById(name).pause();
    document.getElementById("audioButton").src = "/img/function/bnt_3.png"
}

function showContext() {
    if(!checkShow) {
        $("#speechcontext").show();
        checkShow = true;
    }
    else {
        $("#speechcontext").hide();
        checkShow = false;
    }

    if(!checkShow && !checkShow2) {
        $(".content2_wrap").css({
            "background":"url(../../img/function/sound_bg.png)",
            "background-repeat":"no-repeat",
            "background-position":"50% 90%",
            "background-size":"400px 400px"
        })
    }
    else {
        $(".content2_wrap").css({
            "background":"url('')",
        })
    }
}

function showQuestion() {
    if(!checkShow2) {
        $("#qc").show();
        checkShow2 = true;
    }
    else {
        $("#qc").hide();
        checkShow2 = false;
    }

    if(!checkShow && !checkShow2) {
        $(".content2_wrap").css({
            "background":"url(../../img/function/sound_bg.png)",
            "background-repeat":"no-repeat",
            "background-position":"50% 90%",
            "background-size":"400px 400px"
        })
    }
    else {
        $(".content2_wrap").css({
            "background":"url('')",
        })
    }
}

function showAnswer(index) {
    var name = "answer" + index;
    var name2 = "ox" + index;
    
    document.getElementById(name).innerText = answer[index-1];
    document.getElementById(name).style.display = 'flex';
    document.getElementById(name2).style.display = 'flex';
}

function submit() {
    if(score.length != questioncontext.length) {
        alert("채점을 진행해주십시오.");
        return;
    }
    else {
        for(var i = 0; i < score.length; i++) {
            if(score[i] == null) {
                alert("채점을 모두 진행해주십시오.");
                return;
            }
        }
    }

    qnumber = 2;
    alert("훈련을 마쳤습니다.");
    location.href="/home/FunctionSelect";
}

// function fastWind() {
//     if(!fastWinding) {
//         document.getElementById("audio").playbackRate = 1.8;
//         document.getElementById("audio").preservesPitch = true;
//         document.getElementById("fastWindButton").style.opacity = "1.0";
//         document.getElementById("fastWindButton").onmouseover = undefined;
//         document.getElementById("fastWindButton").onmouseleave = undefined;
//         fastWinding = true;
//     }
//     else {
//         document.getElementById("audio").playbackRate = 1.0;
//         // document.getElementById("audio").preservesPitch = false;
//         document.getElementById("fastWindButton").style.opacity = "0.6";
//         document.getElementById("fastWindButton").onmouseover = function(){this.style.opacity = "1.0";}
//         document.getElementById("fastWindButton").onmouseleave = function(){this.style.opacity = "0.6";}
//         fastWinding = false;
//     }
// }

function Scoring(num,ans) {
    score[num] = ans;
    var cname = "correctCheck"+num;
    var wname = "wrongCheck"+num;

    if(ans == 1) {
        document.getElementById(cname).style.opacity = "1.0"
        document.getElementById(wname).style.opacity = "0.6"
        document.getElementById(cname).onmouseover = undefined;
        document.getElementById(cname).onmouseleave = undefined;
        document.getElementById(wname).onmouseover = function(){this.style.opacity = "1.0";}
        document.getElementById(wname).onmouseleave = function(){this.style.opacity = "0.6";}
    }
    else {
        document.getElementById(cname).style.opacity = "0.6"
        document.getElementById(wname).style.opacity = "1.0"
        document.getElementById(wname).onmouseover = undefined;
        document.getElementById(wname).onmouseleave = undefined;
        document.getElementById(cname).onmouseover = function(){this.style.opacity = "1.0";}
        document.getElementById(cname).onmouseleave = function(){this.style.opacity = "0.6";}
    }
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
    navigator.sendBeacon("/function/Function3/UserActivity",result);

    let utp = "f3-" + getCategory() + "-" + getChapter() + "-" + qnumber;
    navigator.sendBeacon("/home/saveUTP",utp);

    if(score.length != 0) {
        let scoreSum = 0;
        for (var i = 0; i < score.length; i++) {
            scoreSum += score[i];
        }
        let uts = "f3-" + getCategory() + "-" + getChapter() + "-" + scoreSum;
        navigator.sendBeacon("/home/saveUTS",uts);
    }
});