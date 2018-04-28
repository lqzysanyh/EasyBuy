<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- <link rel="stylesheet" href="css/index.css" /> -->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/jquery.mobile-1.4.5.min.js"></script>
	<!-- <script src="js/islider.js"></script> -->
	<!-- <script src="js/index.js"></script> -->	
	<!-- <script src="js/plugins/islider_desktop.js"></script> -->
	<script src="js/register.js"></script>	
</head>
<body>
<div class="viewport">
	<div data-role="page" id="pageone">
	<%-- <jsp:include page="../common/ctx.jsp" /> --%>
<jsp:include page="../common/top.jsp" />
<%@ include file="../common/titlePanle.jsp" %>

	<form id="register">
                <table border="0" style="width:370px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册</span>
                            <span class="fr">已有商城账号，<a href="${pageContext.request.contextPath }/PLogin?action=toLogin" style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"><font color="#ff4e00">*</font>登录用户名 &nbsp;</td>
                        <td><input type="text" value="" name="loginName" class="l_user"/></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" value="" name="password" class="l_pwd"/></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" value="" name="confirmPassword" class="l_pwd"/></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;真实姓名 &nbsp;</td>
                        <td><input type="text" value="" name="userName" class="l_user"/></td>
                    </tr>
                    <tr>
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                        <td>
                            <input type="radio" name="sex" value="1" checked="checked">&nbsp;男&nbsp;&nbsp;<input type="radio" name="sex" value="0">&nbsp;女
                        </td>
                    </tr>

                    <tr>
                        <td align="right">&nbsp;身份证号 &nbsp;</td>
                        <td><input type="text" value="" name="identityCode" class="l_user"/></td>
                    </tr>
                    <tr>
                        <td align="right">&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" value="" name="email" class="l_email"/></td>
                    </tr>
                    <tr>
                        <td align="right">&nbsp;手机 &nbsp;</td>
                        <td><input type="text" value="" name="mobile" class="l_tel"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="button" value="立即注册" class="log_btn" onclick="register();"/></td>
                    </tr>
                </table>
            </form>

  	<jsp:include page="../common/bottom.jsp" />
</div> 
</div>

  </body>
</html>
