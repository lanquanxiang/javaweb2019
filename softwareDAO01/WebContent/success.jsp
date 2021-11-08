<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
欢迎${user.name},${sessionScope.msg}.
<ul>
	<li><a href="${pageContext.request.contextPath}/show">显示所有汽车信息</a></li>
	<li><a href="">修改密码</a></li>
	<li><a href="">销毁账户</a></li>
	<li><a href="">退出</a></li>
</ul>
<hr/>
<c:if test="${empty list }">
请点击<a href="${pageContext.request.contextPath}/show">这里</a>加载数据
</c:if>
<c:if test="${not empty list }">
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>type</th>
		<th>price</th>
	</tr>
	<c:forEach items="${list}" var="car">
		<tr>
			<td>${car.car_id}</td>
			<td>${car.car_name}</td>
			<td>${car.car_type}</td>
			<td>
			<fmt:formatNumber value="${car.car_price}" type="number" pattern=".00"></fmt:formatNumber>
			</td>
		</tr>
	 </c:forEach>
	 <tr>
	 	<td colspan="4">${bar}</td>
	 </tr>
	 <tr>
	 	<td colspan="4">
	 		<form action='${pageContext.request.contextPath}/show'>
	 			每页显示<input type="text" value='${ empty num ? 10 : num }' name="num">条
	 			<input type="submit"  value='确定'>
	 		</form>
	 	</td>
	 </tr>
</table>
</c:if>
</body>
</html>