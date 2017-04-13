<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


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

<title>Category Page</title>

</head>

<body>

	<h2>
		<center>Manage Category</center>
	</h2>

	<hr>
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<a href="manage_category_create" class="btn btn-primary">Create
			Category</a>
	
	
		</security:authorize>
		
		
	<br>

	<table border="2">

		<thead>

			<tr>

				<td>Id</td>

				<td>Name</td>

				<td>Description</td>

				<td>Action</td>

			</tr>

		</thead>

		<c:forEach var="category" items="${categoryList}">

			<tr>

				<td>${category.id}</td>

				<td>${category.name}</td>

				<td>${category.description}</td>

				<td>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<a href="<c:url value="manage_category_edit/${category.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="manage_category_delete/${category.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>Delete
						</a></security:authorize>
					</td>

			</tr>

		</c:forEach>

	</table>

	<br>

	<br>

</body>

</html>