<!DOCTYPE html>
<html lang="en">
<%@include file="../partials/head.jsp" %>
<body class="sb-nav-fixed">
<%
    Object user = request.getSession().getAttribute("user");
%>
<%@include file="../partials/popup.jsp"%>
<%@include file="../partials/navbar.jsp" %>
<div id="layoutSidenav">
    <%@include file="../partials/sidenav.jsp" %>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Create Schedule</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Schedules</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        New Schedule
                    </div>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/schedule/create">
                            <div class="mb-3">
                                <label for="startHour" class="form-label">Start Hour</label>
                                <input type="time" class="form-control" id="startHour" name="startHour">
                            </div>
                            <div class="mb-3">
                                <label for="endHour" class="form-label">End Hour</label>
                                <input type="time" class="form-control" id="endHour" name="endHour">
                            </div>
                            <button type="submit" class="btn btn-success">Create</button>
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
