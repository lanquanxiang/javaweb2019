<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据显示</title>
</head>
<body>
	<%=	session.getAttribute("msg")	%>
	<%
		if(session.getAttribute("flag")!=null && (boolean)session.getAttribute("flag")){
			String[] aihaos = (String[])session.getAttribute("aihao");
			out.print(Arrays.toString(aihaos));
		}
	%>
	<br/>
	<a href="<%=request.getContextPath() %>/LogoutServlet">销毁session</a>
</body>
</html>