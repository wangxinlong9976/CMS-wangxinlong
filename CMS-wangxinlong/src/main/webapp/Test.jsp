<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/editor/themes/default/default.css" />
<link rel="stylesheet" href="/resource/editor/plugins/code/prettify.css" />
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script charset="utf-8" src="/resource/editor/themes/kindeditor-all-min.js"></script>
<script charset="utf-8" src="/resource/editor/themes/lang/zh-CN.js"></script>
<script charset="utf-8" src="/resource/editor/plugins/code/prettify.js"></script>
</head>
<body>
<script>
	var editor = null;
	$(document).ready( function(){
		KindEditor.ready(function(K) {
			editor = K.create('#aa', {
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
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章内容</label>
		<div class="col-sm-10">
			<textarea name="content1" id="aa" cols="100" rows="8" style="width:760px;height:200px;visibility:hidden;">${article.content}</textarea>
		</div>
	</div>
</body>
</html>