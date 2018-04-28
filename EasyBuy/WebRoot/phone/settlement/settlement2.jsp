<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<div class="content mar_20">
    <img src="${ctx}/statics/images/img2.jpg"/>
</div>
<%-- <div class="viewport">
	<div data-role="page" id="pageone">
<jsp:include page="../common/ctx.jsp" />
<jsp:include page="../common/top.jsp" />
 --%>
 <div id="iSlider-effect-wrapper">
    <div id="animation-effect" class="iSlider-effect"></div>
</div>
<div class="content mar_20">
        <div class="two_t">
            <span class="fr"><a href="javascript:void(0);" onclick="settlement1();">修改</a></span>商品列表
        </div>
        <table border="0" class="car_tab" style="width:390px; float: left;" cellspacing="0" cellpadding="0">
            <tr>
                <td class="car_th" width="15%">商品名称</td>
                <td class="car_th" width="10%">购买数量</td>
                <td class="car_th" width="10%">小计</td>
            </tr>
            <c:forEach items="${applicationScope[loginUser.userName].items}" var="temp">
                <tr>
                    <td>
                        <div class="c_s_img">
                            <img src="${ctx}/files/${temp.product.fileName}" width="73" height="73"/>
                        </div>
                            ${temp.product.name}
                    </td>
                    <td align="center">${temp.quantity}</td>
                    <td align="center" style="color:#ff4e00;">￥${temp.cost}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="two_t">
            <span class="fr"></span>收货人信息
        </div>
        <table border="0" class="peo_tab" style="width:370px;float: left;" cellspacing="0" cellpadding="0">
            <tr>
                <td class="p_td" width="160">用户名称</td>
                <td width="395">${sessionScope.loginUser.userName}</td>
                <td class="p_td">登录名称</td>
                <td>${sessionScope.loginUser.loginName}</td>
            </tr>
            <tr>
                <td class="p_td">手机</td>
                <td>${sessionScope.loginUser.mobile}</td>
                <td class="p_td" width="160">电子邮件</td>
                <td width="395">${sessionScope.loginUser.email}</td>
            </tr>
        </table>
        <div class="two_t">
            <span class="fr"></span>选择地址
        </div>
        <table border="0" class="peo_tab" style="width:370px;float: left;" cellspacing="0" cellpadding="0">
            <c:forEach items="${addressList}" var="temp" varStatus="status">
                <tr>
                    <td class="p_td" width="160">
                        <c:choose>
                            <c:when test="${empty temp.remark}">
                                地址${status.index+1}
                            </c:when>
                            <c:otherwise>
                                ${temp.remark}
                            </c:otherwise>
                        </c:choose>
                        <input type="radio" name="selectAddress" value="${temp.id}">
                    </td>
                    <td>
                            ${temp.address}
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td class="p_td" width="160">
                    新地址<input type="radio" name="selectAddress" value="-1">
                </td>
                <td>
                    地址&nbsp;<input type="text" value="" name="address" class="add_ipt">&nbsp;
                    备注&nbsp;<input type="text" value="" name="remark" class="add_ipt">
                </td>
            </tr>
        </table>
        <table border="0" style="width:370px; margin-top:20px;float: left;" cellspacing="0" cellpadding="0">
            <tr height="70">
                <td align="right">
                    <b style="font-size:14px;">应付款金额：<span
                            style="font-size:22px; color:#ff4e00;">￥${applicationScope[loginUser.userName].sum}</span></b>
                </td>
            </tr>
            <tr height="70">
                <td align="right"><a href="javascript:void(0);" onclick="settlement3();"><img
                        src="${ctx}/statics/images/btn_sure.gif"/></a></td>
            </tr>
        </table>
</div>
<!-- </div>
</div> -->