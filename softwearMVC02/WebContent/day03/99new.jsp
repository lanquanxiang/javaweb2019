<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>九九乘法表</title>
</head>
<body>
<!-- HTML注释 -->
<%-- JSP注释 --%>

<%
	//System.out.print("");//输出到控制台
	//out.print("");//输出到页面
	/**/
	
	int i = 1;int j =1;
	for(i=1;i<=9;i++){
		for(j=1;j<=i;j++){
			%>
			<%=i %>*<%=j %>=<%=i*j%>  		
			<%
		}
		%>
		<br/>		
		<%
	}


%>
</body>
</html>