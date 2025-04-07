<%@ page import="java.util.List" %>
<%@ page import="com.dentalia.domain.persistense.Responsible" %>
<%@ page import="com.dentalia.dao.ResponsibleRepository" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
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
                    <li class="breadcrumb-item active">Responsible</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Responsible
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>dni</th>
                                <th>Birth</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>dni</th>
                                <th>Birth</th>
                                <th></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                ResponsibleRepository responsibleRepository = ResponsibleRepository.getInstance();
                                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                List<Responsible> responsibleList = responsibleRepository.getAll();
                                for (Responsible r : responsibleList) {
                            %>
                            <tr>
                                <td><%=r.getFirstName()%>
                                </td>
                                <td><%=r.getLastName()%>
                                </td>
                                <td>
                                    <%=r.getDni()%>
                                </td>
                                <td>
                                    <%=df.format(r.getBirthDate())%>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <form method="POST" action="responsible/delete">
                                            <input type="hidden" name="id" value="<%=r.getId()%>">
                                            <input type="submit" class="btn btn-danger" value="Delete">
                                        </form>
                                        <form method="POST" action="responsible/edit">
                                            <input type="hidden" name="id" value="<%=r.getId()%>">
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