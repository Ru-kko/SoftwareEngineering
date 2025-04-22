<%@ page import="java.util.List" %>
<%@ page import="com.dentalia.dao.PatientsRepository" %>
<%@ page import="com.dentalia.domain.persistense.Patient" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../partials/head.jsp" %>
<body class="sb-nav-fixed">
<%
    Object user = request.getSession().getAttribute("user");
%>
<%@include file="../partials/navbar.jsp" %>
<div id="layoutSidenav">
    <%@include file="../partials/sidenav.jsp" %>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Patients</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Dashboard</a></li>
                    <li class="breadcrumb-item active">Patients</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Patient List
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Birth Date</th>
                                <th>Responsible</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Birth Date</th>
                                <th>Responsible</th>
                                <th></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                PatientsRepository patientsRepository = PatientsRepository.getInstance();
                                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                List<Patient> patientsList = patientsRepository.getAll();
                                for (Patient p : patientsList) {
                            %>
                            <tr>
                                <td><%=p.getFirstName()%></td>
                                <td><%=p.getLastName()%></td>
                                <td><%=df.format(p.getBirthDate())%></td>
                                <td>
                                    <%=p.getResponsible() != null ? p.getResponsible().getFirstName() + " " + p.getResponsible().getLastName() : "N/A"%>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <form method="POST" action="patients/delete">
                                            <input type="hidden" name="id" value="<%=p.getId()%>">
                                            <input type="submit" class="btn btn-danger" value="Delete">
                                        </form>
                                    </div>
                                </td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="../partials/footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
</body>
</html>