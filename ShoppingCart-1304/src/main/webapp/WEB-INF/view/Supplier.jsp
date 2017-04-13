<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Supplier Page</title>

</head>

<body>

	<h2>
		<center>Manage Supplier</center>
	</h2>

	<hr>
	<!-- march 10th /manage_supplier_create -->
	<!-- <form action="manage_category_create" method="post"> 

		<input type="text" name="id"> 
		<input type="text" name="name">
		<input type="text" name="description"> 
		<input type="submit" value="Create">

	</form> -->
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<a href="manage_supplier_create" class="btn btn-primary">Create
		Supplier</a>
		</security:authorize>
	<br>

	<!--${supplierList}  -->

	<table border="2">

		<thead>

			<tr>

				<td>Id</td>

				<td>Name</td>

				<td>Address</td>

				<td>Action</td>

			</tr>

		</thead>

		<c:forEach var="supplier" items="${supplierList}">

			<tr>

				<td>${supplier.id}</td>

				<td>${supplier.name}</td>
				<td>${supplier.address}</td>

				<td><security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="manage_supplier_edit/${supplier.id}"> Edit</a> | <a
					href="manage_supplier_delete/${supplier.id}"> Delete</a>
					</security:authorize></td>

			</tr>

		</c:forEach>

	</table>

	<br>

	<br>

</body>

</html>