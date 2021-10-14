<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有汽车信息</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/show">显示汽车信息</a>
<hr/>
<table>
	<tr>
		<th>序号</th>
		<th>车名</th>
		<th>型号</th>
		<th>价格</th>
	</tr>
	<c:forEach items="${list}" var="car">
		<tr>
			<td>${car.car_id}</td>
			<td>${car.car_name}</td>
			<td>${car.car_type}</td>
			<td>${car.car_price}</td>
		</tr>
	</c:forEach>
	
	<%--

	ArrayList<Car> list = (ArrayList<Car>)session.getAttribute("list");
	if(list!=null && list.size()>0){
		for(int i = 0;i<list.size();i++){
			out.print("<tr>");
			out.print("<td>"+list.get(i).getCar_id()+"</td>");
			out.print("<td>"+list.get(i).getCar_name()+"</td>");
			out.print("<td>"+list.get(i).getCar_type()+"</td>");
			out.print("<td>"+list.get(i).getCar_price()+"</td>");
			out.print("</tr>");
		}
	}
	
--%>

</table>
</body>
</html>