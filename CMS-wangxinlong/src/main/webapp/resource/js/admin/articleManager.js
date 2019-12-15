/**
 * 
 */
$(function(){

/*	alert("进入预加载函数   开始二级联动")
	$.get("/admin/articleManager/selectChannel",{},function(arr){
		for ( var i in arr) {
			$('#channel').append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
		}

	},"json");*/
	
	$('#channel').change(function(){
		$('#category').html("<option value=''>全部</option>");
		$.get("/admin/articleManager/selectCategory",{channelId:$(this).val()},function(arr){
			for ( var i in arr) {
				$('#category').append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
			}
		},"json");
	})
	
//	$('#queryBtn_article').click(function(){
//		$.post("",$('#queryBtn_article').serialize(),function(arr){
//			var list = arr.list;
//			for ( var i in list) {
//				$('#category').append("<option value='"+list[i].id+"'>"+list[i].name+"</option>")
//			}
//			$('#keyWord').val(arr.con.keyWord);
//			$('#channel').val(arr.con.channel);
//			$('#category').val(arr.con.category);
//			$('#status').val(arr.con.status);
//		});
//	});
});
function checkArticle(id){
	
}
function setHost(id){
	
}
function articleStatus(id){
	
}
