<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Booked Room Details</title>
                <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                <style>
                    .container {
                        padding-top: 50px;
                    }

                    .detail-heading {
                        background-color: #007bff;
                        color: white;
                        padding: 10px 0;
                        font-size: 24px;
                    }

                    .detail-text {
                        font-size: 18px;
                        padding: 10px 0;
                    }

                    .footer-links {
                        margin-top: 20px;
                    }
                </style>
            </head>

            <body>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 offset-md-2">
                            <div class="detail-heading text-center">Booked Room Details</div>
                            <div class="detail-text"><strong>Room Name:</strong> ${room.roomName}</div>
                            <div class="detail-text"><strong>Start Time:</strong>
                                <fmt:formatDate value="${room.startTime}" pattern="dd/MM/yyyy HH:mm" />
                            </div>
                            <div class="detail-text"><strong>End Time:</strong>
                                <fmt:formatDate value="${room.endTime}" pattern="dd/MM/yyyy HH:mm" />
                            </div>
                            <div class="detail-text"><strong>Capacity:</strong> ${room.capacity}</div>
                            <div class="detail-text"><strong>Status:</strong> ${room.status}</div>
                        </div>
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