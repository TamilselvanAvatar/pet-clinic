<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style.css">
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<form:form method="post" modelAttribute="person" action="booked">
		<table class="home">
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input type="text" path="id" placeholder="Enter name"
						pattern="^([1-9][0-9]*)$" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input type="text" path="name"
						placeholder="Enter name" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile</form:label></td>
				<td><form:input type="text" path="mobile"
						placeholder="Enter mobile number" pattern="^[6-9]\d{9}$"
						required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="petBreed">Pet Breed</form:label></td>
				<td><form:input type="text" path="petBreed"
						placeholder="Enter pet breed" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="date">Date</form:label></td>
				<td><form:input type="date" path="date"
						placeholder="mm/dd/yyyy" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="Time">Time</form:label></td>
				<td><form:input type="time" path="time" required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Book" class="btn" />
		</table>
		<table>
			<tr>
				<td><a href="today">Click here to view today's appointments</a></td>
			</tr>
			<c:if test="${msg != null }">
				<tr>
					<td><span class="msg">${msg}</span></td>
				</tr>
				<tr>
					<td><a href="view">Click to view appointments</a></td>
				</tr>
			</c:if>
		</table>
	</form:form>

</body>
</html>