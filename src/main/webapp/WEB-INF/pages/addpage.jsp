<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding new user</title>
</head>
<body>

<h1>Create new User</h1>

<c:url var="saveUrl" value="/users/add" />

<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr><form:hidden path="id" value="${userAttribute.id}"/></tr>
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
