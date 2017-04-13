<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <form action="manage_product_create" method="post"> 

	Product Id:  <input type="text" name="id"> <br>
		Product Name:      <input type="text" name="name"><br>
		Product Price:<input type="text" name="price"> <br>
		<input type="submit" value="Create">

	</form> --%>
	<c:url value="manage_product_create" var="url"></c:url>
	
	<form:form method="post" action="${url}"
		commandName="createProductObj" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="id">Product Id</form:label></td>
				<td><form:input path="id" disabled="true" class="form-control" />
					<form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Product Description</form:label></td>
				<td><form:input path="description" class="form-control" />
					<form:hidden path="id" /></td>
			</tr>
			
			<tr>
				<td><form:label path="name">Product Name</form:label></td>
				<td><form:input path="name" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Product Price</form:label></td>
				<td><form:input path="price" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="supplier">
				<spring:message text="Supplier"/>
				</form:label></td>
				<td><form:select path="supplier.name" items="${supplierList}" itemValue="name" itemLabel="name" class="form-control"/></td>
				
			</tr>
			<tr>
				<td><form:label path="category">
				<spring:message text="Category"/>
				</form:label></td>
				<td><form:select path="category.name" items="${categoryList}" itemValue="name" itemLabel="name" class="form-control"/></td>
				
			</tr>
			<tr>
				<td><form:label path="image">
						<spring:message text="image" />
					</form:label></td>
				<td><form:input path="image" type="file" /></td>

			</tr>
			

			<tr>
				<td colspan="2"><input type="submit" value="Add Product"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>