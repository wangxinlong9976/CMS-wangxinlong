/**
 * 
 */
$(function(){
	alert("进入预加载函数   开始二级联动")
	$.get("/admin/articleManager/selectChannel",{},function(arr){
		for ( var i in arr) {
			$('#channel').append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
		}
	},"json");
	
	$('#channel').change(function(){
		$('#category').html("<option value=''>全部</option>");
		$.get("/admin/articleManager/selectCategory",{channelId:$(this).val()},function(arr){
			for ( var i in arr) {
				$('#category').append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>")
			}
		},"json");
	})
});
