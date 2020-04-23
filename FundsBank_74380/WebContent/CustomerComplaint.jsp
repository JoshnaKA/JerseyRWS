<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:form action="addcomplaint" method="post"
		modelAttribute="mycomplaint">
		<h3 align="center">Customer Complaint Request Form</h3>
		<br />
		<hr />

		<table align="center">

			<tr>
				<td>Account Id</td>
				<td><c:input path="accountId" /></td>
				<td><c:errors path="accountId"></c:errors></td>
			</tr>

			<tr>
				<td>Branch Code</td>
				<td><c:input path="branchCode" /></td>
				<td><c:errors path="branchCode"></c:errors></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><c:input path="emailId" /></td>
				<td><c:errors path="emailId"></c:errors></td>
			</tr>


			<tr>
				<td>Complaint Category</td>
				<td><c:select path="category">
						<c:option value="">Select</c:option>
						<c:options items="${categories}" />
					</c:select></td>
				<td><c:errors path="category"></c:errors></td>

			</tr>

			<tr>
				<td>Description</td>
				<td><c:input path="description" /></td>
				<td><c:errors path="description"></c:errors></td>
			</tr>


			<tr align="center">

				<td><input type="submit" value="Submit"></td>
			</tr>
			<tr align="center">
				<td><a href="checkstatus">Check Status</a></td>
			</tr>

		</table>

	</c:form>
</body>
</html>