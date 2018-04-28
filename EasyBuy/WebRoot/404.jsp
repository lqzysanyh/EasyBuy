<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>楚游网</title>
    
	

  </head>
  
  <body>
    <h1>404</h1>
    <% SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); %>
  </body>
</html>
