<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/editor/default/default.css" >
</head>
<body>
	<input type="file" name="file" id="file" />
	<input type="button" value="上传" onclick="ajaxFileUpload('file')"/>
	
	<textarea id="editor_id" name="content" style="width:700px;height:300px;">
	&lt;strong&gt;HTML内容&lt;/strong&gt;
	</textarea>
	<button id="btn">查看</button>
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/resource/bootstrap/ajaxfileupload.js"></script>
<script charset="utf-8" src="/resource/editor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="/resource/editor/lang/zh-CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
        $(function(){
        	$('#btn').click(function(){
        		/* var formData = new FormData($('#editor_id')[0]);
        		formData.set("content",) */
        		console.log(editor);
        	})
        });
</script>
	<script type="text/javascript">
	function ajaxFileUpload(obj) {
	    $.ajaxFileUpload({
	        url: '/file/upload', 
	        type: 'post',
	        secureuri: false, //一般设置为false
	        fileElementId: 'file',
	        dataType: 'text',
	        success: function(responseText, status){
	        	alert(responseText);
	        	alert(status)
	        	alert("成功");
	        },
	        error: function(data, status, e){
	        	alert("失败");
				//window.location.href = basePath;
	        }
	    });
	};
	</script>
</body>
</html>