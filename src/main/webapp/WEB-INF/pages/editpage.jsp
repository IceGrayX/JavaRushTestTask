<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit user</title>
</head>
<body>

<h1>Edit user</h1>
<c:url var="saveUrl" value="/users/edit?id=${userAttribute.id}"/>

<form:form method="POST" commandName="userAttribute" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">ID:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="age">Age:</form:label></td>
            <td><form:input path="age"/></td>
        </tr>

        <tr>
            <td><form:label path="Admin">is Admin:</form:label></td>
            <td><form:input path="Admin"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
