<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
  var contextPath = "${ctx}";
</script>
<%-- <c:if test="${empty loginUser }">
	<script>alert("对不起，请先登录!");</script>
	<c:redirect url="" />
</c:if> --%>
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
	<style type="text/css">
		table{
			background-color: whi te;
		}
		td{
			width: 40px;
			height:40px;
		}
		tr{
			height: 60px;
		}
	</style>
</head>
<body>
<div class="viewport">
	<div data-role="page" id="pageone">
<jsp:include page="common/ctx.jsp" />
<jsp:include page="common/top.jsp" />

 <div id="iSlider-effect-wrapper">
    <div id="animation-effect" class="iSlider-effect"></div>
</div>
	<%-- <div class="i_car">
        <div class="car_t">
            购物车 [
            <span>
                <c:if test="${applicationScope[loginUser.userName]!=null && applicationScope[loginUser.userName].items.size()>0}">
                    ${applicationScope[loginUser.userName].items.size()}
                </c:if>
                <c:if test="${applicationScope[loginUser.userName]==null || applicationScope[loginUser.userName].items.size()<=0}">空
                </c:if>
            </span>]
        </div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.loginUser==null}">
                <div class="un_login">还未登录！<a href="${ctx}/PLogin?action=toLogin" style="color:#ff4e00;">马上登录</a></div>
            </c:if>
            <c:if test="${sessionScope.loginUser!=null}">
                <div class="un_login">我的购物车</div>
            </c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <c:forEach items="${applicationScope[loginUser.userName].items}" var="temp">
                    <li>
                        <div class="img"><a href="${ctx}/PProduct?action=queryProductDeatil&id=${temp.product.id}"><img src="${ctx}/files/${temp.product.fileName}" width="58" height="58" /></a></div>
                        <div class="name"><a href="${ctx}/PProduct?action=queryProductDeatil&id=${temp.product.id}">${temp.product.name}</a></div>
                        <div class="price"><font color="#ff4e00">￥${temp.product.price}</font> X${temp.quantity}</div>
                    </li>
                </c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp;<font color="#ff4e00">￥</font><span>${applicationScope[loginUser.userName].sum}</span></div>
            <c:if test="${sessionScope.loginUser==null}">
                <div class="price_a"><a href="${ctx}/PLogin?action=toLogin">去登录</a></div>
            </c:if>
            <c:if test="${sessionScope.loginUser!=null}">
                <div class="price_a"><a href="${ctx}/PCart?action=toSettlement">去结算</a></div>
            </c:if>
            <!--End 购物车已登录 End-->
        </div>
    </div> --%>
    		<c:if test="${empty applicationScope[loginUser.userName].items}">
    			<h3>未添加任何商品，<a href="${ctx}/PHome?action=index">去逛逛</a></h3>
    		</c:if>
    		<table align="center">
                <c:forEach items="${applicationScope[loginUser.userName].items}" var="temp">
                    <tr>
                        <td  valign="middle"><a href="${ctx}/PProduct?action=queryProductDeatil&id=${temp.product.id}">
                        <img src="${ctx}/files/${temp.product.fileName}" width="60" height="60" />
                        </a>
                        </td>
                        <td valign="middle"><a href="${ctx}/PProduct?action=queryProductDeatil&id=${temp.product.id}">${temp.product.name}</a></td>
                        <td valign="middle"><font color="#ff4e00">￥${temp.product.price}</font> X${temp.quantity}</td>
                    	<td valign="middle">&nbsp;</td>
                    </tr>
                </c:forEach>
			</table>
	<c:if test="${sessionScope.loginUser!=null}">
                <div class="price_a"><a href="${ctx}/PCart?action=toSettlement">去结算</a></div>
	</c:if>

  	<jsp:include page="common/bottom.jsp" />
</div> 
</div>

  </body>
</html>
