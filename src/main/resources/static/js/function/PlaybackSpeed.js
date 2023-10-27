var userPlayBackSpeed = 1.0;

$(document).ready(function(){
    getUS();
})

function getUS() {
    $.ajax({
        type:"POST",
        url:"/home/getUS",
        success: function(result)
        {
            if(result.play_speed == "느리게") {
                userPlayBackSpeed = 0.8;
            }
            else if (result.play_speed == "조금 느리게") {
                userPlayBackSpeed = 0.9;
            }
            else if (result.play_speed == "보통") {
                userPlayBackSpeed = 1.0;
            }
            else if (result.play_speed == "조금 빠르게") {
                userPlayBackSpeed = 1.1;
            }
            else if (result.play_speed == "빠르게"){
                userPlayBackSpeed = 1.2;
            }
            setPlaybackSpeed();
        }
    });
}

function setPlaybackSpeed() {
    var audios = document.querySelectorAll('audio');
    for(var i = 0; i < audios.length; i++) {
        audios[i].defaultPlaybackRate = userPlayBackSpeed;
    }
}