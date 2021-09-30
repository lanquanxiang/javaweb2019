<%@page import="cn.edu.pzhu.util.JDBCUtil"%>
<%@page import="java.sql.*"%>
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

	Connection connection = JDBCUtil.getConnection();
	out.print(connection+"<br/>");
//3.编写sql语句
	String sql = "select * from user";
//4.创建命令对象	
	Statement sta = connection.createStatement();
//5.执行sql
	ResultSet res = sta.executeQuery(sql);
//6.处理结果（ResultSet、int）
	while(res.next()){
		out.print(res.getString(1)+"|"+res.getString(2)+"<br/>");
	}
//7.释放资源	
	JDBCUtil.close(res, sta, connection);



%>
</body>
</html>