$(function() {

    $("#product").addClass("current");

    $("#save").click(function(){
        
        let pi_name = $("#product_name").val();
        if(pi_name == "" || pi_name == null || pi_name == undefined) {
            alert("상품명을 입력하세요");
            return;
        }
        let pi_price = $("#product_price").val();
        if(pi_price == "" || pi_price == null || pi_price == undefined) {
            alert("가격을 입력하세요");
            return;
        }
        let pi_cate_seq = $("#product_category option:selected").val();
        if(pi_cate_seq == "" || pi_cate_seq == "" || pi_cate_seq == undefined) {
            alert("카테고리를 선택하세요");
            return;
        }
        let pi_stock = $("#product_stock").val();
        if(pi_stock == "" || pi_stock == null || pi_stock == undefined) {
            alert("재고를 입력하세요");
            return;
        }
        let pi_si_seq = $("#product_seller option:selected").val();
        if(pi_si_seq == "" || pi_si_seq == "" || pi_si_seq == undefined) {
            alert("판매자를 선택하세요");
            return;
        }
        let pi_discount_rate = $("#product_discount").val();
        if(pi_discount_rate == "" || pi_discount_rate == null || pi_discount_rate == undefined) {
            alert("할인률을 입력하세요");
            return;
        }
        let pi_point_rate = $("#product_point").val();
        if(pi_point_rate == "" || pi_point_rate == null || pi_point_rate == undefined) {
            alert("적립률을 입력하세요");
            return;
        }
        let pi_caution = $("#product_caution").val();
        let pi_weight = $("#product_weight").val();
        if(pi_weight == "" || pi_weight == null || pi_weight == undefined) {
            alert("무게를 입력하세요");
            return;
        }
        let pi_di_seq = $("#product_delivery option:selected").val();
        if(pi_di_seq == "" || pi_di_seq == "" || pi_di_seq == undefined) {
            alert("배송업체를 선택하세요");
            return;
        }

        let data = {
            pi_name:pi_name,
            pi_price:pi_price,
            pi_cate_seq:pi_cate_seq,
            pi_stock:pi_stock,
            pi_si_seq:pi_si_seq,
            pi_discount_rate:pi_discount_rate,
            pi_point_rate:pi_point_rate,
            pi_caution:pi_caution,
            pi_weight:pi_weight,
            pi_di_seq:pi_di_seq,
            pi_img_uri:$("#img_preview").attr("img-uri")
        }
        $.ajax({
            type:"post",
            url:"/product/regist",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
            }
        }) 
    })

    $("#img_save").click(function() {
        let form = $("#image_form");
        let formData = new FormData(form[0]);
        $.ajax({
            type:"post",
            url:"/upload",
            data:formData,
            contentType:false,
            processData:false,
            success:function(r) {
                if(r.status) {
                    $("#img_save").prop("disabled", true);
                    $("#img_delete").prop("disabled", false);
                    $("#img_delete > input").prop("disabled", true);
                    $("#img_preview").append('<img src="/image/'+r.image_uri+'">');
                    $("#img_preview").attr("img-uri", r.image_uri);
                }
                alert(r.message);
            }
        })    
    })

    $("#img_delete").click(function(){
        let uri = $("#img_preview").attr("img_uri");
        $("#img_preview").html("");

        $("#image_form > input").val("");
        $(this).prop("disabled", true);
        $("#image_form > input").prop("disabled", false);
        $("#img_save").prop("disabled", false);

        alert("등록된 사진이 삭제되었습니다.");
    })

    $.ajax({
        type:"get",
        url:"/product/list",
        success:function(r) {
            for(let i=0; i<r.data.length; i++) {
                let tag =
                    '<tr>'+
                        '<td>'+r.data[i].pi_seq+'</td>'+
                        '<td>'+r.data[i].pi_name+'</td>'+
                        '<td class="preview"><img src="/image/'+r.data[i].pi_img_uri+'"></td>'+
                        '<td>'+r.data[i].category_name+'</td>'+
                        '<td>'+r.data[i].pi_stock+'</td>'+
                        '<td>'+r.data[i].seller_name+'</td>'+
                        '<td>'+r.data[i].pi_create_dt+'</td>'+
                        '<td>'+r.data[i].pi_discount_rate+'</td>'+
                        '<td>'+r.data[i].pi_point_rate+'</td>'+
                        '<td>'+r.data[i].pi_caution+'</td>'+
                        '<td>'+r.data[i].pi_weight+'</td>'+
                        '<td>'+r.data[i].delivery_name+'</td>'+
                        '<td>'+r.data[i].pi_price+'</td>'+
                        '<td><button class="product_modify" data-seq="'+r.data[i].pi_seq+'">수정</button></td>'+
                        '<td><button class="product_delete" data-seq="'+r.data[i].pi_seq+'">삭제</button></td>'+
                    '</tr>'
                $("#product_tbody").append(tag);
            }
        }
    })
})
