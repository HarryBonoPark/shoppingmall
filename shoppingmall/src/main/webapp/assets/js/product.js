$(function() {

    $("#add_product").click(function(){
        $(".product_form").css("display", "block");
        $("#img_preview").html("");
        $("#save").css("display", "block");
        $("#modify").css("display", "none");
        $(".product_form > h1").html("상품 추가");
    });
    
    $("#close").click(function(){
        if(confirm("입력을 취소하시겠습니까?\n저장하지 않은 정보는 모두 사라집니다.")){
            $(".product_form").css("display","");
            $(".product_form input").val("");
            $(".product_form select option:first-child").prop("selected", true);
            $(".product_form textarea").val("");
        }
    })

    $(".product_form").draggable({
        handle:"h1"
    })

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
                location.reload();
            }
        }) 
    })

    $("#modify").click(function(){
        
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
            pi_seq:$(this).attr("mod-seq"),
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
            type:"patch",
            url:"/product/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
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

    getProductInfo();

    function getProductInfo(keyword, cate_seq) {

        $("#product_tbody").html("");

        let url = "/product/list";
        if(keyword == undefined || keyword == null) {
            keyword = "";
        }
        url += "?keyword="+keyword;
        if(cate_seq != undefined && cate_seq != null) {
            url += "&category="+cate_seq;
        }

        $.ajax({
            type:"get",
            url:url,
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
                $(".product_delete").click(function(){
                    if(confirm("삭제하시겠습니까?")) {
                        $.ajax({
                            type:"delete",
                            url:"/product/delete?seq="+$(this).attr("data-seq"),
                            success:function(r) {
                                alert(r.message);
                                location.reload();
                            }
                        })
                    }
                })
                $(".product_modify").click(function() {
                    $("#save").css("display", "none");
                    $("#modify").css("display", "block");
                    $(".product_form > h1").html("상품 수정");
                    $(".product_form").css("display", "block");

                    let seq = $(this).attr("data-seq");
                    $("#modify").attr("mod-seq", seq);
                    $.ajax({
                        type:"get",
                        url:"/product/get?seq="+seq,
                        success:function(r) {
                            console.log(r);
                            $("#product_name").val(r.data.pi_name);
                            $("#product_price").val(r.data.pi_price);
                            $("#product_category").val(r.data.pi_cate_seq);
                            $("#product_seller").val(r.data.pi_si_seq);
                            $("#product_stock").val(r.data.pi_stock);
                            $("#product_weight").val(r.data.pi_weight);
                            $("#product_discount").val(r.data.pi_discount_rate);
                            $("#product_point").val(r.data.pi_point_rate);
                            $("#product_delivery").val(r.data.pi_di_seq);
                            $("#product_caution").val(r.data.pi_caution);

                            $("#pi_img_uri").html("");
                            if(r.data.pi_img_uri != null) {
                                $("#img_preview").html(
                                    '<img src="/image/'+r.data.pi_img_uri+'"img-uri="'+r.data.pi_img_uri+'">'
                                )
                                $("#img_preview").attr("img-uri", r.data.pi_img_uri);
                            }
                        }
                    })
                })
            }
        })
    }
    $("#search").click(function(){
        let seq = $("#cate_search option:selected").val();
        let keyword = $("#search_keyword").val();
        if(seq == "전체") seq = null;
        getProductInfo(keyword, seq);
    })

    $("#cate_search").change(function(){
        let seq = $("#cate_search option:selected").val();
        let keyword = $("#search_keyword").val();
        if(seq == "전체") seq = null;
        getProductInfo(keyword, seq);
    })

})
