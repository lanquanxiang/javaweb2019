<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库连接</title>
</head>
<body>
<%
//1.注册驱动
Class.forName("com.mysql.jdbc.Driver");
//2.创建连接
String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
String user="root";
String password="1234";
Connection con = DriverManager.getConnection(url, user, password);

//out.print(con);
//	3.编写SQL语句
String sql="select * from user";
//	4.创建命令对象	
Statement sta = con.createStatement();
//	5.执行SQL语句
ResultSet res = sta.executeQuery(sql);
//	6.处理结果
while(res.next()){
	out.print(res.getString(1)+"|");
	out.print(res.getString(2)+"<br/>");
}
//	7.释放资源	
res.close();
sta.close();
con.close();


%>
</body>
</html>