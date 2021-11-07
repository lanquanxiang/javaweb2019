<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
function fun() {
	if($("#name").val()==""){
		$("span").html("用户名不能为空!");
		return;
	}
	$.post(
			"${pageContext.request.contextPath}/check",
			{name:$("#name").val()},
			function(data){
				$("span").html(data);
			}
	);
}
</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/regist" method="post">
	name:<input id="name" type="text" name="name" onchange="fun()"><span></span><br/>
	password:<input type="text" name="password"><br/>
	<input type="submit" value="注册">
</form>
</body>
</html>