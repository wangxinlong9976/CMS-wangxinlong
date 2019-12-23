<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="nav flex-column nav-pills">
  <a class="nav-link active" href="javascript:reload();" url="/user/sendArticle/">发布文章</a>
  <a class="nav-link" href="javascript:reload();" url="/user/article/myArticle?user_id=${userSession.id}">我的文章</a>
  <a class="nav-link" href="javascript:reload();" url="/user/myComment">我的评论</a>
  <a class="nav-link" href="javascript:reload();" url="/user/userPersonCenter/myCollect">我的收藏</a>
  <a class="nav-link" href="javascript:reload();" url="/user/selfSettings">个人设置</a>
</div>