<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div data-role="panel" id="overlayPanel" data-display="overlay" data-position="right" data-position-fixed="true"> 
	<form>
		<input type="text" name="keyWord" id="keyWord" width="80px" /><input type="button" id="search" value="搜索" /> 
	</form>
	<div id="title">
		<ul>
			<c:forEach items="${categoryVoList}" var="temp" >
				<li class="level1">${temp.category.name }
					<ul class="level2">
						<c:forEach items="${temp.categoryVoList}" var="vo">
							<li><a href="${pageContext.request.contextPath }/PProduct?action=queryProductList&category=
							${vo.category.id}&level=2">${vo.category.name}</a></li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
  </div>
  <script>
  		$("#search").click(function(){
  			var ctx = "${pageContext.request.contextPath}";
  			var keyWord = $("#keyWord").val();
  			location.href=ctx+"/PProduct?action=queryProductList&keyWord="+keyWord;
  		});
  </script>