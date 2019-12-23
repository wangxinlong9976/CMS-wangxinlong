<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row" id="commentList">

<c:if test="${list.size()>0}">
	
	<c:forEach items="${list}" var="item">
		<div class="col-12">
		  <div style="margin-top: 10px;margin-bottom: 10px;color: #777;">
				<span><img src="${item.user.headimg}" style="height:28px;border-radius: 100px;" alt="" class="mr-2">${item.user.nickname }</span> 
				<span class="ml-2"><fmt:formatDate value="${item.created}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		  </div>
		  <div style="margin-top: 10px;margin-bottom: 10px;" class="ml-3">
				${item.content }
				<hr/>
		  </div>
		 </div>
	</c:forEach>	
</c:if>