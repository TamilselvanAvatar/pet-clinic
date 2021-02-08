<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="data">
		<c:if test="${no_today ==null }">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Pet breed</th>
				<th>Date</th>
				<th>Time</th>
			</tr>
			<c:forEach items="${today }" var="item">
				<tr>
					<td><c:out value="${item.getId() }"></c:out></td>
					<td><c:out value="${item.getName() }"></c:out></td>
					<td><c:out value="${item.getMobile() }"></c:out></td>
					<td><c:out value="${item.getPetBreed() }"></c:out></td>
					<td><c:out value="${item.getDate() }"></c:out></td>
					<td><c:out value="${item.getTime() }"></c:out></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:if test="${no_today !=null }">
		<span class="msg">${no_today }</span>
	</c:if>
	<a href="home">Click here to book an appointment</a>
</body>
</html>