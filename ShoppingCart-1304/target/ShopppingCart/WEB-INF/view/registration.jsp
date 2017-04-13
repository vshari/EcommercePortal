<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>

	This is a registration page

	<form:form action="registration" method="post" commandName="user">

		<table>
			<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" disabled="false"/></td>
				
				</td>

			</tr>
			<tr>
				<td><form:label path="name">User Name</form:label></td>
				<td><form:input path="name" class="form-control" /></td>
				<td><form:errors path="name" /></td>

			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" class="form-control" /></td>
				<td><form:errors path="password" /></td>

			</tr>
			<tr>
				<td><form:label path="mail">Email</form:label></td>
				<td><form:input path="mail" class="form-control" /></td>
				<td><form:errors path="mail" /></td>

			</tr>
			<tr>
				<td><form:label path="contact">Phone</form:label></td>
				<td><form:input path="contact" class="form-control" /></td>
				<td><form:errors path="contact" /></td>

			</tr>
			
			
			<tr>
				<td colspan="2"><input type="submit" value="registration"
					class="btn btn-default"></td>
			</tr>


		</table>

	</form:form>



</body>

</html>