<%@ page import="java.util.Map" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.parcial.parcial1.domain.Reservation" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.parcial.parcial1.application.services.InMemoryReservationService" %>
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

<div class="container d-flex justify-content-center align-items-center" style="height: 80vh;">
    <div class="card p-4" style="width: 100%; max-width: 600px;">
        <h3 class="text-center">Listado de Reservas</h3>
        <table class="table table-striped text-center">
            <thead>
            <tr>
                <th>Email</th>
                <th>Tipo</th>
                <th>Fecha</th>
                <th>Duración</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                // is easier than create a servlet
                Map<UUID, Reservation> reservations = InMemoryReservationService.getInstance().getReservations();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                for (UUID id : reservations.keySet()) {
                    Reservation reserv = reservations.get(id);
                    String date = dateFormat.format(reserv.getReservedDate());

            %>
            <tr>
                <td><%= reserv.getEmail() %>
                </td>
                <td><%= reserv.getOfficeType().getTranslation() %>
                </td>
                <td><%= date %>
                </td>
                <td><%= reserv.getReservedHours() %>h</td>
                <td>
                    <form method="post" action="cancel">
                        <input type="hidden" name="id" value="<%= id.toString() %>">
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>

