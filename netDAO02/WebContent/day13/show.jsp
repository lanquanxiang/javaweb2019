<%@page import="cn.edu.pzhu.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户数据</title>
</head>
<body>
<table border="1">
	<tr>
		<th>NAME</th>
		<th>Password</th>
	</tr>
<%
	ArrayList<User> list = (ArrayList<User>)session.getAttribute("list");
	if(list!=null && list.size()>0){
		for(int i = 0;i<list.size();i++){
			out.print("<tr>");
			out.print("<td>"+list.get(i).getName()+"</td>");
			out.print("<td>"+list.get(i).getPassword()+"</td>");
			out.print("</tr>");
		}
	}
%>
</table>
</body>
</html>