$(function() {

    let idCheck = false;
    let emailCheck = false;

    $("#join").click(function() {

        if(idCheck == false) {
            alert("아이디 중복 여부를 확인해주세요.");
            return;
        }
        if(emailCheck == false) {
            alert("이메일 중복 여부를 확인해주세요.");
            return;
        }

        // 공백 체크 정규 표현식
        const pattern = /\s/g;

        let member_id = $("#member_id").val();
        if(member_id == "" || member_id == null || member_id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if(member_id.match(pattern)){
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }

        let member_pwd = $("#member_pwd").val();
        if(member_pwd == "" || member_pwd == null || member_pwd == undefined) {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if(member_pwd.match(pattern)){
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }

        let member_pwd_confirm = $("#member_pwd_confirm").val();
        if(member_pwd != member_pwd_confirm) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }

        let member_name = $("#member_name").val();
        if(member_name == "" || member_name == null || member_name == undefined) {
            alert("이름을 입력하세요.");
            return;
        }
        if(member_name.match(pattern)){
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }

        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        
        let member_email = $("#member_email").val();
        if(member_email == "" || member_email == null || member_email == undefined) {
            alert("이메일을 입력하세요.");
            return;
        }
        if(member_email.match(pattern)){
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(!member_email.match(patternEmail)){
            alert("올바른 이메일 형식을 입력하세요\n예시) market@kurly.com");
            return;
        }

        let member_birth_year = $("#member_birth_year").val();
        let member_birth_month = $("#member_birth_month").val();
        let member_birth_date = $("#member_birth_date").val();

        if(!inputValidation(member_birth_year, "생년월일")) {return;}
        if(!inputValidation(member_birth_month, "생년월일")) {return;}
        if(!inputValidation(member_birth_date, "생년월일")) {return;}

        let member_birth = member_birth_year+leadingZero(member_birth_month)+leadingZero(member_birth_date);
        
        let member_gen = $("#member_gen option:selected").val();

        let member_address = $("#member_address").val();
        if(!inputValidation(member_address, "주소")) {return;}

        let member_phone = $("#member_phone").val();
        if(!inputValidation(member_phone, "전화번호")) {return;}
        
        let member_card = $("#user_card").val();
        let member_account = $("#user_account").val();

        let data = {
            mi_id:member_id,
            mi_name:member_name,
            mi_email:member_email,
            mi_address:member_address,
            mi_birth:member_birth,
            mi_pwd:member_pwd,
            mi_gen:member_gen,
            mi_phone:member_phone,
            mi_pay_card:member_card,
            mi_pay_account:member_account
        }
        
        $.ajax({
            type:"post",
            url:"/member/join",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r) {
                alert(r.message);
                if(r.status) {
                    location.href="/";
                }
            },
            error:function(e){
                alert(e.message);
            }
        })
    })

    $("#check_id").click(function() {

        const pattern = /\s/g;

        let member_id = $("#member_id").val();
        if(member_id == "" || member_id == null || member_id == undefined){
            alert("아이디를 입력해주세요");
            return;
        }
        if(member_id.match(pattern)){
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }

        $.ajax({
            type:"get",
            url:"/member/id_check?id="+member_id,
            success:function(r) {
                alert(r.message);
                idCheck = r.status;
            }
        })
    })
    $("#member_id").change(function(){
        idCheck = false;
    });

    $("#check_email").click(function() {

        const pattern = /\s/g;
        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

        let member_email = $("#member_email").val();
        if(member_email == "" || member_email == null || member_email == undefined) {
            alert("이메일을 입력하세요.");
            return;
        }
        if(member_email.match(pattern)){
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(!member_email.match(patternEmail)){
            alert("올바른 이메일 형식을 입력하세요\n예시) market@kurly.com");
            return;
        }

        $.ajax({
            type:"get",
            url:"/member/email_check?email="+member_email,
            success:function(r) {
                alert(r.message);
                emailCheck = r.status;
            }
        })
    })
    $("member_email").change(function() {
        emailCheck = false;
    })

})
function inputValidation(input, type) {
    if(input == "" || input == null || input == undefined){
        alert(type+" 을/를 입력해주세요");
        return false;
    }
    return true;
}
function leadingZero(n) {
    let num = Number(n);
    return num<10?"0"+num:""+num;
}