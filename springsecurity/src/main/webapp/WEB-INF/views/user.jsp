<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuario - Préstamos</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #007bff;
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar h1 {
            margin: 0;
            font-size: 24px;
        }

        .navbar .user-info {
            font-size: 18px;
            font-weight: bold;
        }

        .container {
            padding: 20px;
            margin: 20px auto;
            max-width: 1200px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        table.dataTable thead th {
            background-color: #007bff;
            color: white;
            padding: 10px;
            text-align: left;
        }

        table.dataTable tbody td {
            padding: 10px;
        }

        table.dataTable tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table.dataTable tbody tr:hover {
            background-color: #e9e9e9;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Bienvenido Usuario!</h1>
        <div class="user-info">
            <a href="logout" style="color: white;">Cerrar sesión</a>
        </div>
    </div>

    <div class="container">
        <h2>Préstamos del cliente</h2>
        <table id="prestamosTable" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Cliente DNI</th>
                    <th>Monto</th>
                    <th>Cantidad de Cuotas</th>
                    <th>Activo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="prestamo" items="${prestamos}">
                    <tr>
                        <td><c:out value="${prestamo.nroPrestamo}" /></td>
                        <td><c:out value="${prestamo.fechaPrestamo}" /></td>
                        <td><c:out value="${prestamo.cliente.DNI}" /></td>
                        <td><c:out value="${prestamo.monto}" /></td>
                        <td><c:out value="${prestamo.totalCuotas}" /></td>
                        <td><c:out value="${prestamo.activo ? 'Sí' : 'No'}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#prestamosTable').DataTable();
        });
    </script>
</body>
</html>
