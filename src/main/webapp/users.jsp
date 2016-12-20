<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>User list</h2>
    <a href="users?action=create">Add user</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>e-mail</th>
            <th>CPD</th>
            <th>enabled</th>
            <th>Roles</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" scope="page" type="ru.javawebinar.topjava.model.User"/>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.caloriesPerDay}</td>
                <td>${user.enabled}</td>
                <td>919</td>
                <td><a href="users?action=update&id=${user.id}">Update</a></td>
                <td><a href="users?action=delete&id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
