<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
rollno : <input type="text" name="rollno" value="${stu.rollno}"><br><br>
name : <input type="text" name="name" value="${stu.name}"><br><br>
username : <input type="text" name="username" value="${stu.username}"><br><br>
password : <input type="text" name="password" value="${stu.password}"><br><br>
<input type="submit" value="update">
</form>
</body>
</html>