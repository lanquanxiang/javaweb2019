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
<c:if test="${not empty list}">
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
				<td><a href="edit.jsp?id=${car.car_id}">编辑</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">${bar}</td>
		</tr>
	</table>
</c:if>
<c:if test="${empty list}">
	请点击上方的超链接，获得数据之后再继续操作。
</c:if>
</body>
</html>