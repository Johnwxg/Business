<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setCharacterEncoding("utf-8");
String act = request.getParameter("act");//从service层获取act标识符
String controller = request.getParameter("controller");//从service层获取控制器信息
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		alert("成功！");
		window.location.href="<%=path%>/<%=controller%>?act=<%=act%>";//根据控制器将标示act传回控制器
	</script>
  </head>
  
  <body>
    
  </body>
</html>
