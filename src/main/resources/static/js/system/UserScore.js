let table;

$(document).ready(function(){
    table = new Tabulator("#UserScore", {
        maxHeight: "100%",
        layout:"fitDataTable",
        tooltips:true,
        addRowPos:"top",
        history:true,
        pagination: true,
        paginationButtonCount : 5,
        paginationSize:19,
        initialSort:[
            {column:"file_path",dir: "asc"}
        ],
        columns:[
            {title:"사용자 이름", field:"user_id",width:200},
            {title:"훈련 이름", field:"training_name", hozAlign:"left", width:300},
            {title:"훈련 종류", field:"category_name", hozAlign:"center",width:200},
            {title:"훈련 단원", field:"training_chapter",width:150},
            {title:"사용자 점수", field:"user_score",width:150},
            {title:"사용자 진행도(%)",field:"act_percent",width:200}
        ],
    });
    selectUser();
})

function selectUser() {
    var sbObject = document.getElementById("userList");
    var sbValue = sbObject.options[sbObject.selectedIndex].value;

    $.ajax({
        type:"POST",
        url:"/system/getScore",
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