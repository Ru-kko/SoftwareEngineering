<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@ page import="com.app.domain.User" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
</head>
<body>
    <h1>Users List</h1>
    <%
        List<User> userLst = (List<User>) request.getSession().getAttribute("users");
        for (User u : userLst) {
    %>
        <div>
            <p><b>ID: </b> <%= u.getId() %></p>
            <p><b>FirstName: </b> <%= u.getFirstName() %></p>
            <p><b>Last Name: </b> <%= u.getLastName() %></p>
        </div>
        <hr>
    <% } %>

</body>
</html>
