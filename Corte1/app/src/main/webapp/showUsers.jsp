<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@ page import="com.clase04.domain.Usr" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
</head>
<body>
<h1>Users List</h1>
<%
    List<Usr> userLst = (List<Usr>) request.getSession().getAttribute("users");
    for (Usr u : userLst) {
%>
<div>
    <p><b>ID: </b> <%= u.getId() %></p>
    <p><b>FirstName: </b> <%= u.getFisrtname() %></p>
    <p><b>Last Name: </b> <%= u.getLastname() %></p>
</div>
<hr>
<% } %>

</body>
</html>
