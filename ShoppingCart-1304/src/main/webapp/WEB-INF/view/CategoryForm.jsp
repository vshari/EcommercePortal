<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--<form action="manage_category_create" method="post">

		Category Id: <input type="text" name="id"> <br> Category
		Name: <input type="text" name="name"><br> Category
		Description:<input type="text" name="description"> <br> <input
			type="submit" value="Create">

	</form>
	
	-->
		<c:url value="/manage_category_create" var="url"></c:url>
	
	<form:form method="post" action="${url}"
		commandName="createCategoryObj">
		<table>
			<tr>
				<td><form:label path="id">Category Id</form:label></td>
				<td><form:input path="id" disabled="true" class="form-control" />
					<form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Category Name</form:label></td>
				<td><form:input path="name" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Category Description</form:label></td>
				<td><form:input path="description" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Add Category"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>