<!DOCTYPE html>
<html lang="en">
<%@include file="../partials/head.jsp" %>
<body class="sb-nav-fixed">
<%
    Object user = request.getSession().getAttribute("user");
%>
<%@include file="../partials/popup.jsp" %>
<%@include file="../partials/navbar.jsp" %>
<div id="layoutSidenav">
    <%@include file="../partials/sidenav.jsp" %>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Edit User</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Users</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        Edit User
                    </div>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/users/edit"
                              class="form-group space-y-4">
                            <input type="hidden" name="id" value="<%= ((User) user).getId() %>">
                            <div>
                                <label for="name" class="form-label">Name</label>
                                <input type="text" id="name" name="name" value="<%=((User) user).getName()%>"
                                       class="form-control" placeholder="John Doe"
                                       required/>
                            </div>

                            <div>
                                <label for="email" class="form-label">Email</label>
                                <input type="email" id="email" name="email" value="<%=((User) user).getEmail()%>"
                                       class="form-control"
                                       placeholder="john@example.com" required/>
                            </div>

                            <div>
                                <label for="password" class="form-label">Password</label>
                                <input type="password" id="password" name="password" class="form-control" required/>
                            </div>

                            <div>
                                <label for="role" class="form-label">Role</label>
                                <select id="role" name="role" class="form-select" required>
                                    <%
                                        for (User.Role role : User.Role.values()) {
                                    %>
                                    <option value="<%= role %>" <%= ((User) user).getRole() == role ? "selected" : "" %>>
                                        <%= role.name().charAt(0) + role.name().substring(1).toLowerCase() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>

                            <div>
                                <button type="submit" class="btn btn-success w-100">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="../partials/footer.jsp" %>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
</body>
</html>