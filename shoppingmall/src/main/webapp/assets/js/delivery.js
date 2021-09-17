$(function() {

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
})