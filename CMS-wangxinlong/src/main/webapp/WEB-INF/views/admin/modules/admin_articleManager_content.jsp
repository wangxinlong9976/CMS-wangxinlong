<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr/>
<input type="hidden" id="cha" value="${con.channel}"/>
<input type="hidden" id="cat" value="${con.category}"/>
<input type="hidden" id="sta" value="${con.status}"/>
<form action="/admin/articleManager" method="post" id="formData">
	<div class="row">
		<div class="col-1">
			<label style="float:right;line-height: 40px;">
				标题:
			</label>
		</div>
		<div class="col-2">
			<input type="text" class="form-control" style="margin-left:-20px" placeholder="请输入关键字.." name="keyWord" value="${con.keyWord}"/>
		</div>
		<div class="col-1">
			<label style="float:left;line-height: 40px;margin-left:-33px">
				频道:	
			</label>
		</div>
		<div class="col-2">
			<select class="form-control text-center" style="margin-left: -85px;" id="channel" name="channel">
				<option value="">全部</option>
				<c:forEach items="${channels}" var="channel">
					<option value='${channel.id}'>${channel.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-1">
			<label style="float:left;line-height: 40px;margin-left: -110px;">
				分类:	
			</label>
		</div>
		<div class="col-2">
			<select class="form-control" style="margin-left: -160px;" id="category" name="category" >
				<option value="">全部</option>
				<c:if test="${categorys!=null}">
					<c:forEach items="${categorys}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div class="col-1">
			<label style="float:left;line-height: 40px;margin-left: -168px;">
				状态:	
			</label>
		</div>
		<div class="col-2">
			<div class="row">
				<select class="form-control" style="margin-left: -200px;" name="status">
					<option value="">全部</option>
					<option value="1">已审核</option>
					<option value="0">未审核</option>
					<option value="2">审核未通过</option>
				</select>
				<button type="button" class="btn btn-primary" style="margin-left:30px;width:130px" id="queryBtn_article">查询</button>
			</div>
		</div>
	</div>
</form>
	<hr/>
	<div class="row">
		<div class="col-1">
			<input type="button" value='批量删除' class="btn btn-primary from-control"/>
		</div>
	</div>
	<hr/>
	<table class="table  checkbox text-center table-bordered">
		<thead>
			<tr>
				<th><input type="checkbox"/></th>
				<th>#</th>
				<th>标题</th>
				<th>频道</th>
				<th>分类</th>
				<th>发表时间</th>
				<th>发表人</th>
				<th>是否热点</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<!-- <tr>
			<td><input type="checkbox"/></td>
			<td>1</td>
			<td>香港包换</td>
			<td>社会</td>
			<td>香港</td>
			<td>2019-10-20 20:20:20</td>
			<td>王鑫龙</td>
			<td>是</td>
			<td>已审核</td>
			<td>
				<input type="button" value="查看" class="btn btn-success"/>
				<input type="button" value="热点" class="btn btn-warning"/>
				<input type="button" value="审核" class="btn btn-primary"/>	
			</td>
		</tr> -->
			<c:forEach items="${list}" var="article" varStatus="statu">
				<tr>
					<td><input type="checkbox"/></td>
					<td>${statu.count}</td>
					<td>${article.title}</td>
					<td>${article.channel.name}</td>
					<td>${article.category.name}</td>
					<td>${article.created}</td>
					<td>${article.user.nickname}</td>
					<td>${article.hot>=1?"是":"否"}</td>
					<td>${article.status==0?"未审核":article.status==1?"已审核":"审核未通过"}</td>
					<td>
						<input type="button" value="查看" class="btn btn-success" onclick="checkArticle(${article.id})"/>
						<input type="button" value="热点" class="btn btn-warning" onclick="setHost(${article.id})"/>
						<c:if test="${article.status==0 || article.status>1}">
							<input type="button" value="审核" class="btn btn-primary" onclick="articleStatus(${article.status},1)"/>
						</c:if>
						<c:if test="${article.status==1}">
							<input type="button" disable value="已审核" class="btn btn-primary" onclick="articleStatus(${article.status},1)"/>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row">
		<div class="" style="margin:0 auto;">
			<nav aria-label="Page navigation example " id="pagenation">
			  	<ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Previous" onclick="pageUtil(pageUtil(${pageInfo.prePage==0?1:pageInfo.prePage}))">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li class="page-item"><a class="page-link" href="#" onclick="pageUtil()">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				     <li class="page-item"><a class="page-link" href="#">4</a></li>
				    <li class="page-item"><a class="page-link" href="#">5</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next" onclick="">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
		 		</ul>
			</nav>
		</div>
	</div>
<script type="text/javascript" src="/resource/js/admin/articleManager.js"></script>
<script type="text/javascript">
$('#queryBtn_article').click(function(){
	getHtml("/admin/articleManager",$('#formData').serialize());
});
$(function(){
	$('#channel').val($('#cha').val());
	$('#category').val($('#cat').val());
	$('#status').val($('#sta').val());
});
</script>