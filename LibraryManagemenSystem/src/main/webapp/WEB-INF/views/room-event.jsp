<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Booking Options</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }
        .hero-image {
            background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('your-image-url.jpg');
            height: 50%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }
        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }
        .booking-button {
            padding: 10px 20px;
            background-color: #f8f9fa;
            border: none;
            color: black;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .booking-button:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1>Library Booking Services</h1>
        <p>Select an option below to proceed</p>
        <a href="/lms/viewallrooms.htm" class="booking-button">View All Rooms</a>
        <a href="/lms/bookroom.htm" class="booking-button">Book a Room</a>
        <a href="/lms/viewallevents.htm" class="booking-button">View All Events</a>
        <a href="/lms/bookevent.htm" class="booking-button">Book an Event</a>
        <a href="/lms/welcome.htm" class="btn btn-primary action-button">Home Page</a>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
