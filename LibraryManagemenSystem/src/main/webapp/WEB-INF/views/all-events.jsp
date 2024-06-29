<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Event Overview</title>
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
            </style>
        </head>

        <body>
            <div class="container">
                <h2 class="mb-4 text-center">Event Details</h2>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Event Name</th>
                                <th>Start Time</th>
                                <th>End Time</th>
                                <th>Capacity</th>
                                <th>Location</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="event" items="${events}">
                                <tr>
                                    <td>${event.eventName}</td>
                                    <td>${event.startTime}</td>
                                    <td>${event.endTime}</td>
                                    <td>${event.capacity}</td>
                                    <td>${event.location}</td>
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
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </body>

        </html>