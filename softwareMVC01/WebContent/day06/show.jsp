<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
</head>
<body>
<%=session.getAttribute("msg") %>
<%
	String[] hs = (String[])session.getAttribute("hs");
	if(hs!=null){
		out.print(Arrays.toString(hs));
	}

%>
</body>
</html>