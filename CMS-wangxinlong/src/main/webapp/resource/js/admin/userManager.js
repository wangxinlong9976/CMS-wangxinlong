/**
 * 
 */

 /* 条件查询 */
	$('#queryBtn').click(function(){
		getHtml("",$('#queryConditions').serialize());
	});
	
	
	/*分页查询工具*/	
	function pageUtil(currPage){
		if(currPage=="" || currPage==null){
			currPage=1;
		}
		$('[name=currPage]').val(currPage);
		getHtml("/admin/userManager",$('#queryConditions').serialize());
	}
	
	
	/*启用和禁用 用户*/
	function locked(id,status){
		$.post("/admin/userManager/locked",{id:id,status:status},function(res){
			if(res){
				getHtml("/admin/userManager",$('#queryConditions').serialize());
			}else{
				alert("状态修改失败!")
			}
		},"json");
	}
	/*全选全部选 反选*/
	$('#checks').click(function(){
		$('.check_userManager').each(function(){
			this.checked=!this.checked;
		});
	});
	
	/*查看用户信息*/
	function check(id){
		getHtml("/admin/checkUserInfo?id="+id);
	}