<%@ page import="com.dentalia.domain.persistense.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Admin</div>
                <%--        Users        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUsers"
                   aria-expanded="false" aria-controls="collapseUsers">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Users
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseUsers" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/users/create.jsp">Create</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/users.jsp">List</a>
                    </nav>
                </div>
                <%--        Responsibles        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseResponsible"
                   aria-expanded="false" aria-controls="collapseResponsible">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Responsible
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseResponsible" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/responsible/index.jsp">List</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/responsible/create.jsp">Create</a>
                    </nav>
                </div>
                <%--        Patients        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePatients"
                   aria-expanded="false" aria-controls="collapsePatients">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Patients
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapsePatients" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/patients/index.jsp">List</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/patients/create.jsp">Create</a>
                    </nav>
                </div>
                <%--        Schedules        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSchedules"
                   aria-expanded="false" aria-controls="collapseSchedules">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Schedules
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseSchedules" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/schedule/index.jsp">List</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/schedule/create.jsp">Create</a>
                    </nav>
                </div>
                <%--        Dentists        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseDentists"
                   aria-expanded="false" aria-controls="collapseDentists">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Dentitsts
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseDentists" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/dentists/index.jsp">List</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/dentists/create.jsp">Create</a>
                    </nav>
                </div>
                <%--        Appointments        --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseApointments"
                   aria-expanded="false" aria-controls="collapseApointments">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Appointments
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseApointments" aria-labelledby="headingOne"
                     data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/appointments/index.jsp">List</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/appointments/create.jsp">Create</a>
                    </nav>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as: <%= ((User) user).getName()%>
                </div>
                Start Bootstrap
            </div>
        </div>
    </nav>
</div>
