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
	<script src="js/login.js"></script>
</head>
<body>
<div class="viewport">
	<div data-role="page" id="pageone">
<%-- <jsp:include page="../common/ctx.jsp" /> --%>
<jsp:include page="../common/top.jsp" />
<%@ include file="../common/titlePanle.jsp" %>

		<form>
            <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="55">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">
                	
                	登录
                	</span>
                    <span class="fr">还没有商城账号，<a href="${pageContext.request.contextPath }/PRegister?action=toRegister" style="color:#ff4e00;">立即注册</a></span>
                </td>
              </tr>
              <tr height="60">
                <td>用户名</td>
                <td><input type="text" name="loginName" id="loginName" value="" class="l_user" /></td>
              </tr>
              <tr height="60">
                <td>密&nbsp; &nbsp; 码</td>
                <td><input type="password" name="password" id="password" value="" class="l_pwd" /></td>
              </tr>
              <tr height="60">
              	<td><span>
              	<a href="${pageContext.request.contextPath }/PLogin?action=toPhoneLogin"
              	 style="color:#ff4e00;">手机登录</a></span></td>
                <td><input type="button" value="登录" class="log_btn" onclick="login();" /></td>
              </tr>
            </table>
            </form>

  	<jsp:include page="../common/bottom.jsp" />
</div> 
</div>

  </body>
</html>
