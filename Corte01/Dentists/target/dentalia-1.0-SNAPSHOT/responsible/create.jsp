<%@ page import="java.time.LocalDate" %>
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
                <h1 class="mt-4">Create Responsible</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Responsible</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        New Responsible
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/responsible/create" method="post"
                              class="form-group space-y-4">
                            <div>
                                <label for="firstName" class="form-label">First Name</label>
                                <input type="text" id="firstName" name="firstName" class="form-control"
                                       placeholder="John" required />
                            </div>

                            <div>
                                <label for="lastName" class="form-label">Last Name</label>
                                <input type="text" id="lastName" name="lastName" class="form-control"
                                       placeholder="Doe" required />
                            </div>

                            <div>
                                <label for="dni" class="form-label">DNI</label>
                                <input type="text" id="dni" name="dni" class="form-control"
                                       placeholder="12345678" required />
                            </div>
                            <%
                                LocalDate todayMinus18 = LocalDate.now().minusYears(18);
                            %>
                            <div>
                                <label for="birthDate" class="form-label">Birth Date</label>
                                <input type="date" id="birthDate" name="birthDate" class="form-control"
                                       max="<%= todayMinus18 %>" required />
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