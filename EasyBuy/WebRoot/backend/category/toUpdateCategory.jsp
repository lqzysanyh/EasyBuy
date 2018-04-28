<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<table border="0" class="add_tab" style="width:930px;" cellspacing="0" cellpadding="0">
    <tr>
        <td width="135" align="right">分类级别</td>
        <td colspan="3" style="font-family:'宋体';" >
            <select class="jj" name="type" style="background-color:#f6f6f6;" id="type"
                    onchange="selectCategoryLevel(this);" <c:if test="${category.id!=null}">disabled="disabled"</c:if>>
                <option value="" selected="selected">请选择...</option>
                <option value="1"
                        <c:if test="${category.type==1}">selected="selected"</c:if> >一级分类
                </option>
                <option value="2"
                        <c:if test="${category.type==2}">selected="selected"</c:if> >二级分类
                </option>
                <option value="3"
                        <c:if test="${category.type==3}">selected="selected"</c:if> >三级分类
                </option>
            </select>
        </td>
    </tr>
        <tr  <c:if test="${category.type==1}">style="display:none"</c:if>>
            <td width="135" align="right">一级分类</td>
            <td colspan="3" style="font-family:'宋体';">
                <select class="jj" name="categoryLevel1" style="background-color:#f6f6f6;"  id="ctegoryLevel1" onchange="queryCategoryList(this,'categoryLevel2');">
                    <option value="0" selected="selected">请选择...</option>
                    <c:forEach items="${categoryList1}" var="temp">
                        <option value="${temp.id}"
                                <c:if test="${category.id==temp.id || category.parentId==temp.id || parentCategory.parentId==temp.id}">selected="selected"</c:if> >${temp.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr <c:if test="${category.type!=3}">style="display:none"</c:if>>
            <td width="135" align="right">二级分类</td>
            <td>
                <select class="jj" name="categoryLevel2" style="background-color:#f6f6f6;"
                        id="categoryLevel2">
                    <option value="0" selected="selected">请选择...</option>
                    <c:forEach items="${categoryList2}" var="temp">
                        <option value="${temp.id}"
                                <c:if test="${category.id==temp.id || category.parentId==temp.id}">selected="selected"</c:if> >${temp.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    <tr>
        <td align="right">分类名称</td>
        <td style="font-family:'宋体';">
            <input type="text" value="${category.name}" class="add_ipt" id="name"/>（必填）
            <input type="hidden" name="id" value="${category.id}" id="id">
        </td>
    </tr>
</table>
<p align="right">
    <br>
    <a href="javascript:void(0);" onclick="modifyCategory();" class="add_b">确认修改</a>
</p>