<%@ page import="com.dentalia.dao.AppointmentRepository" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.dentalia.domain.persistense.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
            <div class="container-fluid px-4">
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
                                List<Appointment> appointmentList;

                                if (((User) user).getRole() == User.Role.ADMIN) {
                                    appointmentList = appointmentRepository.getAppointmentsForToday();
                                } else {
                                    appointmentList = appointmentRepository.getAppointmentsForTodayByUser(((User) user).getId());
                                }

                                for (Appointment a : appointmentList) {
                            %>
                            <tr>
                                <td><%= dateFormat.format(a.getDate()) %>
                                </td>
                                <td><%= a.getTime().toString() %>
                                </td>
                                <td><%= a.getTreatment() %>
                                </td>
                                <td><%= a.getPatient().getFirstName() %> <%= a.getPatient().getLastName() %>
                                </td>
                                <td><%= a.getDentist().getUser().getName() %>
                                </td>
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
        <%@include file="./partials/footer.jsp" %>
    </div>
</div>
<% } else { %>
<%@include file="./partials/popup.jsp" %>
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
<script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
</body>
</html>