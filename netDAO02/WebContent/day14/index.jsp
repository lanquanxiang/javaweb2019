<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<%=session.getAttribute("msg") %>
<form action="<%=request.getContextPath() %>/regist" method="post">
	name:<input type="text" name="name" >
	password:<input type="password" name="password" >
	<input type="submit" value="注册" >
</form>
</body>
</html>