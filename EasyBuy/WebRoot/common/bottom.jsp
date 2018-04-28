<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div data-role="footer" data-position="fixed" data-fullscreen="true">
    <p id="footer" align="center"><span>
    <a href="${pageContext.request.contextPath }/PHome?action=index">首页</a>
    </span><span><a href="logistics.jsp">物流</a></span>
    <span><a href="${pageContext.request.contextPath }/PCart?action=toSettlement">购物车</a></span>
    <span><a href="${pageContext.request.contextPath }/PHome?action=user">我的</a></span></p>
</div>