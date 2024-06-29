<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success - Library Management System</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding-top: 50px;
            }

            .container {
                max-width: 600px;
            }

            .footer-links {
                margin-top: 20px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1 class="display-4">Success</h1>
            <p class="lead">Welcome to the Library Management System.</p>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">User Information</h5>
                    <p class="card-text"><strong>UserName:</strong> ${requestScope.user.userAccount.username}</p>
                    <p class="card-text"><strong>First Name:</strong> ${requestScope.user.fname}</p>
                    <p class="card-text"><strong>Last Name:</strong> ${requestScope.user.lname}</p>
                    <p class="card-text"><strong>Address:</strong> ${requestScope.user.address}</p>
                    <p class="card-text"><strong>Mob No.:</strong> ${requestScope.user.mobno}</p>
                    <p class="card-text"><strong>Role:</strong> ${requestScope.user.userAccount.role}</p>
                </div>
            </div>
            <div class="footer-links text-center mt-4">
                <a href="/lms/userlogin.htm" class="btn btn-primary">Login Page</a>
                <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
            </div>
        </div>
        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>