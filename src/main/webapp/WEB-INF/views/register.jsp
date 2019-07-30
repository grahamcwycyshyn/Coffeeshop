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
		<h1>Register</h1>
		
		<form action="/register" method="post">
		<table class="table">
			<tr>
				<th scope="row">Id</th>
				<td><input type="text" name="id" autofocus/></td>
			</tr>
			<tr>
				<th scope="row">Name</th>
				<td><input type="text" name="name" autofocus/></td>
			</tr>
			<tr>
				<th scope="row">Username</th>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<th scope="row">Password</th>
				<td>
					<input type="text" name="password" /></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-primary" href="/register">Register</button>
		<a class="btn link" href="/products">Cancel</a>
		</form>
	</div>
</body>
</html>