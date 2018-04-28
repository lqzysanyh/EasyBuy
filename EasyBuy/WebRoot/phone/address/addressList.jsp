<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script src="${ctx}/statics/js/backend/backend.js"></script>
</head>
<body>
<jsp:include page="../common/ctx.jsp" />
<jsp:include page="../common/top.jsp" />
<%@ include file="../common/titlePanle.jsp" %>
<c:choose>
	<c:when test="${empty addressList}">
        暂无地址
    </c:when>
    <c:otherwise>
       	<table border="0" class="order_tab" style="width:370px; text-align:center; margin-bottom:30px;"
                  cellspacing="0" cellpadding="0">
               <tbody>
               <tr>
                   <td width="20%">地址</td>
                   <td width="20%">备注</td>
                   <td width="1%" colspan="2">操作</td>
               </tr>
               <c:forEach items="${addressList}" var="temp">
                   <tr>
                       <td>${temp.address}</td>
                       <td>${temp.remark}</td>                        
                       <td>
                       	<a href="${ctx}/PAddress?action=toUpdate&id=${temp.id}">修改</a>
                       </td>
                       <td>
                       	<c:if test="${sessionScope.loginUser.id!=temp.id}">
                          	 <a href="javascript:void(0);" onclick="deleteAddressId('${temp.id}');" target="_blank">删除</a>
                       	</c:if>
                       </td>
                   </tr>
               </c:forEach>
               </tbody>
           </table>
    </c:otherwise>
</c:choose>
 
      <%@ include file="/common/pre/pagerBar.jsp" %>
 	<jsp:include page="../common/bottom.jsp" /></div>
</body>
</html>


