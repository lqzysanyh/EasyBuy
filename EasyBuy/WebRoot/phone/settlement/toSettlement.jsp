<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
  var contextPath = "${ctx}";
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <jsp:include page="../common/ctx.jsp" />
    <%@ include file="/common/top.jsp" %>
    <!-- <script src="../js/Pcart.js"></script> -->
    <title>楚游网</title>
</head>
<body>

<div class="i_bg">
<%@ include file="../common/titlePanle.jsp" %>
    <div id="settlement"></div>
    <script>
        $(function(){
            settlement1();
        });
    </script>
    <%-- <%@ include file="/common/pre/footer.jsp" %> --%>
</div>
  	<jsp:include page="../common/bottom.jsp" flush="true" />

</body>
</html>
