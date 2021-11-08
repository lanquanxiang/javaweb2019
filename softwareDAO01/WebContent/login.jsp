<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath}/login" method="post">
	name:<input type="text" name="name" value="${cookie.username.value }"><br/>
	password:<input type="password" name="password" value="${cookie.password.value }"><br/>
	<input type="checkbox" ${empty cookie.save.value?"":"checked"} name="save" value="yes"/>保存用户名和密码
	<input type="submit" value="登录"/>
</form>
<a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
</body>
</html>