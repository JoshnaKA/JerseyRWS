<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:form action="addcomplaint" method="post"
		modelAttribute="mycomplaint">
		<table>
			<tr>
				<td><i>Complaint Id for this request is ${complaintId}</i></td>
			</tr>
			<tr>
				<td><i>Thanks for raising a complaint</i></td>
			</tr>
			<tr>
				<td><a href="checkstatus">Check Status</a></td>

				<td><a href="getcomplaint">Raise Complaint</a></td>
			</tr>

		</table>

	</c:form>
</body>
</html>