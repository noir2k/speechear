let table;

$(document).ready(function(){
    table = new Tabulator("#UserLog", {
        maxHeight: "100%",
        layout:"fitDataTable",
        tooltips:true,
        addRowPos:"top",
        history:true,
        pagination: true,
        paginationButtonCount : 7,
        paginationSize:20,
        initialSort:[
            {column:"access_time",dir: "desc"}
        ],
        columns:[
            {title:"사용자 ID", field:"access_id",width:200},
            {title:"접속 시간", field:"access_time", hozAlign:"right", align:"left",width:200},
            {title:"접속 IP", field:"access_ip",width:150},
            {title:"접속 경로", field:"access_uri",width:250},
            {title:"사용자 권한", field:"access_role",width:350},
        ],
    });
    // $.ajax({
    //     type:"POST",
    //     url:"/system/getUserLog",
    //     success:function(result)
    //     {
    //         table.setData(result);
    //     }
    // })
    selectUser();
})

function selectUser() {
    var sbObject = document.getElementById("uList");
    var sbValue = sbObject.options[sbObject.selectedIndex].value;

    $.ajax({
        type:"POST",
        url:"/system/getUserLog",
        data: {
            access_id : sbValue
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