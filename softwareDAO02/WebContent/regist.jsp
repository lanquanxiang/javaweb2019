<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
	img:HOVER {
	cursor: pointer;
}
</style>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
function fun() {
	if($("#name").val()==""){
		$("span").html("用户名不能为空!");
		return;
	}
	$.get(
			"${pageContext.request.contextPath}/check",
			{name:$("#name").val(),time:new Date().getTime()},
			function(data){
				$("span").html(data);
			}
	);
}

function change() {
	$("img").attr("src","${pageContext.request.contextPath}/imageURL?time="+new Date().getTime());
}
</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/regist" method="post">
	name:<input id="name" type="text" name="name" onchange="fun()"><span></span><br/>
	password:<input type="text" name="password"><br/>
	验证码:<input type="text" name="code">
	<img title="点击刷新" alt="验证码加载失败" src="${pageContext.request.contextPath}/imageURL" onclick="change()">
	<br>
	<input type="submit" value="注册">
</form>
</body>
</html>