<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
${msg}
<form action="<%=request.getContextPath()%>/login" method="post">
	name:<input type="text" name="username">
	password:<input type="password" name="password">
	<input type="submit" value="登录">
</form>
</body>
</html>