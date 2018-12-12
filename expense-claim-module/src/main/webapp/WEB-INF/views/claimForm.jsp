<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form:form action="claimExpense" method="POST" modelAttribute="claim">
			<tr>
				<th>Employee ID:</th>
				<td><form:input path="employeeId" /></td>
				<td style="color: red;"><form:errors path="employeeId"></form:errors></td>
			</tr>
		
				<th>Project Code:</th>
				<td><form:input path="projectCode" /></td>
				<td style="color: red;"><form:errors path="projectCode"></form:errors></td>
			</tr>
			<tr>
				<th>Expense Code:</th>
				<td><form:input path="expenseCode" /></td>
				<td style="color: red;"><form:errors path="expenseCode"></form:errors></td>
			</tr>
			<tr>
				<th>Start Date:</th>
				<td><form:input path="startDate" type="date" /></td>
				<td style="color: red;"><form:errors path="startDate"></form:errors></td>
			</tr>
			<tr>
				<th>End Date:</th>
				<td><form:input path="endDate" type="date" /></td>
				<td style="color: red;"><form:errors path="endDate"></form:errors></td>
			</tr>
			<tr>
				<th>Expense Amount:</th>
				<td><form:input path="expenseAmount" /></td>
				<td style="color: red;"><form:errors path="expenseAmount"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Claim Expense"></input></td>
			</tr>
			<a href="home">Click here to go back</a><br/>
		</form:form>
	</table>
</body>
</html>