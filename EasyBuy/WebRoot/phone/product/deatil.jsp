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
     <jsp:include page="../common/ctx.jsp" /> 
     <link rel="stylesheet" type="text/css" href="css/ShopShow.css" />
	<link rel="stylesheet" type="text/css" href="css/MagicZoom.css" />
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	<style>
	#content{width: 370px;}
    	#content ul li{float: left; width: 174px;border: 1px white solid;}
   		.price{color:#ff4e00;}
    </style>
</head>
<body>
<div class="viewport">
	<div data-role="page" id="pageone">

<jsp:include page="../common/top.jsp" />
	<%@ include file="../common/titlePanle.jsp" %>
	
	<div class="content">
	    <p><img src="${ctx}/files/${product.fileName}" width="370px" /></p>
	     <input type="hidden" value="${product.id}"  name="entityId" class="n_ipt"/>
	     <div class="des_price">
               	本店价格：<b>￥${product.price}</b><br/>    	
         </div>
         <div class="des_price">
               	商品名称：<b>${product.name}</b><br/>    	
         </div>
         <div class="des_price">
            	    库存：<b>${product.stock}</b><br/>
         </div>
         <div class="des_choice">
                <span class="fl">型号选择：</span>
                <ul id="des_ml">
                    <li class="check">30ml
                        <div class="ch_img"></div>
                    </li>
                    <li>50ml
                        <div class="ch_img"></div>
                    </li>
                    <li>100ml
                        <div class="ch_img"></div>
                    </li>
                </ul>
          </div>
          <div class="des_choice">
                <span class="fl">颜色选择：</span>
                <ul id="des_ml">
                    <li class="">红色
                        <div class="ch_img"></div>
                    </li>
                    <li>白色
                        <div class="ch_img"></div>
                    </li>
                    <li>黑色
                        <div class="ch_img"></div>
                    </li>
                </ul>
            </div>
            <div class="des_join">
                <div class="j_nums">
                    <input type="text" value="1"  name="quantity" class="n_ipt"/>
                    <input type="button" value="" onclick="jianUpdate(jq(this));" class="n_btn_2"/>
                    <input type="button" value="" onclick="addUpdate(jq(this));" class="n_btn_1"/>
                    <input type="hidden" name="productStock" value="${product.stock}">
                </div>
                <span class="fl" style="margin-top: -15px;">
                     <img src="${ctx}/statics/images/j_car.png" onclick="addCart();"/>
                </span>
            </div>
          	<p>商品属性</p>
            <table border="0" align="center" style="width:100%; font-family:'宋体'; margin:10px auto;"
                           cellspacing="0" cellpadding="0">
                        <tr>
                            <td>商品名称：${product.name}</td>
                            <td>商品价格：${product.price}</td>
                        </tr>
                        <tr>
                            <td>商品毛重：160.00g</td>
                            <td>商品产地：法国</td>
                        </tr>
                        <tr>
                        	<td>品牌： 迪奥（Dior）</td>
                            <td>上架时间：2015-09-06 09:19:09 </td>
                        </tr>
                        <tr>
                        	<td>香调：果香调香型：淡香水/香露EDT</td>
                            <td>容量：1ml-15ml </td>
                        </tr>
                        <tr>
                        	<td>类型：女士香水，Q版香水，组合套装</td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
               		<p> 商品详情    </p>
                <div class="des_con">
                    <table border="0" style="font-size:14px; font-family:'宋体';" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center">
                                ${product.description}
                            </td>
                        </tr>
                    </table>
                    <p align="left">
	                    <img src="${ctx}/files/${product.fileName}" width="370px" height="155" />
                    </p>
                </div>
       
	
	
<%@ include file="../common/titlePanle.jsp" %>

 	<jsp:include page="../common/bottom.jsp" />
</div> 
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<h2>精品推荐</h2>
	   <div id="content" >
          <ul>
              <c:forEach items="${productList}" var="product">
                  <li>
                      <div class="img">
                          <a href="${pageContext.request.contextPath}/PProduct?action=queryProductDeatil&id=${product.id}">
                              <img src="${pageContext.request.contextPath}/files/${product.fileName}" width="173"  height="155"/>
                          </a>
                      </div>
                      <div class="name"><span class="price">
                          <font>￥<span>${product.price}</span></font> &nbsp;
                          </span>
                          <a href="#">${product.name}</a>
                      </div>
                  </li>
              </c:forEach>
          </ul>
  </div>
</div>


  </body>
</html>
