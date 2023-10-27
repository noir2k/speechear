var audioInfo = [];
var audioData = [];
var noiseAudioIndex = [];
var currentIndex = 0;
var startTime;
var score = [];
var play = false;
var aNoise = false;
// var fastWinding = false;

$(document).ready(function(){
    setNoise(getNoise());
    if(getNoise() == '1') {
        document.getElementById("NoiseButton").style.display = 'none';
    }

    getNoise();
    let data = {
        chapter : getChapter()
    };
    $.ajax({
        type:"POST",
        url:"/function/Function1/getAudioInfo",
        data:data,
        success: function(result)
        {
            $("#audio").attr("src", result[0].audio);
            $("#answer").text(result[0].context);

            var noiseIndex = 0;
            for(var i = 0; i < result.length; i++) {
                audioData[i] = result[i].audio;
                audioInfo[i] = result[i].context;
                if (result[i].filename.includes('noise')) {
                    audioInfo[i] = result[i].filename;
                    noiseAudioIndex[noiseIndex] = i;
                    noiseIndex++;
                }
            }
            randomSetNoise();
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

function randomSetNoise() {
    if (!noiseAudioIndex.length) {
        return null;
    }
    const randomIndex = Math.floor(Math.random() * noiseAudioIndex.length);
    $("#noise").attr("src", audioData[noiseAudioIndex[randomIndex]]);
    // console.log(noiseAudioIndex[randomIndex]);
    // console.log(audioInfo[noiseAudioIndex[randomIndex]]);
}

function returnToChapter() {
    location.href="/function/Function1C?d="+getNoise();
}

function getChapter() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('C');
}

function getNoise() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

function setNoise(n) {
    if(n == 1) {
        document.getElementById("noise").volume = 0;
    }
    else if(n == 2) {
        document.getElementById("noise").volume = 0.33;
    }
    else if(n == 3) {
        document.getElementById("noise").volume = 0.66;
    }
    else if(n == 4) {
        document.getElementById("noise").volume = 1;
    }
}

function activeNoise() {
    if(aNoise) {
        document.getElementById("NoiseButton").style.opacity = "0.6";
        document.getElementById("NoiseButton").onmouseover = function(){this.style.opacity = "1.0";}
        document.getElementById("NoiseButton").onmouseleave = function(){this.style.opacity = "0.6";}
        setNoise(getNoise());
        aNoise = false;
    }
    else {
        document.getElementById("NoiseButton").style.opacity = "1.0";
        document.getElementById("NoiseButton").onmouseover = undefined;
        document.getElementById("NoiseButton").onmouseleave = undefined;
        document.getElementById("noise").volume = 0;
        aNoise = true;
    }
}

function playAudioFile() {
    var name = "audio";

    if(!play) {
        play = true;

        $("#startBar").css('backgroundColor', '#74cdb8');
        $("#audioImg").attr('src','/img/function/pause.png');
        document.getElementById(name).play();
        document.getElementById("noise").play();
        document.getElementById(name).addEventListener("ended",
            function()
            {
                document.getElementById("noise").pause();
                $("#startBar").css('backgroundColor', '#fff');
                $("#audioImg").attr('src','/img/function/play.png');
                play = false;
            }
        )
    }
    else {
        $("#startBar").css('backgroundColor', '#fff');
        $("#audioImg").attr('src','/img/function/play.png');
        document.getElementById(name).pause();
        document.getElementById("noise").pause();
        play = false;
    }
}

function pauseAudioFile() {
    var name = "audio";
    $("#startBar").css('backgroundColor', '#fff');
    $("#audioImg").attr('src','/img/function/play.png');
    document.getElementById(name).pause();
    document.getElementById("noise").pause();
    document.getElementById(name).currentTime=0;
    document.getElementById("noise").currentTime=0;
    play = false;
}

function changeFile(index) {
    if(score[currentIndex] == null) {
        alert("채점을 진행해주십시오.");
        return;
    }
    pauseAudioFile();
    aNoise = true;
    activeNoise();

    document.getElementById("correctCheck").style.opacity = "0.6"
    document.getElementById("wrongCheck").style.opacity = "0.6"
    document.getElementById("correctCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("correctCheck").onmouseleave = function(){this.style.opacity = "0.6";}
    document.getElementById("wrongCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("wrongCheck").onmouseleave = function(){this.style.opacity = "0.6";}

    // fastWinding = false;
    // document.getElementById("audio").playbackRate = 1.0;
    // document.getElementById("noise").playbackRate = 1.0;
    // document.getElementById("fastWindButton").style.opacity = "0.6";
    // document.getElementById("fastWindButton").onmouseover = function(){this.style.opacity = "1.0";}
    // document.getElementById("fastWindButton").onmouseleave = function(){this.style.opacity = "0.6";}

    if(index > 0) {
        if(currentIndex == audioInfo.length-2) {
            currentIndex += 1;
            $("#qnumber").text(currentIndex+1);
            alert("모두 끝났습니다.")
            location.href="/home/FunctionSelect"
            return;
        }

        currentIndex += 1;
    }
    else {
        if(currentIndex == 0) {
            alert("첫 문제입니다.")
            return;
        }

        currentIndex -= 1;
    }
    getNoise();
    $("#qnumber").text(currentIndex+1);
    $("#audio").attr("src",audioData[currentIndex]);
    $("#accordion-2").prop("checked",false);
    randomSetNoise();
    setTimeout(function() {$("#answer").text(audioInfo[currentIndex]);}, 1000);
}

// function fastWind() {
//     if(!fastWinding) {
//         document.getElementById("audio").playbackRate = 1.8;
//         document.getElementById("noise").playbackRate = 1.8;
//         document.getElementById("audio").preservesPitch = true;
//         document.getElementById("noise").preservesPitch = true;
//         document.getElementById("fastWindButton").style.opacity = "1.0";
//         document.getElementById("fastWindButton").onmouseover = undefined;
//         document.getElementById("fastWindButton").onmouseleave = undefined;
//         fastWinding = true;
//     }
//     else {
//         document.getElementById("audio").playbackRate = 1.0;
//         document.getElementById("noise").playbackRate = 1.0;
//         // document.getElementById("audio").preservesPitch = false;
//         // document.getElementById("noise").preservesPitch = false;
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
    navigator.sendBeacon("/function/Function1/UserActivity",result);

    let utp = "f1-B-" + getChapter() + "-" + $("#qnumber").text();
    navigator.sendBeacon("/home/saveUTP",utp);

    if(score.length != 0) {
        let scoreSum = 0;
        for(var i = 0; i < score.length; i++) {
            scoreSum += score[i];
        }
        let uts = "f1-B-" + getChapter() + "-" + scoreSum;
        navigator.sendBeacon("/home/saveUTS",uts);
    }
});