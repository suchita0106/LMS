<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>View Profile - Library Management System</title>
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
            <div class="container mt-5">
                <h2>User Profile</h2>
                <table class="table table-bordered">
                    <tr>
                        <th>Username</th>
                        <td>${user.userAccount.username}</td>
                    </tr>
                    <tr>
                        <th>First Name</th>
                        <td>${user.fname}</td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td>${user.lname}</td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>${user.address}</td>
                    </tr>
                    <tr>
                        <th>Mobile Number</th>
                        <td>${user.mobno}</td>
                    </tr>
                    <tr>
                        <th>Role</th>
                        <td>${user.userAccount.role}</td>
                    </tr>
                </table>
                <div class="footer-links text-center mt-4">
                    <a href="/lms/updateuser.htm" class="btn btn-primary">Edit Profile</a>
                    <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
                </div>
            </div>
        </body>

        </html>