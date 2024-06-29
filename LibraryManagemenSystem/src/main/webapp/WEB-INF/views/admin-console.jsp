<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Administration Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: 'Arial', sans-serif;
        }
        .hero-image {
            background-image: url('https://source.unsplash.com/1600x900/?library');
            height: 100vh;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .hero-text {
            text-align: center;
            color: white;
            width: 100%;
            background: rgba(0, 0, 0, 0.5); /* Black background with transparency */
            padding: 20px;
        }
        .action-button {
            margin: 10px;
            width: 250px; /* Fixed width, you can adjust as per your need */
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .action-button:hover {
            background-color: #ddd; /* Light grey background on hover */
            color: black;
        }

        .btn-custom-color {
    background-color: #FFA500; /* Bright Orange */
    color: white; /* Ensures the text is readable */
}

.btn-custom-colort {
    background-color: #008080; 
    color: white; /* Ensures the text is readable */
}

.btn-custom-colorr {
    background-color: #671304; /* Bright Orange */
    color: white; /* Ensures the text is readable */
}

.btn-custom-colorp {
    background-color: #1f0256; /* Bright Orange */
    color: white; /* Ensures the text is readable */
}
    </style>
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1>Library Administration Dashboard</h1>
        <p>Select an action to proceed:</p>
        <a href="/request/approvebook.htm" class="btn btn-primary action-button">Approve Borrow Book Request</a>
        <a href="/lms/new.htm" class="btn btn-primary action-button">Add Book</a>
        <a href="/request/adminreq.htm" class="btn btn-primary action-button">My Requests</a>

    </br>
</br>    

        <a href="/lms/uploadebook.htm" class="btn btn-custom-colort action-button">Upload e-Book</a>
        <a href="/lms/downloadebook.htm" class="btn btn-custom-colort action-button">Download e-Book</a>

        <a href="/lms/bookevent.htm" class="btn btn-custom-colort action-button">Create an Event</a>
        <a href="/lms/viewallevents.htm" class="btn btn-custom-colort action-button">View All Events</a>
    </br>
</br>    
        <a href="/lms/createroom.htm" class="btn btn-custom-color action-button">Create a Room</a>
        <a href="/lms/bookroom.htm" class="btn btn-custom-color action-button">Book a Room</a>
        <a href="/lms/viewallrooms.htm" class="btn btn-custom-color action-button">View All Rooms</a>

    </br>
</br>    
        <a href="/lms/welcome.htm" class="btn btn-custom-colorp action-button">Home Page</a>
        <a href="/lms/logout.htm" class="btn btn-danger action-button">Logout</a>
        <a href="/lms/viewprofile.htm" class="btn btn-custom-colorp action-button">View Profile</a>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
