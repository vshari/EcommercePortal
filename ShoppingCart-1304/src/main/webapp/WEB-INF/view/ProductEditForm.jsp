<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="manage_category_edit" method="post"> 

	Category Id:  <input type="text" name="id"> <br>
		Category Name:      <input type="text" name="name"><br>
		Category Description:<input type="text" name="description"> <br>
		<input type="submit" value="Create">

	</form> -->
	<form:form action="manage_product_edit" method="post"
		commandName="productEditForm">
		<table>
			<tr>
				<td><form:label path="id">Product Id</form:label></td>
				<td><form:input path="id" disabled="true"></form:input> <form:hidden
						path="id"></form:hidden></td>
			</tr>

			<tr>
				<td><form:label path="id">Product Name</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="id">Product Price</form:label></td>
				<td><form:input path="price"></form:input></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="id">Product Description</form:label></td>
				<td><form:input path="description"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="supplier">Supplier Name</form:label></td>

				<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Category Name</form:label></td>

				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>
			<td>
			<input type="submit" value="Create">
			</td>
			</tr>
		</table>
	</form:form>
</body>
</html>