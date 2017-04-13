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

<title>Product Page</title>

</head>

<body>

	<h2>
		<center>Manage Product</center>
	</h2>

	<hr>
	<!-- march 10th /manage_category_create -->
	<!-- <form action="manage_category_create" method="post"> 

		<input type="text" name="id"> 
		<input type="text" name="name">
		<input type="text" name="description"> 
		<input type="submit" value="Create">

	</form> -->
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<a href="manage_product_create" class="btn btn-primary">Create
		Product</a></security:authorize>
	<br>

	<!--${categoryList}  -->

	<table border="2">

		<thead>

			<tr>
			<td>Product Image</td>

				<td>Id</td>
				<td>Name</td>
				<td>Description</td>

				<td>Price</td>
				<td>Category_id</td>
				<td>Supplier_id</td>

				<td>Action</td>

			</tr>

		</thead>

		<c:forEach var="product" items="${productList}">

			<tr>
			<td><c:url value="/resources/images/${product.id}.png"
								var="src" /> <img src="${src }" style="width: 70px"
							align="middle" /></td>

			

				<td>${product.id}</td>
				
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.category.name}</td>
				<td>${product.supplier.name}</td>
				
				<%-- <td><a href="manage_product_edit/${product.id}"> Edit</a> | <a
					href="manage_product_delete/${product.id}"> Delete</a></td> --%>
					
					<td><security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="<c:url value="manage_product_edit/${product.id}"/>">Edit
								<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="manage_product_delete/${product.id}"/>">
								<span class="glyphicon glyphicon-trash"></span>delete
						</a></security:authorize></td>
					
			</tr>

		</c:forEach>

	</table>

	<br>

	<br>

</body>

</html>