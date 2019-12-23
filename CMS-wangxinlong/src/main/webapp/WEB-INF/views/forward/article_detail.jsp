<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${article.title}</title>
<link type="text/css" rel="stylesheet" href="/resource/bootstrap/css/bootstrap.min.css"/>
<script type="text/javascript" src="/resource/bootstrap/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var article_id = '${article.id}';
	var userSession = '${userSession.id}';
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
			<div class="col-7">
				<%-- <h1>${article.title }</h1> --%>
				<div style="margin-top: 10px;margin-bottom: 10px;font-weight: bold;">
					<span>${user.nickname }</span> 
					<span>${article.created}</span>
					<span>
						<c:if test="${isCollect>0}">
							<a href="javascript:backCollect(${article.id});">
								取消收藏
							</a>
						</c:if>
						<c:if test="${isCollect<=0}">
							<a href="javascript:collect(${article.id});">
								收藏文章
							</a>
						</c:if>
					</span>
				</div>
				<div style="font-size: 24">
					${article.content }
				</div>
				
				<div id="comment">
					<div class="row" style="margin-top: 10px;">
						  <div class="col-10">
							  <form class="was-validated">
							    <textarea class="form-control" rows="2" id="content" placeholder="请输入评论内容" required></textarea>
							  </form>
						  </div>
						  <div style="margin-top: 10px;">
						    <button type="button" class="btn btn-primary" onclick="addComment();" id="con">评论</button>
						  </div>
					</div>
					<hr/>
					<div id="commentPointCut">
					
					</div>
				</div>
				
				
			</div>
			
			<div class="col-3">
				
					<div class="right">
						<div class="text-center h4" >相关文章</div>
						<hr/>
						<c:choose>
							<c:when test="${articleList.size()>0}">
								<ul class="list-unstyled">
									<c:forEach items="${articleList }" var="item">
									<li class="media mb-2">
										<a href="/article/${item.id }.html"><img style="width: 64px; height: 64px;"	src="${item.picture }" class="mr-3" alt=""></a>
										<div class="media-body">
											<h5 class="mt-0 mb-1"><a href="/article/${item.id }.html">${item.title }</a></h5>
										</div>
									</li>
									</c:forEach>
								</ul>
							</c:when>
							<c:otherwise>
								<div class="h6 text-center mt-5">
									<span>暂无相关文章</span>
								</div>
							</c:otherwise>
						</c:choose>
					
					</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$.get("/user/content",{article_id:article_id},function(res){
			$('#commentPointCut').html(res);
		},"html");
		
		function addComment(){
			if(userSession==null || userSession==""){
				alert("请先登陆!");
				location="/user/toLogin";
				return;
			}
			$.post("/user/content/appendContent",{article_id:article_id,content:$('#content').val()},function(res){
				$('#commentPointCut').html(res);
			},"html");
			$('#con').attr('disabled',"disabled");
			setTimeout("$('#con').removeAttr('disabled')",2000);
		}
		function collect(id){
			location="/user/userPersonCenter/myCollect/collect?article_id="+id;
		}
		function backCollect(id){
			location="/user/userPersonCenter/myCollect/unCollect?article_id="+id;
		}
	</script>
<%-- 	"<div class='col-12'>"+
					"<div style='margin-top: 10px;margin-bottom: 10px;color: #777;'>"+
					"<span><img src='${userSession.headimg}' style='height:28px;border-radius: 100px;' alt='' class='mr-2'>${userSession.nickname}</span>"+ 
					"<span class='ml-2'><fmt:formatDate value='"+time+"' pattern='yyyy-MM-dd HH:mm:ss'/></span>
	  </div>
	  <div style="margin-top: 10px;margin-bottom: 10px;" class="ml-3">
			${item.content }
			<hr/>
	  </div>
	 </div> --%>
</body>
</html>