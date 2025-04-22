<%@ page import="java.util.List" %>
<%@ page import="com.dentalia.dao.AppointmentRepository" %>
<%@ page import="com.dentalia.domain.persistense.Appointment" %>
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
                <h1 class="mt-4">Appointments</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Dashboard</a></li>
                    <li class="breadcrumb-item active">Appointments</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-calendar-alt me-1"></i>
                        Appointment List
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Treatment</th>
                                <th>Patient</th>
                                <th>Dentist</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Treatment</th>
                                <th>Patient</th>
                                <th>Dentist</th>
                                <th></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                AppointmentRepository appointmentRepository = AppointmentRepository.getInstance();
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                List<Appointment> appointmentList = appointmentRepository.getAll();

                                for (Appointment a : appointmentList) {
                            %>
                            <tr>
                                <td><%= dateFormat.format(a.getDate()) %></td>
                                <td><%= a.getTime().toString() %></td>
                                <td><%= a.getTreatment() %></td>
                                <td><%= a.getPatient().getFirstName() %> <%= a.getPatient().getLastName() %></td>
                                <td><%= a.getDentist().getUser().getName() %></td>
                                <td>
                                    <div class="btn-group">
                                        <form method="POST" action="appointments/delete">
                                            <input type="hidden" name="id" value="<%= a.getId() %>">
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