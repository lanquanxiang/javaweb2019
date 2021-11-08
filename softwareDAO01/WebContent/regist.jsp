<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="jquery-3.2.0.min.js" ></script>
<script type="text/javascript">
	function fun(){
		if($(":text").val()==""){
			$("span").html("用户名不能为空");
			return;
		}
		$.post("${pageContext.request.contextPath}/check",
			{username:$(":text").val(), time:new Date().getTime()}	,
			function (data) {
				$("span").html(data);
			}
		)
	}
</script>
</head>
<body>
${msg}
<form action="<%=request.getContextPath() %>/regist" method="post">
	name:<input type="text" name="name" onchange="fun()" ><span></span><br />
	password:<input type="password" name="password"><br />
	<input type="submit" value="注册"/>
</form>
<a href="<%=request.getContextPath() %>/login.jsp">登录</a>
</body>
</html>