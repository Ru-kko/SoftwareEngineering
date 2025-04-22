<%@ page import="com.dentalia.domain.util.Specialization" %>
<%@ page import="com.dentalia.dao.DentistsRepository" %>
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
                <h1 class="mt-4">Create Dentist</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Dentist</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        New Dentists
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/dentists/create" method="post"
                              class="form-group space-y-4">
                            <div>
                                <label for="specialization" class="form-label">Sepecialization</label>
                                <select id="specialization" name="specialization" class="form-select" required>
                                    <%
                                        for (Specialization sepe : Specialization.values()) {
                                    %>
                                    <option value="<%= sepe %>"><%= sepe.beautify() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div>
                                <label for="user" class="form-label">User</label>
                                <select id="user" name="user" class="form-select" required>
                                    <%
                                        DentistsRepository dentistsRepository = DentistsRepository.getInstance();
                                        for (User u : dentistsRepository.getUnassignedUsers()) {
                                    %>
                                    <option value="<%= u.getId().toString() %>"><%= u.getName() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div>
                                <button type="submit" class="btn btn-success w-100">Create</button>
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