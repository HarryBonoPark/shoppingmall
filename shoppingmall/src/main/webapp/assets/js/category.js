$(function() {

    $("#category").addClass("current");

    $("#add_button").click(function() {
        
        let name = $("#cate_name").val();

        if(name == '' || name == null || name == undefined) {
            alert("카테고리 명을 입력하세요");
            return;
        }
        
        $.ajax({
            type:"get",
            url:"/category/add?name="+name,
            success:function(data){
                alert(data.message);
                location.reload();
            },
            error:function(data) {
                console.log(data);
            }
        })
    })
    
    $.ajax({
        type:"get",
        url:"/category/list",
        success:function (r) {
            for(let i=0; i<r.data.length; i++) {
                let tag = 
                '<tr>'+
                    '<td>'+r.data[i].cate_seq+'</td>'+
                    '<td>'+r.data[i].cate_name+'</td>'+
                    '<td>'+
                        '<button data-seq="'+r.data[i].cate_seq+'" class="cate_del">삭제</button>'+
                    '</td>'+
                '</tr>';
                $("#cate_table_body").append(tag);
            }
            $(".cate_del").click(function(){
                if(confirm("삭제하시겠습니까?")){
                    $.ajax({
                        url:"/category/delete?seq="+$(this).attr("data-seq"),
                        type:"delete",
                        success:function(r){
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })
})
