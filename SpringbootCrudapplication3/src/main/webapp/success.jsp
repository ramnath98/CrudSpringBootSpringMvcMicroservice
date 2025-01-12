<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="logout">Logout</a>

<table border="2">
<tr>
<th>Rollno</th>
<th>Name</th>
<th>username</th>
<th>password</th>
<th>ACTION</th>


</tr>

<c:forEach items="${data}" var="s">

<tr>
<td>${s.rollno}</td>
<td>${s.name}</td>
<td>${s.username}</td>
<td>${s.password}</td>

<td><a href="delete?rollno=${s.rollno}">Delete</a> || <a href="edit?rollno=${s.rollno}">Edit</a></td>
</tr>
</c:forEach>
</table>

<a href="paging?pageNo=0">1</a>||<a href="paging?pageNo=1">2</a>||<a href="paging?pageNo=3">4</a>

</body>
</html>