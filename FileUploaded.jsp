<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Files in Database</title>
</head>
<body>
		<h1>${fileName}</h1>
		<br>
		<br>
<table border="1">
  <tr><th>File Name</th>
  <th>File Path</th>
  <th>Delete</th>
  </tr>
  
  <c:forEach items="${file}" var="entry">
  <tr>
    <td>${entry.name}</td> 
    <td>${entry.path}</td>
    <td><a href="Delete?id=${entry.id}">Delete</a></td>
  </tr>
</c:forEach>
<p><a href="FileManagerMainPage">Return to Main Page</a></p>
</body>
</html>