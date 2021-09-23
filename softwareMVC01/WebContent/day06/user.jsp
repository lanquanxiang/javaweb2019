<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户输入信息</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/lisi" method="post">
	姓名：<input type="text" name="username"/><br/>
	密码：<input type="password" name="password"/><br/>
	爱好：<input type="checkbox" name="hobby" value="写代码"/>写代码
		<input type="checkbox" name="hobby" value="读书"/>读书
		<input type="checkbox" name="hobby" value="学英语"/>学英语
		<input type="checkbox" name="hobby" value="跑步健身"/>跑步健身
		<input type="submit"/>
	<br/>
</form>
</body>
</html>