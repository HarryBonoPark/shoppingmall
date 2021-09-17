$(function() {

    $("#delivery").addClass("current");

    let checkName = true;

    $("#delivery_add").click(function(){

        if(checkName == true) {
            alert("배송사 중복 여부를 확인해주세요");
            return;
        }
        
        let name = $("#delivery_name").val();
        if(name == "" || name == null || name == undefined) {
            alert("배송사 명을 입력하세요.");
            return;
        }

        let phone = $("#delivery_phone").val();
        if(phone == "" || phone == null || phone == undefined) {
            alert("배송사 전화번호를 입력하세요.");
            return;
        }

        let price = $("#delivery_price").val();
        if(price == "" || price == null || price == undefined) {
            alert("배송비를 입력하세요.");
            return;
        }

        let deliveryInfo = {
            di_name:name,
            di_phone:phone,
            di_price:price
        }

        $.ajax({
            type:"post",
            url:"/delivery/regist",
            data:JSON.stringify(deliveryInfo),
            contentType:"application/json",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })

    $("#check_name").click(function(){
        
        let name = $("#delivery_name").val();
        if(name == "" || name == null || name == undefined) {
            alert("배송사 명을 입력하세요.");
            return;
        }

        $.ajax({
            type:"get",
            url:"/delivery/checkName?name="+name,
            success:function(r) {
                alert(r.message);
                checkName = r.status;
            }
        })
    })

    $("#delivery_name").change(function(){
        checkName = true;
    })

    $.ajax({
        type:"get",
        url:"/delivery/list",
        success:function(r) {
            for(let i=0; i<r.data.length; i++) {
                let tag =
                    '<tr>'+
                        '<td>'+r.data[i].di_seq+'</td>'+
                        '<td>'+r.data[i].di_name+'</td>'+
                        '<td>'+r.data[i].di_phone+'</td>'+
                        '<td>'+r.data[i].di_price+'</td>'+
                        '<td>'+
                            '<button data-seq="'+r.data[i].di_seq+'" class="delivery_delete">삭제</button>'+
                        '</td>'+
                    '</tr>'
                $("#delivery_list_body").append(tag);
            }
            $(".delivery_delete").click(function(){
                if(confirm("삭제하시겠습니까?")) {
                    $.ajax({
                        type:"delete",
                        url:"/delivery/delete?seq="+$(this).attr("data-seq"),
                        success:function(r) {
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })
})
