<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Hello :: Test Application 国际化测试</title>
	</head>
	<body>
		<h1>
			Hello - Test Application
		</h1>
		<p>
			Greetings.it is now
			<c:out value="${now}"/>
			
			Message is :<spring:message code="title"/>
			<br/>
			Error Message is:<fmt:message key="error"/>
		</p>
	</body>
</html>