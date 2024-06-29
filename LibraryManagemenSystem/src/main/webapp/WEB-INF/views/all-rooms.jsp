<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room Overview</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Include Bootstrap Datepicker CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
        }

        .container {
            width: 90%;
            margin: auto;
        }

        .table-responsive {
            margin-top: 20px;
        }

        .table-hover tbody tr:hover {
            background-color: #f5f5f5;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        .table th,
        .table td {
            vertical-align: middle;
        }

        .footer-links {
            margin-top: 20px;
        }

        /* Custom row coloring based on room status */
        .available {
            background-color: #dff0d8; /* Green background for available rooms */
        }

        .occupied {
            background-color: #f8d7da; /* Red background for occupied rooms */
        }
    </style>
</head>

<body>
    <div class="container">
        <h2 class="mb-4 text-center">Room Details</h2>
        <!-- Datepicker Input -->
        <form action="/lms/viewallrooms.htm" method="post" id="dateForm">
            <div class="form-group">
                <label for="datepicker">Select Date:</label>
                <input type="text" class="form-control" id="datepicker" name="selectedDate">
                <!-- Submit button -->
                <button type="submit" class="btn btn-primary mt-2">VIEW</button>
            </div>
        </form>

        <!-- Table to Display Room Details -->
        <div class="table-responsive">
            <table class="table table-hover" id="roomTable">
                <thead>
                    <tr>
                        <th>Room Name</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Capacity</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="room" items="${rooms}">
                        <tr class="${room.status == 'Available' ? 'available' : 'occupied'}" >
                            <c:if test="${room.status != 'Available'}"></c:if>
                            
                            <td>${room.roomName}</td>
                            <td>${room.startTime}</td>
                            <td>${room.endTime}</td>
                            <td>${room.capacity}</td>
                            <td>${room.status}</td>
                            <td>
                                <form action="/lms/bookroom.htm" method="post">
                                    <input type="hidden" name="roomName" value="${room.roomName}" />
                                    <button type="submit" class="btn btn-primary" 
                                        <c:if test="${room.status != 'Available'}">disabled="disabled"</c:if>>Book Room</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="footer-links text-center mt-4">
        <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <!-- Include Bootstrap Datepicker JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script>
        // Initialize Datepicker
        $(document).ready(function () {
            $('#datepicker').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true
            });
        });
    </script>
</body>

</html>
