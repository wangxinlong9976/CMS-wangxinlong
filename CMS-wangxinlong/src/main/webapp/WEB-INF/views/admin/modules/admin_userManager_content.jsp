<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr/>
<form id="queryConditions">
	<input type="hidden" value="${con.currPage}" name="currPage"/>
	<div class="row">
		<div class="col-7">
			
		</div>
		<div class="col-5">
			<div class="row">
				<div class="col-5">
					<input type="text"  class="form-control" placeholder="请输入账号" name="keyWord" value="${con.keyWord}"/>
				</div>
				<div class="col-5">
					<input type="text"  class="form-control" placeholder="请输入昵称" name="nickName" value="${con.nickName}"/>
				</div>
				<!-- style="margin-right:10px" -->
				<div class="col-2" style="margin-left:-18px">
					<input type="button"  class="btn btn-primary" value="查询" id="queryBtn"/>
				</div>
			</div>
		</div>
	</div>
</form>
<hr/>
	<table class="table  checkbox text-center table-bordered">
		<thead>
			<tr>
				<th><input type="checkbox" id="checks"/></th>
				<th>#</th>
				<th>账号</th>
				<th>昵称</th>
				<th>是否禁用</th>
				<th>积分</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user" varStatus="status">
				<tr>
					<td><input type="checkbox" class="check_userManager"/></td>
					<td>${status.count+pageInfo.endRow-pageInfo.pageSize}</td>
					<td>${user.username}</td>
					<td>${user.nickname}</td>
					<td>${user.locked==1?'否':'是'}</td>
					<td>${user.score}</td>
					<td>
						<input type="button" value="查看" class="btn btn-primary" onclick="check(${user.id})"/>
						<c:if test="${user.locked==1}">
							<input type="button" value="禁用" onclick="locked(${user.id},0)" class="btn btn-danger"/>
						</c:if>
						<c:if test="${user.locked==0}">
							<input type="button" value="启用" onclick="locked(${user.id},1)" class="btn btn-success"/>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="../../common/pagenation.jsp"></jsp:include>

<script type="text/javascript">
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
	getHtml("/admin/userManager/checkUserInfo?id="+id);
}
</script>