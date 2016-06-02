<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="leftmenu.jsp"%>
<div class="centercontent">
	<form action="<%=path%>/WebSiteController" method="post">
		<table class="table">
			<tr>
				<th>名称</th>
				<th>内容</th>
			</tr>
			<tr>
				<td>网站关键字</td>
				<td><input type="text" name="keywords" value="${website.keywords}" /></td>
			</tr>
			<tr>
				<td>网站描述</td>
				<td><input type="text" name="descption" value="${website.descption}" /></td>
			</tr>
			<tr>
				<td>网站版权</td>
				<td><input type="text" name="copy" value="${website.copy}"/></td>
			</tr>
			<tr>
				<td>公司地址</td>
				<td><input type="text" name="addr" value="${website.addr}"/></td>
			</tr>
			<tr>
				<td>公司联系方式</td>
				<td><input type="text" name="mobile" value="${website.mobile}"/></td>
			</tr>
			<tr>
				<input type="hidden" name="id" value="${website.id}"/>
				<td colspan="2" style="text-align:center"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	
</div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
