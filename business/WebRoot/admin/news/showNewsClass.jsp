<%@ page language="java" import="java.util.*,org.apache.commons.lang3.StringUtils" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--自定义标签  核心标签库 --%>
<%@ include file="../header.jsp"%>
<%@ include file="leftmenu.jsp"%>
<div class="centercontent">
		<table class="table">
			<tr>
				<th>名称</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<c:forEach var="cates" items="${categories}">
				<tr>
					<c:set var="level" value="${cates.level}" scope="request"></c:set><%--获取分类等级 --%>
					<td>分类名称</td>
					<td><%=StringUtils.repeat("----",(Integer)request.getAttribute("level")-1)%>${cates.cname}</td>
					<td><a href="<%=path%>/NewsCategoryController?cid=${cates.cid}&act=show_update_page">修改</a>&nbsp;&nbsp;<a href="<%=path%>/NewsCategoryController?cid=${cates.cid}&act=delete_category">删除</a></td>
				</tr>
			</c:forEach>
		</table>

</div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
