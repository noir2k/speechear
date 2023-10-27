let table;

$(document).ready(function(){
    table = new Tabulator("#UserActivity", {
        maxHeight: "100%",
        layout:"fitDataTable",
        tooltips:true,
        addRowPos:"top",
        history:true,
        pagination: true,
        paginationButtonCount : 7,
        paginationSize:20,
        initialSort:[
            {column:"file_path",dir: "asc"}
        ],
        columns:[
            {title:"사용자 이름", field:"user_id",width:250},
            {title:"훈련", field:"activity", hozAlign:"left", width:250},
            {title:"훈련 시간(초)", field:"activity_time",width:350},
            {title:"훈련 날짜", field:"activity_date",width:350}
        ],
    });
    selectUser();
})
function selectUser() {
    var sbObject = document.getElementById("userList");
    var sbValue = sbObject.options[sbObject.selectedIndex].value;

    $.ajax({
        type:"POST",
        url:"/system/getUserActivity",
        data: {
            user_id : sbValue
        },
        success:function(result)
        {
            table.setData(result);
        }
    })
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