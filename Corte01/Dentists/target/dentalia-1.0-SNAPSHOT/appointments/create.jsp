<%@ page import="com.dentalia.dao.PatientsRepository" %>
<%@ page import="com.dentalia.dao.DentistsRepository" %>
<%@ page import="com.dentalia.domain.persistense.Patient" %>
<%@ page import="com.dentalia.domain.persistense.Dentist" %>
<%@ page import="com.dentalia.domain.persistense.User" %>
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
                <h1 class="mt-4">Create Appointment</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Appointments</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">New Appointment</div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/appointments/create" method="post" class="form-group space-y-4">
                            <div>
                                <label for="date" class="form-label">Date</label>
                                <input type="date" id="date" name="date" class="form-control" required>
                            </div>
                            <div>
                                <label for="time" class="form-label">Time</label>
                                <input type="time" id="time" name="time" class="form-control" required>
                            </div>
                            <div>
                                <label for="treatment" class="form-label">Treatment</label>
                                <input type="text" id="treatment" name="treatment" class="form-control" required>
                            </div>
                            <div>
                                <label for="patientId" class="form-label">Patient</label>
                                <select id="patientId" name="patientId" class="form-select" required>
                                    <option value="">-- Select a Patient --</option>
                                    <%
                                        PatientsRepository patientsRepo = PatientsRepository.getInstance();
                                        for (Patient p : patientsRepo.getAll()) {
                                    %>
                                    <option value="<%= p.getId() %>">
                                        <%= p.getFirstName() %> <%= p.getLastName() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div>
                                <label for="dentistId" class="form-label">Dentist</label>
                                <select id="dentistId" name="dentistId" class="form-select" required>
                                    <option value="">-- Select a Dentist --</option>
                                    <%
                                        DentistsRepository dentistRepo = DentistsRepository.getInstance();
                                        for (Dentist d : dentistRepo.getAll()) {
                                            User u = d.getUser();
                                    %>
                                    <option value="<%= d.getId() %>">
                                        <%= u.getName() %>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
</body>
</html>