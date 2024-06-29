<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Available Rooms</title>
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
            <style>
                .room-item {
                    margin-bottom: 10px;
                }

                .footer-links {
                    margin-top: 20px;
                }
            </style>
        </head>

        <body>
            <div class="container mt-5">
                <h2 class="mb-3">Book a Room</h2>
                <div class="list-group">
                    <c:forEach var="room" items="${rooms}">
                        <div class="list-group-item d-flex justify-content-between align-items-center room-item">
                            <div>
                                <h5 class="mb-1">${room.roomName}</h5>
                                <small>Capacity: ${room.capacity}</small>
                            </div>
                            <!-- Each button is now within its own form -->
                            <form action="/lms/bookroomsubmit.htm" method="post">
                                <input type="hidden" name="roomName" value="${room.roomName}" />
                                <button type="submit" class="btn btn-primary">Book</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="footer-links text-center mt-4">
                <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
            </div>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </body>

        </html>