<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cliente - Mis Préstamos</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #28a745;
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
            max-width: 1000px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .status-message {
            color: green;
            text-align: center;
            font-size: 18px;
            margin-bottom: 10px;
        }

        .logout-link {
            text-align: center;
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #dc3545;
            text-decoration: none;
        }

        table.dataTable thead th {
            background-color: #28a745;
            color: white;
            padding: 10px;
            text-align: left;
            border-bottom: 2px solid #1e7e34;
        }

        table.dataTable tbody td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        table.dataTable tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table.dataTable tbody tr:hover {
            background-color: #e9e9e9;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button {
            background-color: #007bff;
            color: white !important;
            border: 1px solid #0056b3;
            border-radius: 4px;
            padding: 6px 12px;
            margin: 0 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button:hover {
            background-color: #0056b3;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button.current {
            background-color: #004085;
            border-color: #003d82;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button.disabled {
            background-color: #6c757d;
            border-color: #6c757d;
            cursor: not-allowed;
        }

        .dataTables_wrapper select,
        .dataTables_wrapper input[type="search"] {
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 6px 10px;
        }

        .no-prestamos {
            text-align: center;
            color: #666;
            font-style: italic;
            margin: 20px 0;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Panel de Cliente</h1>
        <div class="user-info">${usuario}</div>
    </div>

    <div class="container">
        <div class="status-message">Login successful USUARIO!</div>
        <a class="logout-link" href="logout">Cerrar sesión</a>

        <h2 style="text-align:center;">Mis Préstamos</h2>

        <c:choose>
            <c:when test="${not empty prestamos}">
                <table id="prestamosTable" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>Nro. Préstamo</th>
                            <th>Fecha</th>
                            <th>Monto</th>
                            <th>Cuotas Totales</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="prestamo" items="${prestamos}">
                            <tr>
                                <td>${prestamo.nroPrestamo}</td>
                                <td><fmt:formatDate value="${prestamo.fechaPrestamo}" pattern="dd/MM/yyyy"/></td>
                                <td>$<fmt:formatNumber value="${prestamo.monto}" type="currency" currencySymbol="" maxFractionDigits="2"/></td>
                                <td>${prestamo.totalCuotas}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${prestamo.activo}">
                                            <span style="color: green; font-weight: bold;">Activo</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: red; font-weight: bold;">Inactivo</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-prestamos">
                    <p>No tienes préstamos registrados.</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            <c:if test="${not empty prestamos}">
                $('#prestamosTable').DataTable({
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "No se encontraron resultados",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "No hay registros disponibles",
                        "infoFiltered": "(filtrado de _MAX_ registros totales)",
                        "search": "Buscar:",
                        "paginate": {
                            "first": "Primero",
                            "last": "Último",
                            "next": "Siguiente",
                            "previous": "Anterior"
                        }
                    }
                });
            </c:if>
        });
    </script>
</body>
</html>