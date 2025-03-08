<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@ page import="com.clase04.domain.Usr" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Home Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">User Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="./index.jsp">Add User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="svUsers">UserList</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1 class="text-center mb-4">Users List</h1>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="list-group">
                <% List<Usr> userLst = (List<Usr>) request.getSession().getAttribute("users");
                    for (Usr u : userLst) { %>
                <div class="list-group-item d-flex justify-content-between align-items-center">
                    <div>
                        <p class="mb-1"><strong>ID:</strong> <%= u.getId() %>
                        </p>
                        <p class="mb-1"><strong>First Name:</strong> <%= u.getFisrtname() %>
                        </p>
                        <p class="mb-1"><strong>Last Name:</strong> <%= u.getLastname() %>
                        </p>
                        <p class="mb-1"><strong>E-mail:</strong> <%= u.getEmail() %>
                        </p>
                    </div>
                    <a href="/svUser/<%= u.getId() %>" class="btn btn-primary mb-2">Edit</a>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
