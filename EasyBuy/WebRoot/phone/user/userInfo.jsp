<%@ page language="java" contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<jsp:include page="../common/ctx.jsp" />
<jsp:include page="../common/top.jsp" />
<%@ include file="../common/titlePanle.jsp" %>
                <table border="0" style="width:870px; line-height:22px;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="115"><img src="${pageContext.request.contextPath}/statics/images/user.jpg" width="90" height="90" /></td>
                        <td>
                            <div class="m_user">${loginUser.userName}</div><br />
                            <p>
                              	  性别:
                                <c:choose>
                                    <c:when test="${loginUser.sex==1}">男</c:when>
                                    <c:otherwise>女</c:otherwise>
                                </c:choose>
                                <br /><br />
                                邮箱:${loginUser.email}<br /><br />
                                电话:${loginUser.mobile}<br /><br />
                                <br /><br />
           <a href="Porder?action=index&userId=${loginUser.id}">我的订单</a><br /><br />
           <a href="Porder?action=index&userId=${loginUser.id}">我的收藏</a><br /><br />
                            </p>
                        </td>
                    </tr>
                </table>
    <%@ include file="../common/bottom.jsp" %>
</body>
</html>

















