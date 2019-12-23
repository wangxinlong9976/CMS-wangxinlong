<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resource/css/index.css" rel="stylesheet">
<title>前台首页</title>
<style type="text/css">
	.fre a{
		color: #fff;
	}
</style>
<script type="text/javascript">
	var channelId = '${channel_id}';
	var categoryId = '${category_id}';
</script>
</head>
<body>
	<nav class="nav justify-content-start" style="background-color: #222;">
		<a class="nav-link navbar-brand" href="#">
			<img src="https://v4.bootcss.com/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" alt="">
		</a>
		<c:if test="${userSession!=null }">
			<a class="nav-link" href="/user/center">发文</a> 
			<a class="nav-link" href="/user/userPersonCenter">个人中心</a> 
			<a class="nav-link" href="javascript:;">${userSession.username}</a>
			<a class="nav-link" href="/user/logout">退出</a>
		</c:if>
		<c:if test="${userSession==null }">
			<a class="nav-link" href="/user/toLogin">登录</a>
		</c:if>
	</nav>
	<div class="container-fluid">
		<div class="row offset-1" style="margin-top: 15px;">
			<div class="col-1">
				<!-- 左侧导航 -->
				<ul class="nav flex-column">
					<li class="nav-item">
				   		<a class="nav-link <c:if test="${channel_id==0}">select</c:if>" href="/user/toIndex/0/0.html">热点</a>
				  	</li>
				<c:forEach items="${listChannel}" var="channel">
					<li class="nav-item">
				   		<a class="nav-link <c:if test="${channel.id==channel_id}">select</c:if>" href="/user/toIndex/${channel.id}/0.html">${channel.name}</a>
				  	</li>
				</c:forEach>
				  
				 
				</ul>
			</div>
			<div class="col-6">
				
				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/pic/38fca844b7154089d675fa45597f4313.jpg" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/pic/26f0dc11f9ecfe0733ebf3f25e4d4baa.jpg" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/pic/1.jpg" class="d-block w-100" alt="...">
				    </div>
				  </div>
				  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
								
				<c:if test="${listCategorys.size()>0}">
					<ul class="nav nav-tabs">
						<li class="nav-item">
					   		<a class="nav-link <c:if test="${category_id==0||category_id==null}">active</c:if>" href="/user/toIndex/${channel_id}/0/${currPage==null||currPage==0?1:currPage}.html">全部</a>
					  	</li>
						<c:forEach items="${listCategorys}" var="cate">
							<li class="nav-item">
						   		<a class="nav-link <c:if test="${category_id==cate.id}">active</c:if>" href="/user/toIndex/${channel_id}/${cate.id}/${currPage==null||currPage==0?1:currPage}.html">${cate.name}</a>
						  	</li>
						</c:forEach>
					</ul>
				</c:if>
				
				<div style="margin-top: 18px;">
					<div class="media">
					  <img src="https://p3.pstatp.com/list/190x124/pgc-image/d14a9ef6392b4afa87d6f6f7b85dd9a8" class="mr-3" alt="...">
					  <div class="media-body">
					    <h4 class="mt-1">
					    	<a href="/article/1.html">这次，杨超越的纯洁人设崩塌了？</a>
					    </h4>
					    <p style="color: #999;">蝈蝈  20分钟前</p>
					  </div>
					</div>
					<c:forEach items="${articleList }" var="article">
						<div class="media">
						  <img src="${article.picture}" class="mr-3" alt="...">
						  <div class="media-body">
						    <h4 class="mt-1">
						    	<a href="/user/article/${article.id}.html">${article.title}</a>
						    </h4>
						    <p style="color: #999;">${article.user.nickname} ${article.created}</p>
						  </div>
						</div>
					</c:forEach>
					<jsp:include page="common/pagenation.jsp"></jsp:include>
				</div>
				<!-- <p style="text-align: center;">
					<a href="#">加载更多</a>
				</p> -->
			</div>
			<div class="col-3">
				<div class="right" >
					<div>最新文章</div>
					<ul class="list-unstyled">
					<c:forEach items="${articleList }" var="article">
						  <a href="/user/article/${article.id}.html"><li class="media">
						    <img style="width: 64px;height: 64px;" src="${article.picture}" class="mr-3 mb-2" alt="...">
						    <div class="media-body">
						      <h5 class="mt-0 mb-1">${article.title}</h5>
						    </div>
						   </li>
						  </a>
					  </c:forEach>
					  <li class="media my-4">
					    <img style="width: 64px;height: 64px;" src="https://p3.pstatp.com/list/240x240/pgc-image/be878f512a494344bf29766431bb0c84" class="mr-3" alt="...">
					    <div class="media-body">
					      <h5 class="mt-0 mb-1">陈思诚监制《误杀》周五内地票房轻松夺冠</h5>
					    </div>
					  </li>
					</ul>
				</div>
				<div class="right" >
				 <c:if test="${channel_id!=0}">
					<div style="">热点文章</div>
					<ul class="list-unstyled">
					  <a href="">
						  <li class="media mb-2">
						    <img style="width: 64px;height: 64px;" src="https://p3.pstatp.com/list/240x240/pgc-image/be878f512a494344bf29766431bb0c84" class="mr-3" alt="...">
						    <div class="media-body">
						      <h5 class="mt-0 mb-1">网友举报猫咖私养小熊猫，初步查明</h5>
						    </div>
						  </li>
					  </a>
					</ul>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="fre" style="background-color: #222;">
		<div class="row"> 
			<div class="col-12 text-center">
				<a class="nav-link" href="javascript:;">友情链接</a>
			</div>
		</div>
		<div class="row text-center mb-2" style="color:#fff;">
				<div class="col-2">
					
				</div>
				<div class="col-2">
					<a>腾讯游戏</a>
				</div>
				<div class="col-2">
					<a>腾讯游戏</a>
				</div>
				<div class="col-2">
					<a>腾讯游戏</a>
				</div>
				<div class="col-2">
					<a>腾讯游戏</a>
				</div>
		</div>
		<div class="row text-center mb-2" style="color:#fff;">
				<div class="col-2">
					
				</div>
				<div class="col-2">
					<a>阿里巴巴</a>
				</div>
				<div class="col-2">
					<a>阿里巴巴</a>
				</div>
				<div class="col-2">
					<a>阿里巴巴</a>
				</div>
				<div class="col-2">
					<a>阿里巴巴</a>
				</div>
		 </div>
		 <div class="row text-center mb-2" style="color:#fff;">
				<div class="col-2">
					
				</div>
				<div class="col-2">
					<a>网易游戏</a>
				</div>
				<div class="col-2">
					<a>网易游戏</a>
				</div>
				<div class="col-2">
					<a>网易游戏</a>
				</div>
				<div class="col-2">
					<a>网易游戏</a>
				</div>
		 </div>
		 <div class="row">
		 
		 </div>
		 
	</div>
	
	<script type="text/javascript" src="/resource/bootstrap/jquery-3.4.1.slim.min.js"></script>
	<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
	<script type="text/javascript">
		function pageUtil(page){
			location="/user/toIndex/"+channelId+"/"+categoryId+"/"+page+".html";
		}
	</script>
</body>
</html>