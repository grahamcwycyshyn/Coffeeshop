<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Products</h1>
		<table class="table">
			<tr>
				<th scope="row">Name</th>
				<td>${product.name}</td>
			</tr>
			<tr>
				<th scope="row">Description</th>
				<td>${product.description}</td>
			</tr>
			<tr>
				<th scope="row">Price</th>
				<td>${product.price}</td>
			</tr>
		</table>
		<!--  
		<a class="btn btn-secondary" href="/rooms/edit?id=${room.id}">Edit</a>
		<a class="btn btn-danger" href="/rooms/delete?id=${room.id}">Delete</a>
		-->
		<a class="btn link" href="/products">Back to Products</a>
		
		</div>
</body>
</html>