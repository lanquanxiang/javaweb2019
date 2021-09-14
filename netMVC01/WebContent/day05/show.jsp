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

<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	if(username==null){
		username = (String)session.getAttribute("aaa");
	}else{
		session.setAttribute("aaa", username);
	}
	
	
	String[] aihaos = request.getParameterValues("aihao");
	out.print("用户名:"+username);
	
	out.print("爱好有:"+Arrays.toString(aihaos));
	/*
	//如果用户没有选择爱好，会发生空指针异常
	for(int i=0;i<aihaos.length;i++){
		out.print(aihaos[i]+"  ");
	}
	*/

	//输出，可以用表达式，也可以用out
	
%>
	<a href="logout.jsp">销毁session</a>
</body>
</html>