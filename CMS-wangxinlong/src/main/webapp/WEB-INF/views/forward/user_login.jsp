<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.net.URLDecoder" %>
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
<%
	Map<String,String> hm = new HashMap<>();
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			request.setAttribute(cookie.getName(),URLDecoder.decode(cookie.getValue()));
		}
	}
	
%>
<body style="background: url(/resource/img/38fca844b7154089d675fa45597f4313.jpg) no-repeat fixed top;background-size:100%;">
<form class="form form-group" id="loginForm"  method="post">
	<div class="modal-dialog" style="margin-top: 13%;">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="text-left modal-title" id="loginTitle">CMS用户登陆页面</h3>
			</div>
			<div class="modal-body">
				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入用户名" autocomplete="off" name="username" id="" value="${username}"/>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请输入密码" autocomplete="off" name="password" id="" value="${password}"/>
					</div>
					<div class="row form-ground checkbox">
						<p>
							<span id="test" class="text-danger" style="float:left;margin-left:20px;width:310px"></span>
							<span style="float:right;margin-right:0px"><input type="checkbox" id="memory" value="1" name="memory"/>   记住用户名密码</span>
						</p>
					</div>
					<div class="row form-ground">
						<p>
							<span id="error" class="text-danger" style="float:left;margin-left:20px;width:310px"></span>
							<span style="float:right;margin-right:0px">没有账号?去<a href="/user/toRegister" class="text-primary">注册</a>一个</span>
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
		$.post("/user/login",$('#loginForm').serialize(),function(obj){
			alert(JSON.stringify(obj));
			if(!obj.result){
				$('#error').html(obj.message);
			}else{
				location="/user/toIndex/0/0.html";
			}
		},"json");
	});
	$(function(){
		console.log(document.cookie);
	});
</script>
</body>
</html>