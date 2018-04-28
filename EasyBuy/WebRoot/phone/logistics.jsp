<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var contextPath = "${ctx}";
</script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>楚游网</title>
    <meta name="keywords" content="楚游网" />  
	<meta name="description" content="" />  
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />  
	<meta name="format-detection" content="telephone=no" />  
	<meta name="apple-mobile-web-app-capable" content="yes" />  
	<meta name="apple-mobile-web-app-status-bar-style" content="black">  
	<meta name="author" content="duanliang, duanliang920.com" />  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" href="css/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/zzsc.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/jquery.mobile-1.4.5.min.js"></script>
	<script src="js/islider.js"></script>
	<script src="js/index.js"></script>	
	<script src="js/plugins/islider_desktop.js"></script>
</head>
<body>
<div class="viewport">
	<div data-role="page" id="pageone">

<jsp:include page="common/top.jsp" />

 <div id="iSlider-effect-wrapper">
    <div id="animation-effect" class="iSlider-effect"></div>
</div>

	

  	<jsp:include page="common/bottom.jsp" />
</div> 
</div>

  </body>
</html>
