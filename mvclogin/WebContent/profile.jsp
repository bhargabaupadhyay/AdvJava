<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	Welcome ${user.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="LogoutAction">Logout</a>
	<br/><br/><br/>
	${message }
	<form action="EditProfileAction" method="post">
	<input type="hidden" name="username" value="${user.username }">
	Age is : <input type="text" name="name" value="${user.name }"><br/>
	Password is : <input type="password" name="password" value="${user.password }"><br/>
	Salary : <input type="number" name="salary" value="${user.salary }">
	Age : <input type="number" name="age" value="${user.age }">
	<br/>
	<input type="submit" value="Update">
	</form>
	
	
</body>
</html>