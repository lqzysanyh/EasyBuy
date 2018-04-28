<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script src="${pageContext.request.contextPath}/statics/js/backend/backend.js"></script>
</head>
<body>
<jsp:include page="../common/ctx.jsp" />
<jsp:include page="../common/top.jsp" />
<%@ include file="../common/titlePanle.jsp" %>

    <div class="m_right" id="content">
      <p></p>
      <p></p>
      <div class="mem_tit">订单列表</div>
      <table border="0" class="order_tab" style="width:370px; text-align:center; /* margin-bottom:30px; */" cellspacing="0" cellpadding="0">
        <tbody>
        <c:forEach items="${orderList}" var="temp">
          <tr class="td_bg">
            <td>用户名:${temp.loginName}</td>
            <td><a href="${pageContext.request.contextPath}/Porder?action=queryOrderDeatil&orderId=${temp.id}">订单号:${temp.serialNumber}</a></td>
            <td>地址:${temp.userAddress}</td>
            <td>￥${temp.cost}</td>
          </tr>
          <tr>
          </tr>
          <tr>
            <td colspan="4">
              <table border="0" class="order_tab" style="width:370px; text-align:center; /* margin-bottom:30px; */" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                  <td width="20%">商品名称</td>
                  <td width="20%">商品图片</td>
                  <td width="25%">数量</td>
                  <td width="25%">价格</td>
                </tr>
                <c:forEach items="${temp.detailList}" var="temp">
                  <tr>
                    <td>${temp.product.name}</td>
                    <td>
                      <a href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&id=${temp.product.id}" target="_blank">
                        <img src="${pageContext.request.contextPath}/files/${temp.product.fileName}" width="50" height="50">
                      </a>
                    </td>
                    <td>${temp.quantity}</td>
                    <td>${temp.cost}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <%@ include file="/common/pre/pagerBar.jsp" %>
 	<jsp:include page="../common/bottom.jsp" /></div>
</body>
</html>


