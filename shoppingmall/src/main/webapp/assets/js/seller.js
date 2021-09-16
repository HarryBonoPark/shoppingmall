$(function() {

    $("#regist").click(function() {
        
        let id = $("#seller_id").val();
        if(id == '' || id == null || id == undefined) {
            alert("아이디를 입력하세요");
            return;
        }
        if(id.length < 4) {
            alert("아이디는 4자 이상으로 입력해주세요");
            return;
        }
        
        let pwd = $("#seller_pwd").val();
        if(pwd == '' || pwd == null || pwd == undefined) {
            alert("비밀번호를 입력하세요");
            return;
        }
        if(pwd.length < 4) {
            alert("비밀번호는 6자 이상으로 입력해주세요");
            return;
        }

        let pwd_con = $("#seller_pwd_confirm").val();
        if(pwd != pwd_con) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }

        let name = $("#seller_name").val();
        if(name == '' || name == null || name == undefined) {
            alert("이름을 입력하세요");
            return;
        }

        let address = $("#seller_address").val();
        if(address == '' || address == null || address == undefined) {
            alert("주소를 입력하세요");
            return;
        }

        let email = $("#seller_email").val();
        if(email == '' || email == null || email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }

        let phone = $("#seller_phone").val();
        if(phone == '' || phone == null || phone == undefined) {
            alert("전화번호를 입력하세요");
            return;
        }

        let sellerInfo = {
            si_id:id,
            si_pwd:pwd,
            si_name:name,
            si_address:address,
            si_email:email,
            si_phone:phone
        }

        $.ajax({
            type:"post",
            url:"/seller/regist",
            data:JSON.stringify(sellerInfo),
            contentType:"application/json",
            success:function(result) {
                alert(result.message);
                location.reload();
            },
            error:function(error) {
                console.log(error);
            }
        })
    });
})
