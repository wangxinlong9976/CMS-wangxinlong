<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/login.css">
<style type="text/css">
	body{
		height:100%;
	}
</style>
</head>
<body style="background: url(/resource/img/38fca844b7154089d675fa45597f4313.jpg) no-repeat fixed top;background-size:100%;">
<form class="form form-group" id="loginForm"  method="post">
	<div class="modal-dialog" style="margin-top: 13%;">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="text-left modal-title" id="loginTitle">CMS管理页面</h3>
			</div>
			<div class="modal-body">
				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入用户名" autocomplete="off" name="username" id=""/>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请输入密码" autocomplete="off" name="password" id=""/>
					</div>
					<span id="error" class="text-danger"></span>
			</div>
			<div class="modal-body loginBtnGroup">
				<div class="form-group">
					<input type="button" class="btn btn-primary form-control" id="loginBtn" value="登陆"/>
				</div>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/login.js"></script>
<script type="text/javascript">
	$('#loginBtn').click(function(){
		$.post("/admin/login",$('#loginForm').serialize(),function(obj){
			alert(JSON.stringify(obj));
			if(!obj.result){
				$('#error').html(obj.message);
			}else{
				location="/admin/home";
			}
		},"json");
	});
</script>
<script type="text/javascript">
window.onbeforeunload=function (){
	alert("===onbeforeunload===");
	if(event.clientX>document.body.clientWidth && event.clientY < 0 || event.altKey){
	alert("你关闭了浏览器");
	}else{
	alert("你正在刷新页面");
	}
	}
</script>
</body>
</html>