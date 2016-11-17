<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of users</title>
</head>
<body>
<br/>

<h1>Users</h1>

<c:url var="addUrl" value="/users/add" />
<c:url var="filterUrl" value="/users/filter" />

<table style="border: 2px solid; width: 650px; text-align:center">
    <thead style="">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>isAdmin</th>
        <th>Created Date</th>
        <th colspan="4"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <c:url var="editUrl" value="/users/edit?id=${user.id}" />
        <c:url var="deleteUrl" value="/users/delete?id=${user.id}" />
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.age}" /></td>
            <td><c:out value="${user.admin}" /></td>
            <td><c:out value="${user.date}" /></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
            <td><a href="${addUrl}">Add</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<c:if test="${usersfull.size() > -1}">
    <c:forEach begin="1" end="${count}" var="val">
        <c:url var="pageURL" value="/usersPage?numpage=${val}" />
        <a href="${pageURL}">${val}</a>
    </c:forEach>
</c:if>

<br/>

<c:if test="${empty users}">
    List of users is empty, but you can add someone. <a href="${addUrl}">Add</a> a user.
</c:if>
<br/>

<c>
    You can filter users. <a href="${filterUrl}">Filter</a>.
</c>

<br/>

</body>
</html>
