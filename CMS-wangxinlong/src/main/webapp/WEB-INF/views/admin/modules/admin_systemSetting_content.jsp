<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<form id="articleForm" name="articleForm">
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章标题</label>
		<div class="col-sm-6">
			<input type="text" name="title" class="form-control" placeholder="请输入标题">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章图片</label>
		<div class="col-sm-6">
			<div class="input-prepend">
				<img src="/resource/img/upload.jpg" alt="图片" id="imgSrc" width="60px" height="60px" style="float:left;z-index:1;">
				<br/>
				<input type="file" id="file" name="file" id="fileDiv" style="float:left;z-index:3;width:60px;height:60px;margin-left:-60px;margin-top:-25px;opacity:0;"/> 
				<%-- <jsp:include page="../common/uploadImg.jsp" >
					<jsp:param name="feildName" value="picture" />
					<jsp:param name="feildValue" value="${article.picture }"/>
				</jsp:include> --%>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属频道</label>
		<div class="col-sm-6">
			<select id="inputState" name="channelId" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属分类</label>
		<div class="col-sm-6">
			<select id="inputState" name="categoryId" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章内容</label>
		<div class="col-sm-10">
			<textarea id="editor_id" name="content" style="width:700px;height:300px;">
			&lt;strong&gt;HTML内容&lt;/strong&gt;
			</textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="button" class="btn btn-primary" onclick="save();">保存并提交审核</button>
		</div>
	</div>
</form>
<script type="text/javascript">
$(function(){
	KindEditor.ready(function(K) {
	    window.editor = K.create('#editor_id');
	});
})
</script>