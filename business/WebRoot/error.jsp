<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String act = request.getParameter("act");
String controller = request.getParameter("controller");
String message = request.getParameter("message");
if(message.equals("dne")){
	message = "请先删除子类";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		alert("<%=message%>");
		window.location.href="<%=path%>/<%=controller%>?act=<%=act%>";
	</script>
  </head>
  	
  <body>
    
  </body>
</html>
