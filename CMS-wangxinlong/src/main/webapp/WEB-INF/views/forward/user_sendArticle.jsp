<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="articleForm" name="articleForm">
	<input type="hidden" name="user_id" value="${userSession.id}"/>
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
				<input type="file" id="file" name="imgFile" id="fileDiv" onchange="ajaxFileUpload(this)" style="float:left;z-index:3;width:60px;height:60px;margin-left:-60px;margin-top:-25px;opacity:0;"/> 
			</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属频道</label>
		<div class="col-sm-6">
			<select id="channel_id" name="channel_id" class="form-control">
		        <option value="" selected>请选择频道...</option>
		        <c:forEach items="${channels}" var="channel">
		        	 <option value="${channel.id}">${channel.name}</option>
		        </c:forEach>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属分类</label>
		<div class="col-sm-6">
			<select id="category_id" name="category_id" class="form-control">
		        <option value="" selected>请选择频道...</option>
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
/* 	var editor = null;
	$(document).ready( function(){
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				uploadJson : '/file/upload?dir=image',
				fileManagerJson : '/file/manager',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['articleForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['articleForm'].submit();
					});
				}
			});
			editor.readonly(false);
			prettyPrint();
		});
	});
 */
	var editor = null;
	$(document).ready( function(){
		KindEditor.ready(function(K) {
			editor = K.create('#editor_id', {
				uploadJson : '/aa/upload',
				fileManagerJson : '/aa/manager',
				allowFileManager : true,
				afterCreate : function() {
				}
			});
			editor.readonly(false);
			//prettyPrint();
		});
	});
</script>
<script type="text/javascript">
$(function(){
	/* KindEditor.ready(function(K) {
	    window.editor = K.create('textarea[name="content"]',{uploadJson : '/file/upload?dir=image',afterUpload:function(a){
	    		alert(a.url);
	    },allowFileManager : true});
	}); */
})
$(function(){
	$('#channel_id').change(function(){
		$.post("/user/userPersonCenter/queryCategory",{channelId:$(this).val()},function(res){
			$('#category_id').html();
			for ( var i in res) {
				$('#category_id').append("<option value='"+res[i].id+"'>"+res[i].name+"</option>");
			}
		},"json");
	});
});
function save(){
	var formData = new FormData($("#articleForm")[0]);
	formData.set("picture",$('#imgSrc').attr("src"));
	formData.set("content",editor.html());
	console.log(formData.get("content"));
	console.log(editor.html());
	/* $.post("/article/add",formData,function(res){
		console.log(res);
	}); */
	$.ajax({
		type:"post",
		data:formData,
		dataType:"json",
		processData:false,
		contentType:false,
		url:"/user/userPersonCenter/addArticle",
		success:function(res){
			if(res.result){
				alert("文章保存成功!");
				selectedMenu("/user/article/myArticle");
			}else{
				alert("添加失败");
			}
		}
	});
}
/* function save(){
	var formData = new FormData($("form")[0]);
	formData.append("picture",$('#imgSrc').attr("src"));
	formData.append("content",editor.html());
	alert(formData);*/
	/*$.ajax({
		url:"/user/userPersonCenter/addArticle",
		data:formData,
		type:"json",
		contentType:false,
		processData:false,
		success:function(obj){
			if(obj.result){
				alert("保存成功!");
				reload();
				 selectedMenu(); 
			}else{
				alert("保存失败!");
			}
		}
	});

 } */

</script>
<script type="text/javascript">
function ajaxFileUpload(obj) {
    $.ajaxFileUpload({
        url: '/aa/upload', 
        type: 'post',
        secureuri: false, //一般设置为false
        fileElementId: 'file',
        dataType: 'text',
        success: function(responseText, status){
        	alert(responseText);
        	var aa = JSON.parse(responseText.replace(/<.*?>/ig,""));
        	
        	$('#imgSrc').attr("src",aa.url);
        },
        error: function(data, status, e){
        	alert("失败");
			//window.location.href = basePath;
        }
    });
};
</script>