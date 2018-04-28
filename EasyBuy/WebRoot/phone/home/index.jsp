<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var contextPath = "${ctx}";
</script>
<c:if test="${empty categoryVoList }" >
	<c:redirect url="/PHome?action=index" />
</c:if>
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
<body onload="menu[0].onclick();">
<div class="viewport">
	<div data-role="page" id="pageone">
<jsp:include page="../common/top.jsp" />
	  
 <div id="menu-select" style="position:absolute; display: none;">
    <span class="on">default</span>
    <span>rotate</span>
    <span>flip</span>
    <span>depth</span>
</div>
 <div id="iSlider-effect-wrapper">
    <div id="animation-effect" class="iSlider-effect"></div>
</div>
<%@ include file="../common/titlePanle.jsp" %>
  <div id="content">
	  <div class="fresh_mid">
          <ul>
              <c:forEach items="${list}" var="product">
                  <li>
                      <div class="img">
                          <a href="${ctx}/PProduct?action=queryProductDeatil&id=${product.id}">
                              <img src="${ctx}/files/${product.fileName}" width="185"  height="155"/>
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
  </div>
  	<jsp:include page="../common/bottom.jsp" flush="true" />
</div> 
</div>
<!-- 轮播图 -->
<script type="text/javascript">
var picList = [
        {
            width: 100,
            height: 100,
            content: "images/gun1.jpg",
        },
        {
            width: 100,
            height: 100,
            content: "images/gun2.jpg",
        },
        {
            width: 100,
            height: 100,
            content: "images/gun3.jpg",
        },
        {
            width: 100,
            height: 100,
            content:"images/gun4.jpg"
        },
        {
            width: 100,
            height: 100,
            content:"images/gun5.jpg"
        }
        ];
        
		var islider1 = new iSlider({
            data: picList,
            dom: document.getElementById("animation-effect"),
            duration: 2000,
            animateType: 'default',
            isAutoplay: true,
            isLooping: true,
            // isVertical: true, 是否垂直滚动
        });
        islider1.bindMouse();

        var menu = document.getElementById('menu-select').children;

        function clickMenuActive(target) {
            for (var i = 0; i < menu.length; i++) {
                menu[i].className = '';
            }
            target.className = 'on'; 
        }
        menu[0].onclick = function() {
            clickMenuActive(this);
            islider1._opts.animateType = this.innerHTML;
            islider1.reset();
        };
        menu[1].onclick = function() {
            clickMenuActive(this);
            islider1._opts.animateType = this.innerHTML;
            islider1.reset();
        };
        menu[2].onclick = function() {
            clickMenuActive(this);
            islider1._opts.animateType = this.innerHTML;
            islider1.reset();
        };
        menu[3].onclick = function() {
            clickMenuActive(this);
            islider1._opts.animateType = this.innerHTML;
            islider1.reset();
        };
</script>
  </body>
</html>
