<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cms后台登录</title>
<link href="/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="/resource/css/bootstrap-datetimepicker.min.css" rel="stylesheet">-->
<link href="/resource/css/cms.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/editor/themes/default/default.css" />
<link rel="stylesheet" href="/resource/editor/plugins/code/prettify.css" />
<script charset="utf-8" src="/resource/editor/themes/kindeditor-all-min.js"></script>
<script charset="utf-8" src="/resource/editor/themes/lang/zh-CN.js"></script>
<script charset="utf-8" src="/resource/editor/plugins/code/prettify.js"></script>

<script>
	KindEditor.ready(function(K) {});
</script>
</head>
<body>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row offset-1" style="margin-top: 15px;">
			  <div class="col-2">
			  	<!-- 左侧导航 -->
			    <jsp:include page="../common/left.jsp"></jsp:include>
			  </div>
			  <div class="col-8">
			    <div class="tab-content" id="v-pills-tabContent">
				  
			  	</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/cms.js"></script>
<script type="text/javascript" src="/resource/bootstrap/ajaxfileupload.js"></script>
<!-- <script type="text/javascript" src="/resource/js/bootstrap-datetimepicker.min.js"></script>
 --></body>
</html>