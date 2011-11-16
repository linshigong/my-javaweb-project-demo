<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.testspring.test.Foo" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <jsp:useBean id="foo" class="com.testspring.test.Foo"/>
  <jsp:useBean id="test" class="com.testspring.test.test"/>
    <p>This is my JSP page.</p>
    <%=foo%> <br><% //request.getSession().getServletContext().get %>
    <%=test %>
  </body>
</html>
