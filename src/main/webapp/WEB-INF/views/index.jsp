<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="/temp.css" rel="stylesheet" /> 
</head>
<body>
<div class="container">
		<h1>Welcome to Graham's Coffee Shop!</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Product</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
				<tr>
					<td><a href="/products/detail?id=${product.id}">${product.name}</a></td>
					<td>${product.description}</td>
					<td>$${product.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/register" class="btn btn-secondary">Register</a>
	
	</div>
</body>
</html>