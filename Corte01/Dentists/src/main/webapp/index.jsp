<!DOCTYPE html>
<html lang="en">
<%@include file="./partials/head.jsp" %>
<body class="sb-nav-fixed">

<%
    Object user = request.getSession().getAttribute("user");

    if (user != null) {
%>
<%@include file="./partials/navbar.jsp" %>
<div id="layoutSidenav">
    <%@include file="./partials/sidenav.jsp" %>
    <div id="layoutSidenav_content">
        <main>
            <h1>Hello World</h1>
        </main>
        <%@include file="./partials/footer.jsp" %>
    </div>
</div>
<% } else { %>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand ps-3" href="index.jsp">Dentalia</a>
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
    </form>
</nav>
<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-dark text-white">Login</div>
                    <div class="card-body">
                        <form action="login" method="POST">
                            <div class="mb-3">
                                <label for="email" class="form-label">E-mail</label>
                                <input type="email" id="email" name="email" class="form-control"
                                       placeholder="Enter your E-mail">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" id="password" name="password" class="form-control"
                                       placeholder="Enter your E-mail">
                            </div>
                            <button type="submit" class="btn btn-success w-100">LogIn</button>
                        </form>
                        <div class="mt-3 text-center">
                            <span class="text-muted">- or -</span>
                            <br>
                            <a href="signup.jsp" class="btn btn-link">SignUp</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</body>
</html>