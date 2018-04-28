<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>楚游网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="楚游网" />  
	<meta name="description" content="" />  
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />  
	<meta name="format-detection" content="telephone=no" />  
	<meta name="apple-mobile-web-app-capable" content="yes" />  
	<meta name="apple-mobile-web-app-status-bar-style" content="black">  
	<meta name="author" content="duanliang, duanliang920.com" />  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../common/ctx.jsp" />
    <link type="text/css" href="css/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/zzsc.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/jquery.mobile-1.4.5.min.js"></script>
	<script src="js/islider.js"></script>
	<script src="js/index.js"></script>	
	<script src="js/plugins/islider_desktop.js"></script>
    <style>
    	#content ul li{float: left; width: 184px;border: 1px white solid;}
   		.price{color:#ff4e00;}
   		a{
   			text-decoration: none;
   		}
    </style>
</head>
<body>
	<h4>"${keyWord }"的搜索结果</h4>

<jsp:include page="../common/top.jsp" />

<%@ include file="../common/titlePanle.jsp" %>    
<div id="content" >
          <ul>
              <c:forEach items="${productList}" var="product">
                  <li>
                      <div class="img">
                          <a href="${pageContext.request.contextPath}/PProduct?action=queryProductDeatil&id=${product.id}">
                              <img src="${pageContext.request.contextPath}/files/${product.fileName}" width="173"  height="155"/>
                          </a>
                      </div>
                      <div class="name"><span class="price">
                          <font>￥<span>${product.price}</span></font> &nbsp;
                          </span>
                          <a href="#">${product.name}</a>
                      </div>
                  </li>
              </c:forEach>
          </ul>
  </div>
 	 <jsp:include page="../common/pagerBar.jsp" />
    	<jsp:include page="../common/bottom.jsp" />

</body>
</html>
