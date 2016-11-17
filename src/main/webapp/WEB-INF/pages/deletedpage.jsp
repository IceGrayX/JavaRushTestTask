<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User was deleted</title>
</head>
<body>

<p>You have deleted a user with id ${id} at <%= new Date() %></p>

<br/>

<c:url var="mainUrl" value="/users" />

<p>Return to <a href="${mainUrl}">Main List</a></p>

</body>
</html>
