<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Offices</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Offices</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Reservar</a></li>
                <li class="nav-item"><a class="nav-link" href="reservations.jsp">Ver Listado</a></li>
            </ul>
        </div>
    </div>
</nav>
<%
    // Find attribute to render a modal
    String errorMessage = (String) session.getAttribute("error_message");
    if (errorMessage != null) {
        session.removeAttribute("error_message");
%>
<div class="modal fade" id="errorModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Error</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p><%= errorMessage %>
                </p>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        let errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
        errorModal.show();
        setTimeout(() => errorModal.hide(), 1000);
    });
</script>
<%
    }
%>
<div class="container d-flex justify-content-center align-items-center" style="height: 80vh;">
    <div class="card p-4" style="max-width: 400px; width: 100%;">
        <h3 class="text-center">Reservar Oficina</h3>
        <form action="reservation-servlet" method="post">
            <div class="mb-3">
                <label class="form-label" for="email">Email</label>
                <input id="email" type="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label" for="type">Tipo de Oficina</label>
                <select name="type" id="type" class="form-select" required>
                    <option value="DESKTOP">Escritorio</option>
                    <option value="METING_OFFICE">Oficina de Reuniones</option>
                    <option value="PRIVATE_OFFICE">Oficina Privada</option>
                </select>
            </div>
            <div class="mb-3">
                <%
                    Date today = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("yyy-MM-dd");
                    String todayValue = formater.format(today);
                %>
                <label class="form-label" for="date">Fecha</label>
                <input type="date" name="date" id="date" class="form-control" min="<%= todayValue %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label" for="hours">Duración (Horas)</label>
                <input name="hours" id="hours" type="number" class="form-control" min="1" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Reservar</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>