<%@ page language="java" import="java.util.*,org.apache.commons.lang3.StringUtils" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--自定义标签  核心标签库 --%>
<%@ include file="../header.jsp"%>
<%@ include file="leftmenu.jsp"%>
<div class="centercontent">
	<form action="<%=path%>/NewsCategoryController" method="post">
		<table class="table">
			<tr>
				<th>名称</th>
				<th>内容</th>
			</tr>
			<tr>
				<td>上级分类</td>
				<td><select name="cid">
					<option value="0" selected="selected">顶级分类</option>
					<c:forEach var="cates" items="${categories}" >
						<c:set var="level" value="${cates.level}" scope="request"></c:set><%--获取分类等级 --%>
						<option value="${cates.cid}" 
							<c:if test="${cates.cid==category.fid}">selected="selected"</c:if>><%--判断 根据当前分类cid与分类名称的fid比较，若有相等则默认选中其为该子类的父类 --%>
							<%=StringUtils.repeat("----",(Integer)request.getAttribute("level")-1)%>${cates.cname}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>分类名称</td>
				<td><input type="text" name="cname" value="${category.cname}" /></td>
			</tr>
			<tr>
				<input type="hidden" name="act" value="update"/><%--设置一个标识符，来标示添加或修改操作 --%>
				<td colspan="2" style="text-align:center">
					<input type="hidden" name="id" value="${category.cid}"/>
					<input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
	
</div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
