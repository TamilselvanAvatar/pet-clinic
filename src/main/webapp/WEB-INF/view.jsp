<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${Empty==null }">
		<table class="data">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Pet breed</th>
				<th>Date</th>
				<th>Time</th>
			</tr>
			<c:forEach items="${appointments }" var="item">
				<tr>
					<td><c:out value="${item.getId() }"></c:out></td>
					<td><c:out value="${item.getName() }"></c:out></td>
					<td><c:out value="${item.getMobile() }"></c:out></td>
					<td><c:out value="${item.getPetBreed() }"></c:out></td>
					<td><c:out value="${item.getDate() }"></c:out></td>
					<td><c:out value="${item.getTime() }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<a href="home">Click here to book an appointment</a>
	</c:if>
	<c:if test="${Empty != null }">
		<span class="msg">${Empty }</span>
	</c:if>
</body>
</html>