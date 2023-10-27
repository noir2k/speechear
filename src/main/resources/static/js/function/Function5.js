currentFile = 101;
var startTime;
var score = [];
var puzzleInfo;
var key;
var user_act = 1;

$(document).ready(function(){
    currentFile = parseInt(getChapter());
    loadFile();
})

function returnToChapter() {
    location.href="/function/Function5C";
}

function loadFile() {
    $("#qnumber").text(currentFile);

    data = {
        index : currentFile,
    }
    $.ajax({
        type:"POST",
        url:"/function/Function5/loadFile",
        data: data,
        success: function(result)
        {
            drawBoard(result);
            setAudio(result);
            puzzleInfo = result;

            let now = new Date();   
            startTime = now;
            // currentFile += 1;
        },
        beforeSend:function()
        {    
            $('.wrap-loading').removeClass('display-none');
        },
        complete:function()
        {
            $('.wrap-loading').addClass('display-none');
        }
    });
}

function getNextQuiz() {
    currentFile += 1;
    $("#quiz").empty();
    loadFile();
}

function getChapter() {
    const searchParams = new URLSearchParams(location.search);
    return searchParams.get('c');
}

function drawBoard(result) {
    //보드를 그리기 위한 변수
    var np = getArray(result.nullpoint);
    var k = 0;
    var count = 0;
    var drawPuzzle = '<div class="qz_left" id = "board"><table class="qz_table">';

    //보드에 번호를 매길 변수
    var hrzt = result.horizontal.split('/');
    var vtc = result.vertical.split('/');
    var hrztArr = new Array(hrzt.length);
    for(let i = 0; i < hrzt.length; i++) {
        hrztArr[i] = getArray(hrzt[i]);
    }
    var vtcArr = new Array(vtc.length);
    for(let i = 0; i < vtc.length; i++) {
        vtcArr[i] = getArray(vtc[i]);
    }

    for(let i = 0; i < result.row; i++) {
        drawPuzzle += '<tr>'
        for(let j = 0; j < result.col; j++) {
            count++;
            drawPuzzle += '<td><div class="qz_wrap">';
            if( count == np[k]) {
                drawPuzzle += '<div class="box"></div>';
                k++;
            }
            else {
                drawPuzzle += '<input type = "text" id = "qz' + count + '" class="qz" maxlength = "1" size = 1>';
                drawPuzzle += drawNumber(count,hrztArr,vtcArr);
            }
            drawPuzzle += '</div></td>';
        }
        drawPuzzle += '</tr>'
    }
    drawPuzzle += '</table></div>';
    $("#quiz").append(drawPuzzle);
}

function drawNumber(count,hrztArr,vtcArr) {
    var final = '';
    for(let i = 0; i < vtcArr.length; i++) {
        if (vtcArr[i][0] == count) {
            final = '<div class="qz_nb green">' + vtcArr[i][1] + '</div>';
            break;
        }
    }
    for(let i = 0; i < hrztArr.length; i++) {
        if(final == "") {
            if (hrztArr[i][0] == count) {
                final = '<div class="qz_nb blue">' + hrztArr[i][1] + '</div>';
                break;
            }
        }
        else if (hrztArr[i][0] == count) {
            final += '<div class="qz_nb blue">' + hrztArr[i][1] + '</div>';
            break;
        }
    }

    return final;
}

function setAudio(result) {
    //문제 순번으로 정렬
    key = Object.keys(result.audio).sort();
    //정답, 힌트1, 힌트2, 힌트3을 힌트1, 힌트2, 힌트3, 정답으로 변경
    var temp = [];
    var tempValue;
    for(let i = 0; i < key.length; i++) {
        if (key.length == 15) {
            if(i % 3 == 0) {
                tempValue = key[i];
            }
            else {
                temp.push(key[i]);
                if(i % 3 == 2) {
                    temp.push(tempValue);
                }
            }
        }
        else if (key.length / 4 == 3) {
            if(i % 3 == 0) {
                tempValue = key[i];
            }
            else {
                temp.push(key[i]);
                if(i % 3 == 2) {
                    temp.push(tempValue);
                }
            }
        }
        else if(key.length / 4 == 4 || key.length / 4 == 5) {
            if(i % 4 == 0) {
                tempValue = key[i];
            }
            else {
                temp.push(key[i]);
                if(i % 4 == 3) {
                    temp.push(tempValue);
                }
            }
        }
    }
    key = temp;
    // if(result.index <= 48) {
    //     score = [0,0,0,0];
    // }
    // else {
    //     score = [0,0,0,0,0];
    // }
    

    //테이블 그리기
    var soundBox = '<div class = "qz_right">' + '<table>';
    soundBox += '<tr><th scope="col"></th>'
    ////공백 | Level1 | Level2 | Level3 | 정답

    // ▼ 64,65번 문장힌트 추가되면 삭제할것 ▼
    if (key.length == 15) {
        for(let j = 0; j < 2; j++) {
            soundBox += '<th scope="col">Level ' + (j+1) + '</th>';
        }
    }
    // ▲ 64,65번 문장힌트 추가되면 삭제할것 ▲

    // ▼ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▼
    else if(key.length/4 == 3) {
        for(let j = 0; j < 2; j++) {
            soundBox += '<th scope="col">Level ' + (j+1) + '</th>';
        }
    }
    // ▲ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▲

    else if(key.length/4 == 4 || key.length/4 == 5) {
        for(let j = 0; j < 3; j++) {
            soundBox += '<th scope="col">Level ' + (j+1) + '</th>';
        }
    }
    soundBox += '<th scope="col">정답</th><th scope="col">채점</th></tr>';

    for(let i = 0; i < key.length; i++) {
        //N번힌트

        // ▼ 64,65번 문장힌트 추가되면 삭제할것 ▼
        if (key.length == 15) {
            if(i % 3 == 0) {
                soundBox += '<tr>'
                         +      '<td'
                if(((i/3)+1) == 1 || ((i/3)+1) == 4) {
                    soundBox += ' class="blue">'
                }
                else {
                    soundBox += '>'
                }
                soundBox += ((i/3)+1)
                         +     '번</br>힌트'
                         +      '</td>'
            }
        }
        // ▲ 64,65번 문장힌트 추가되면 삭제할것 ▲

        // ▼ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▼
        else if(key.length/4 == 3) {
            if(i % 3 == 0) {
                soundBox += '<tr>'
                         +      '<td'
                if(((i/3)+1) == 1 || ((i/3)+1) == 4) {
                    soundBox += ' class="blue">'
                }
                else {
                    soundBox += '>'
                }
                soundBox += ((i/3)+1)
                         +     '번</br>힌트'
                         +      '</td>'
            }
        }
        // ▲ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▲

        else if(key.length/4 == 4 || key.length/4 == 5) {
            if(i % 4 == 0) {
                soundBox += '<tr>'
                         +      '<td'
                if(((i/4)+1) == 1 || ((i/4)+1) == key.length/4) {
                    soundBox += ' class="blue">'
                }
                else {
                    soundBox += '>'
                }
                soundBox += ((i/4)+1)
                         +     '번</br>힌트'
                         +      '</td>'
            }
        }

        // lv1힌트음원 | lv2힌트음원 | (lv3힌트음원) | 정답음원
        soundBox += '<td>'
                 +      '<a href="javascript:playAudioFile(' + i +')">'
                 +          '<img src="/img/function/play_1.png" alt="재생">'
                 +      '</a>'
                 +      '<audio controls id = "audio' + i + '" hidden = true>'
                 +          '<source src="' + result.audio[key[i]] + '" type="audio/mp3">'
                 +      '</audio>'
                 +  '</td>';

        //줄바꿈

        // ▼ 64,65번 문장힌트 추가되면 삭제할것 ▼
        if (key.length == 15) {
            if(i % 3 == 2) {
                soundBox += '<td><div><div class="content2_s2_text text_q1"><ul class="text_ox hidden_ox1"><li id = "correctCheck' + parseInt(i/3) +'"><a href="javascript:Scoring(' + parseInt(i/3) + ',1)">O</a></li><li id = "wrongCheck' + parseInt(i/3) +'"><a href="javascript:Scoring(' + parseInt(i/3) + ',0)">X</a></li></ul></div></div></td>';
            }
        }
        // ▲ 64,65번 문장힌트 추가되면 삭제할것 ▲

        // ▼ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▼
        else if(key.length/4 == 3) {
            if(i % 3 == 2) {
                soundBox += '<td><div><div class="content2_s2_text text_q1"><ul class="text_ox hidden_ox1"><li id = "correctCheck' + parseInt(i/3) +'"><a href="javascript:Scoring(' + parseInt(i/3) + ',1)">O</a></li><li id = "wrongCheck' + parseInt(i/3) +'"><a href="javascript:Scoring(' + parseInt(i/3) + ',0)">X</a></li></ul></div></div></td>';
            }
        }
        // ▲ 14,18,26,35,39,48번 문장힌트 추가되면 삭제할것 ▲

        else if(key.length/4 == 4 || key.length/4 == 5) {
            if(i % 4 == 3) {
                soundBox += '<td><div><div class="content2_s2_text text_q1"><ul class="text_ox hidden_ox1"><li id = "correctCheck' + parseInt(i/4) +'"><a href="javascript:Scoring(' + parseInt(i/4) + ',1)">O</a></li><li id = "wrongCheck' + parseInt(i/4) +'"><a href="javascript:Scoring(' + parseInt(i/4) + ',0)">X</a></li></ul></div></div></td>';
            }
        }
    }
    soundBox += '</table>' + '</div>';
    $("#quiz").append(soundBox);
}

function playAudioFile(n) {
    var name = "audio"
    for(let i = 0; i < key.length; i++) {
        name += i;
        document.getElementById(name).pause();
        document.getElementById(name).currentTime=0;
        name = "audio"
    }
    name = "audio"+n
    document.getElementById(name).play();
}

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

function getAnswer() {
    let sl = 0;
    if(getChapter() < 49) {
        sl = 4;
    }
    else {
        sl = 5;
    }

    if(score.length != sl) {
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

    const existpoint = puzzleInfo.existpoint.replace('[', '').replace(']', '').split(",");
    const context = puzzleInfo.context.replace('[','').replace(']', '').split(",");
    
    for(var count = 1; count <= puzzleInfo.col*puzzleInfo.row; count++) {
        for(var i = 0; i < existpoint.length; i++) {
            if(existpoint[i] == count) {
                const id = "qz"+count;
                document.getElementById(id).value = context[i];
            }
        }
    }
    user_act = 2;
    let utp = "f5-B-" + (parseInt(getChapter())-1) + "-" + user_act;
    navigator.sendBeacon("/home/saveUTP",utp);

    if(score.length != 0) {
        let scoreSum = 0;
        for(var i = 0; i < score.length; i++) {
            scoreSum += score[i];
        }
        let uts = "f5-B-" + (parseInt(getChapter())-1) + "-" + scoreSum;
        navigator.sendBeacon("/home/saveUTS",uts);
    }
}

function getArray(arr) {
    var str = arr.replace('[','');
    str = str.replace(']','');
    str = str.split(',');
    var final = new Array(str.length);
    for(let i = 0; i < str.length; i++) {
        final[i] = parseInt(str[i]);
    }

    return final;
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
    navigator.sendBeacon("/function/Function5/UserActivity",result);
});