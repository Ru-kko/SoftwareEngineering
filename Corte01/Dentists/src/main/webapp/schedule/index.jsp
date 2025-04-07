<%@ page import="java.util.List" %>
<%@ page import="com.dentalia.dao.ScheduleRepository" %>
<%@ page import="com.dentalia.domain.persistense.Schedule" %>
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
                <h1 class="mt-4">Tables</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">Schedules</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        DataTable Example
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Start Hour</th>
                                <th>End Hour</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Start Hour</th>
                                <th>End Hour</th>
                                <th>Delete</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                ScheduleRepository scheduleDto = ScheduleRepository.getInstance();

                                List<Schedule> schedules = scheduleDto.getAll();
                                for (Schedule s : schedules) {
                            %>
                            <tr>
                                <td>
                                    <%=s.getStartHour().getHour()%>:
                                    <%=s.getStartHour().getMinute()%>
                                </td>
                                <td>
                                    <%=s.getEndHour().getHour()%>:
                                    <%=s.getEndHour().getMinute()%>
                                </td>
                                <td>
                                    <form method="POST" action="${pageContext.request.contextPath}/schedule/delete">
                                        <input type="hidden" name="id" value="<%=s.getId()%>">
                                        <input type="submit" class="btn btn-danger" value="Delete">
                                    </form>
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
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                crossorigin="anonymous"></script>
</body>
</html>
