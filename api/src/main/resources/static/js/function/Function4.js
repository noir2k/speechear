var index = [];
var key = [];
var audio = [];
var play = [];
var score = [];
var currentIndex = 0;
var startTime;
var showingAnswer = false;

$(document).ready(function(){
    data = {
        level : getLevel(),
        chapter : getChapter()
    };
    
    $.ajax({
        type:"POST",
        url:"/function/Function4/getFirstInfo",
        data:data,
        success: function(result)
        {
            for(let i = 0; i < result.length; i++) {
                index.push(result[i].index);
            }
            changeFile(index[currentIndex]);

            let now = new Date();   
            startTime = now;
        }
    })
})

function returnToChapter() {
    location.href="/function/Function4C?d="+getLevel();
}

function getChapter() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('c');
}

function getLevel() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('d');
}

function changeFile(parameter) {
    if(currentIndex >= index.length) {
        $("#qnumber").text(currentIndex+1);
        alert("모두 끝났습니다.");
        location.href="/home/FunctionSelect";
        return;
    }

    data = {
        index : parameter
    }
    $("#qnumber").text(currentIndex+1);
    $.ajax({
        type:"POST",
        url:"/function/Function4/getAudioInfo",
        data:data,
        success: function(result)
        {
            $("#audio0").attr("src",result[0].file);
            for(let i = 1; i < result.length; i++) {
                key.push(result[i].context);
                audio.push(result[i].file);
            }
            printContext();
            addAnswer();
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
}

function printContext() {
    var context = '<ul class="play_gnb1">'
    for (var i = 0; i < key.length; i++) {
        context
        += '<li>'
        +       '<audio controls id = "audio' + (i+1) + '" hidden = true><source src="" type="audio/mp3"></audio>'
        +       '<span id = "sentence' + (i+1) + '">' + (i+1) + '번째 문장듣기' + '</span>'
        +       '<a href="javascript:playAudioFile(' + (i+1) +')" id = "a' + (i+1) + '">'
        +       '<img src="../img/function/play2.png" id = "img' + (i+1) + '" alt="재생하기"></a>'
        +  '</li>';
    }
    context += '</ul>';

    $("#content").append(context);

    var name = "audio"
    for(let i = 0; i < audio.length; i++) {
        play.push(false);
        document.getElementById(name+(i+1)).src=audio[i];
    }
    play.push(false);
}

function addAnswer() {
    var answer = '<div class="play_wrap flex" id = "answer">' + '<ul class="Plus_gnb"><br><br><br>';
    for(let i = 0; i < key.length; i++) {
        answer += '<li><a href = "#" class = "text_content">'
               +  (i+1)+". " + key[i]+"\n"
               +  '<br></a></li>';
    }
    answer +=  '</ul></div>'
    $("#textArea").append(answer);
}

function playAudioFile(n) {
    var name = "audio" + n;
    var name2 = "a" + n;
    var name3 = "img" + n;

    if(!play[n])
    {
        play[n] = true;
        document.getElementById(name).play();
        if(n != 0) {
            
            document.getElementById(name2).style.backgroundColor = "#74cdb8";
            document.getElementById(name3).src = "/img/function/pause.png";
            document.getElementById(name).addEventListener("ended",
                function()
                {
                    document.getElementById(name2).style.backgroundColor = "#63A4DB";
                    document.getElementById(name3).src = "/img/function/play2.png";
                    play[n] = false;
                }
            );
        }
    }
    else {
        pauseAudioFile(n);
    }
}

function pauseAudioFile(n) {
    var name = "audio" + n;
    var name2 = "a" + n;
    var name3 = "img" + n;

    play[n] = false;
    document.getElementById(name).pause();
    document.getElementById(name2).style.backgroundColor = "#63A4DB";
    document.getElementById(name3).src = "/img/function/play2.png";
}

function changeButton() {
    $('.bot_right1').css('display','none')
    $('.bot_right2').css('display', 'block');
    shuffleAndPrint();
}

function shuffleAndPrint() {
    var array = [];
    for(let i = 0; i < key.length; i++) {
        array[i] = key[i];
    }
    $("#content").empty();
    array.sort(() => Math.random() - 0.5);
    var content ='';
    for(let i = 0; i < array.length; i++) {
        content
        += '<li>'
        +       '<input type="text" name="" id="context' + (i+1) +'" value="" class="plus_page_input" min = "1" max = "' + array.length +'"'
        +       'maxlength="1">'
        // +       '<a href = "javascript:inputFocus(' + i +')"'
        +       '<a href = "#"'
        +       'class="text_context">'
        +       array[i]
        +       '</a>'
        +  '</li>'
        ;
    }
    $("#content").append(content);
}

function showAnswer() {
    if(showingAnswer) {
        document.getElementById("textArea").style.display = "none";
        showingAnswer = false;
    }
    else {
        document.getElementById("textArea").style.display = "block";
        showingAnswer = true;
    }
}

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

function nextQuiz() {
    if(score[currentIndex] == null) {
        alert("채점을 진행해주십시오.");
        return;
    }
    document.getElementById("correctCheck").style.opacity = "0.6"
    document.getElementById("wrongCheck").style.opacity = "0.6"
    document.getElementById("correctCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("correctCheck").onmouseleave = function(){this.style.opacity = "0.6";}
    document.getElementById("wrongCheck").onmouseover = function(){this.style.opacity = "1.0";}
    document.getElementById("wrongCheck").onmouseleave = function(){this.style.opacity = "0.6";}

    $("#content").empty();
    $("#textArea").empty();
    $("#textArea").css('display','none');
    showingAnswer = false;
    key.length = 0;
    audio.length = 0;
    play = [];

    currentIndex++;
    changeFile(index[currentIndex]);
    $('.bot_right1').css('display','block')
    $('.bot_right2').css('display', 'none');
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
    navigator.sendBeacon("/function/Function4/UserActivity",result);

    let utp = "f4-" + getLevel() + "-" + getChapter() + "-" + $("#qnumber").text();
    navigator.sendBeacon("/home/saveUTP",utp);

    if(score.length != 0) {
        let scoreSum = 0;
        for(var i = 0; i < score.length; i++) {
            scoreSum += score[i]
        }
        let uts = "f4-" + getLevel() + "-" + getChapter() + "-" + scoreSum;
        navigator.sendBeacon("/home/saveUTS",uts);
    }
});