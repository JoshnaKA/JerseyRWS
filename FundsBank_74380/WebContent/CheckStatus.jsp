<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:form action="getcheckstatus" method="post"
		modelAttribute="complaintdetails">
		<h3 align="center">Check Status</h3>
		<hr>
		<table align="center">
			<tr>
				<td>Complaint Id: <c:input path="complaintId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Check Status"></td>
			</tr>
		</table>
	</c:form>
	<c:form modelAttribute="complaintdetails">

		<p:if test="${complaintObjList ne null}">
			<table align="center" border="1">
				<tr>
					<th>Complaint id</th>
					<th>Description</th>
					<th>Status</th>
				</tr>
				<p:forEach items="${complaintObjList}" var="complaintstatus">
					<tr>
						<th>${complaintstatus.complaintId}</th>
						<th>${complaintstatus.description}</th>
						<th>${complaintstatus.status}</th>

					</tr>
				</p:forEach>

			</table>
			<a href="getcomplaint"><h3 align="center">Raise Complaint</h3></a>

		</p:if>

	</c:form>

</body>
</html>