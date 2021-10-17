<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
欢迎${user.name}，${msg}<br/>

<hr/>
<c:if test="${not empty list }">
	<table>
		<tr>
			<th>ID</th><th>NAME</th><th>TYPE</th><th>PRICE</th>
		</tr>
		<c:forEach items="${list}" var="x">
			<tr>
				<td>${x.car_id }</td>
				<td>${x.car_name }</td>
				<td>${x.car_type }</td>
				<td>
					<fmt:formatNumber value="${x.car_price }" type="number" pattern=".00"></fmt:formatNumber>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">${bar}</td>
		</tr>
		<tr>
			<td colspan="4">
				<form action="${pageContext.request.contextPath}/show">
					每页显示<input type="text" name="num" value="${empty num?10:num}">条
					<input type="submit" value="确定">
				</form>
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${empty list }">
没有数据，请点击<a href="${pageContext.request.contextPath}/show">此处</a>查询数据！
</c:if>
</body>
</html>