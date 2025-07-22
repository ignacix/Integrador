<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - Usuarios</title>
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
            background-color: #007bff;
            color: white;
            padding: 10px;
            text-align: left;
            border-bottom: 2px solid #0056b3;
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
            background-color: #28a745;
            color: white !important;
            border: 1px solid #218838;
            border-radius: 4px;
            padding: 6px 12px;
            margin: 0 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button:hover {
            background-color: #218838;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button.current {
            background-color: #1e7e34;
            border-color: #1c7430;
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
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Panel de Administración</h1>
        <div class="user-info">Admin</div>
    </div>

    <div class="container">
        <div class="status-message">Login successful ADMIN!</div>
        <a class="logout-link" href="logout">Cerrar sesión</a>

        <h2 style="text-align:center;">Lista de Usuarios</h2>

        <table id="usuariosTable" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Contraseña</th>
                </tr>
            </thead>
            <tbody>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.DNI}</td>
            <td>${cliente.nombre} ${cliente.apellido}</td>
            <td>${cliente.email}</td>
        </tr>
    </c:forEach>
</tbody>
        </table>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#usuariosTable').DataTable();
        });
    </script>
</body>
</html>
