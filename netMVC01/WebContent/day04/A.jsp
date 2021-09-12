<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单数据提交</title>
<script type="text/javascript">
	function fun() {
		var username = document.getElementById("username").value;
		if(username==""){
			alert("用户名不能为空");
			return false;
		}
	}
</script>
</head>
<body>
<form action="B.jsp" method="post" onsubmit="return fun()">
	用户名:<input type="text" name="username" id="username"> <br/>
	爱好：
	<input type="checkbox" name="aihao" value="唱歌" >唱歌
	<input type="checkbox" name="aihao" value="上课" >上课 
	<input type="checkbox" name="aihao" value="写代码" > 写代码
	<input type="submit">
</form>
</body>
</html>