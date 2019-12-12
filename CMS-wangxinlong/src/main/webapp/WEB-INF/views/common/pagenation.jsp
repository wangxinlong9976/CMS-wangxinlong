<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
		<div class="" style="margin:0 auto;">
			<nav aria-label="Page navigation example " id="pagenation">
			  	<ul class="pagination">
				    <c:if test="${!pageInfo.isFirstPage}">
				    	<li class="page-item">
				      		<a class="page-link"  aria-label="Previous" href="javascript:pageUtil('${pageInfo.prePage==0?1:pageInfo.prePage}')">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    </c:if>
				    <c:if test="${pageInfo.pages<=5}">
					    <c:forEach items="${pageInfo.navigatepageNums}" var="item">
						    <c:if test="${item==pageInfo.pageNum}">
						    	<li class="page-item active"><a class="page-link" href="javascript:pageUtil(${item})">${item}</a></li>
						   </c:if>
						    <c:if test="${item!=pageInfo.pageNum}">
						    	<li class="page-item"><a class="page-link" href="javascript:pageUtil(${item})">${item}</a></li>
						   </c:if>
					    </c:forEach>
				    </c:if>
				    
				    <c:if test="${pageInfo.pages>5}">
					    <c:forEach items="${pageInfo.navigatepageNums}" var="item">
						    	<c:if test="${item>=(pageInfo.pageNum-2) && item<=(pageInfo.pageNum+2)}">
								    <c:if test="${item==pageInfo.pageNum}">
								    	<li class="page-item active"><a class="page-link" href="javascript:pageUtil(${item})">${item}</a></li>
								   </c:if>
								    <c:if test="${item!=pageInfo.pageNum}">
								    	<li class="page-item"><a class="page-link" href="javascript:pageUtil(${item})">${item}</a></li>
								   </c:if>
								</c:if>
					    </c:forEach>
				    </c:if>
				    
				   <c:if test="${!pageInfo.isLastPage}">
					   	 <li class="page-item">
						      <a class="page-link" aria-label="Next" href="javascript:pageUtil('${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}')">
						        	<span aria-hidden="true">&raquo;</span>
						      </a>
					     </li>
				   </c:if>
		 		</ul>
			</nav>
		</div>
	</div>