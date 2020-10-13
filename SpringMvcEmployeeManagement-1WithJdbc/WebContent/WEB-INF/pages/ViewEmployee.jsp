<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
			<th>Update?</th>
			<th>Delete?</th>
		</tr>
		<c:forEach var="emp" items="${ requestScope.employeeList }">
			<c:url var="deleteUrl" value="deleteEmployee.do">
				<c:param name="employeeId" value="${ emp.employeeId }"/>
			</c:url>
			<c:url var="updateUrl" value="updateEmployeePage">
				<c:param name="employeeId" value="${ emp.employeeId }"/>
				<c:param name="employeeName" value="${ emp.employeeName }"/>
				<c:param name="employeeSalary" value="${ emp.employeeSalary }"/>
			</c:url>
			<tr>
				<td><c:out value="${ emp.employeeId }"/></td>
				<td><c:out value="${ emp.employeeName }"/></td>
				<td><c:out value="${ emp.employeeSalary }"/></td>
				<td><a href='<c:out value="${ updateUrl }"/>'>Update</a></td>
				<td><a href='<c:out value="${ deleteUrl }"/>'>Delete</a></td>
			</tr>
		</c:forEach>
</table>
</body>
</html>