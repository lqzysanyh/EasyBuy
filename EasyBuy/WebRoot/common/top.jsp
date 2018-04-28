<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div data-role="header" data-position="fixed" data-fullscreen="true">
	    <p id="header"  align="center"><a href="${pageContext.request.contextPath }/PHome?action=index"><img alt="login" height="30px" src="images/plogin.png"></a>  
	    <!-- </p><p align="center"> -->
	    
	    <a href="#overlayPanel" class="ui-btn ui-icon-grid ui-btn-icon-right">
	    分类</a>
	    <c:if test="${empty loginUser }">
	    	<a href="${pageContext.request.contextPath }/PLogin?action=toLogin">点击登录或注册</a>
	    </c:if>
	    <c:if test="${not empty loginUser }">
	    	欢迎你
	    	<a href="${pageContext.request.contextPath }/PHome?action=user">${loginUser.userName }</a>
	   		<a href="${pageContext.request.contextPath }/PLogin?action=loginOut" >注销</a>
	    </c:if>

	    
	    </p>
	    </div>
