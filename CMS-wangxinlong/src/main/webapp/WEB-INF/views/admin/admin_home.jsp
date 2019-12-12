<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/admin/personCenter.css">
<link rel="stylesheet" href="/resource/css/admin/home.css">

<style type="text/css">
	*{
		
	}
	a{
		color: #fff;
	}
	a:hover{
		color: #E0A800;
	}
	.nav_top{
		height: 60px;
		line-height: 40px;
	}
	#nav_top .nva-link{
		color:#fff;
	}
	.leftNav a{
		background-color: #000; /*#343A40*/
		height:80.20px;
		border-radius: 0px;
		text-align: center;
		line-height: 60px;
	}
	.leftNav_content{
		margin-left:-30px;
		background-color: #e0e0e0;
	}
	.leftNav_content div{
		/*style="*/
		background-color: #ECECF6;
		/*margin-left:-30px;*/
		height:641px;
	}
	#contentPointCut{
		height: 641px;
		background-color: #ECECF6;
	}
	#v-pills-tab a{
		color:#E0A800;
	}
</style>

</head>
<body>
	<nav class="nav justify-content-end bg-dark nav_top" id="nav_top">
		<div class="logo">
			Logo
		</div>
		  <a class="nav-link active" href="#">首页</a>
		  <a class="nav-link" href="#">官方网站</a>
		  <a class="nav-link" href="#">管理员</a>
		  <a class="nav-link" href="#">退出</a>
	</nav>
	
	<div class="row">
	  	<div class="col-2">
	  	 	 <div class="nav flex-column nav-tabs leftNav" id="v-pills-tab" >
		      	<a class="nav-link active" id="" url="/admin/welcome" style="border-radius: 0px;">主页</a>
		     	<a class="nav-link" id="" url="/admin/userManager" style="border-radius: 0px;">用户管理</a>
		     	<a class="nav-link" id="" url="/admin/articleManager" style="border-radius: 0px;">文章管理</a>
		      	<a class="nav-link" id="" url="/admin/logManager" style="border-radius: 0px;">日志管理</a>
	    		<a class="nav-link" id="" url="/admin/" style="border-radius: 0px;">暂空</a>
		      	<a class="nav-link" id="" url="/admin/" style="border-radius: 0px;">暂空</a>
		      	<a class="nav-link" id="" url="/admin/personCenter" style="border-radius: 0px;">个人中心</a>
		      	<a class="nav-link" id="" url="/admin/systemManager" style="border-radius: 0px;">系统设置</a>
	  	 	 </div>
	 	 </div>
  		<div class="col-8 overflow-auto" id="contentPointCut">

  		</div>
	</div>
  		
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap/chart.min.js"></script>
<script type="text/javascript" src="/resource/js/admin/checkUserInfo.js"></script>
<script type="text/javascript" src="/resource/js/admin/home.js"></script>

<script type="text/javascript">

</script>
</body>
</html>