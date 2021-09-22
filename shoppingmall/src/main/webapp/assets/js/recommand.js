$(function() {

    $("#recommand").addClass("current");

    loadRecommandList();

    function loadRecommandList() {
        $("#recommand_tbody").html("");
        $.ajax({
            type:"get",
            url:"/product/recommand",
            success:function(r) {
                for(let i=0; i<r.list.length; i++) {
                    let tag = 
                        '<tr>'+
                            '<td>'+r.list[i].pi_seq+'</td>'+
                            '<td>'+r.list[i].pi_name+'</td>'+
                            '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                            '<td>'+r.list[i].category_name+'</td>'+
                            '<td>'+r.list[i].seller_name+'</td>'+
                            '<td><button class="delete" data-seq="'+r.list[i].pi_seq+'">삭제</button></td>'+
                        '</tr>';
                    $("#recommand_tbody").append(tag);
                }
                $(".delete").click(function() {
                    if(confirm("삭제하시겠습니까?")) {
                        let seq = $(this).attr("data-seq");
                        $.ajax({
                            type:"delete",
                            url:"/product/delete_recommand?prod_seq="+seq,
                            success:function(r) {
                                alert(r.message);
                                location.reload();
                            }
                        })
                    }
                })
            }
        })
    }

    $(".close").click(function(){
        $(".add_recommand").hide();
    })

    $("#add_recommand_button").click(function() {
        $(".add_recommand").show();
        loadNotRecommandList();
    })
    
    function loadNotRecommandList () {
        $(".not_recommand_list").html("");
        $.ajax({
            type:"get",
            url:"/product/not_recommand",
            success:function(r) {
                for(let i=0; i<r.list.length; i++) {
                    let tag =
                        '<tr>'+
                            '<td>'+r.list[i].pi_seq+'</td>'+
                            '<td>'+r.list[i].pi_name+'</td>'+
                            '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                            '<td>'+r.list[i].category_name+'</td>'+
                            '<td>'+r.list[i].seller_name+'</td>'+
                            '<td><button class="add_recommand_inpop" data-seq="'+r.list[i].pi_seq+'">추가</button></td>'+
                        '</tr>';
                    $(".not_recommand_list").append(tag);
                }
                $(".add_recommand_inpop").click(function() {
                    let seq = $(this).attr("data-seq");
                    $.ajax({
                        type:"put",
                        url:"/product/put_recommand?prod_seq="+seq,
                        success:function(r) {
                            alert(r.message);
                            loadNotRecommandList();
                            loadRecommandList();
                        }
                    })
                })
            }
        })
    }
})
