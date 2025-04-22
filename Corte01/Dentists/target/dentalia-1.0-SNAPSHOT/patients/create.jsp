<%@ page import="com.dentalia.domain.persistense.Responsible" %>
<%@ page import="com.dentalia.dao.ResponsibleRepository" %>
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
                <h1 class="mt-4">Create Patient</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="../">Dashboard</a></li>
                    <li class="breadcrumb-item active">Patient</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">New Patient</div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/patients/create" method="post" class="form-group space-y-4">
                            <div>
                                <label for="firstName" class="form-label">First Name</label>
                                <input type="text" id="firstName" name="firstName" class="form-control" required>
                            </div>
                            <div>
                                <label for="lastName" class="form-label">Last Name</label>
                                <input type="text" id="lastName" name="lastName" class="form-control" required>
                            </div>
                            <div>
                                <label for="birthDate" class="form-label">Birth Date</label>
                                <input type="date" id="birthDate" name="birthDate" class="form-control" required>
                            </div>
                            <div id="responsible-container" style="display: none;">
                                <label for="responsibleId" class="form-label">Responsible</label>
                                <select id="responsibleId" name="responsibleId" class="form-select">
                                    <option value="">-- Select a Responsible --</option>
                                    <%
                                        ResponsibleRepository repo = ResponsibleRepository.getInstance();
                                        for (Responsible r : repo.getAll()) {
                                    %>
                                    <option value="<%= r.getId().toString() %>">
                                        <%= r.getFirstName() + " " + r.getLastName() %>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                                <div class="form-text">Required for patients under 18.</div>
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

<script>
    const birthDateInput = document.getElementById("birthDate");
    const responsibleContainer = document.getElementById("responsible-container");

    function checkAge() {
        const birthDate = new Date(birthDateInput.value);
        const today = new Date();
        const age = today.getFullYear() - birthDate.getFullYear();
        const isBeforeBirthday = today.getMonth() < birthDate.getMonth() ||
            (today.getMonth() === birthDate.getMonth() && today.getDate() < birthDate.getDate());

        if (birthDateInput.value && (age < 18 || (age === 18 && isBeforeBirthday))) {
            responsibleContainer.style.display = "block";
        } else {
            responsibleContainer.style.display = "none";
        }
    }

    birthDateInput.addEventListener("change", checkAge);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
</body>
</html>