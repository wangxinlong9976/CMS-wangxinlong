<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/resource/css/login.css">
 --><style type="text/css">
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
				<h3 class="text-left modal-title" id="loginTitle">注册页面</h3>
			</div>
			<div class="modal-body">
				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入用户名" autocomplete="off" name="username" id="username"/>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请输入密码" autocomplete="off" name="password" id="password"/>
					</div>
					<div class="form-group">
						<div class="row">
							<input type="text" class="form-control col-6" placeholder="请输入验证码" autocomplete="off" name="password" style="margin-left:15px;" id="ran"/>
							<div class="col-1"></div>
							<span id="rand" class="col-3 text-center bg-success" style="line-height:40px;font-size:20px"></span>
<!-- 							style="display:block;width:60px;height:40px;line-height:50px"
 	 style="width:260px;float:left;display:inline-block"
 -->						</div>
							
					</div>
					<div class="row form-ground">
						<p>
							<span id="error" class="text-danger" style="float:left;margin-left:20px;width:310px"></span>
							<span style="float:right;margin-right:0px">已账号?去<a href="/user/toLogin" class="text-primary">登陆</a>!</span>
						</p>
					</div>
			</div>
			<div class="modal-body loginBtnGroup">
				<div class="form-group">
					<input type="button" class="btn btn-primary form-control" id="loginBtn" value="登陆" style="margin-top:-30px"/>
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
		if($('#ran').val()!=$('#rand').html()){
			alert("验证码错误!");
			return ;
		}
		$.post("/user/register",$('#loginForm').serialize(),function(obj){
			alert(JSON.stringify(obj));
			if(!obj.result){
				alert("注册成功!");
				location="/user/toLogin";
			}else{
				alert("注册失败")
			}
		},"json");
	});
	$(function(){
		getRandom();
		$('#rand').click(function(){
			getRandom();
		});
	})
	
	function getRandom(){
		var ran = "";
		for(var i=0;i<4;i++){
			ran += Math.floor(Math.random()*10);
		}
		$('#rand').html(ran);
		return ran;
	}
	function regUserName(userName){
		$.get("/user/register/regUserName",{username:userName},function(reg){
			if(reg){
				$('#error').html("用户名已存在!");
			}
		},"json");
	}
</script>
</body>
</html>