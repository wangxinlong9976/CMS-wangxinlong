<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-8">
	<ul class="list-unstyled">
		<c:forEach items="${listMyCollect}" var="article">
		  <a href="/user/article/${article.id}.html">
		  	<li class="media mb-2" >
			    <img style="width: 64px;height: 64px;" src="${article.picture}" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">${article.title}</h5>
			    </div>
		    </li>
		  </a>
		  

		 </c:forEach>
		 <!-- <li class="media my-4">
		   <img style="width: 64px;height: 64px;" src="https://p3.pstatp.com/list/240x240/pgc-image/be878f512a494344bf29766431bb0c84" class="mr-3" alt="...">
		   <div class="media-body">
		     <h5 class="mt-0 mb-1">陈思诚监制《误杀》周五内地票房轻松夺冠</h5>
		   </div>
		 </li> -->
	</ul>

</div>