<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile - Library Management System</title>
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

        .error {
            color: red;
            font-style: italic;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <h2>Update Profile</h2>
        <form:form modelAttribute="userProfile" class="form-horizontal">
                            <form:errors path="*" class="alert alert-danger" />
                            <!-- Fields for UserAccount nested within UserProfile -->
                            <div class="form-group">
                                <label for="username" class="control-label">Username:</label>
                                <form:input path="userAccount.username" id="username" class="form-control" placeholder="Enter username" />
                                <form:errors path="userAccount.username" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label">Password:</label>
                                <form:input path="userAccount.password" type="password" class="form-control" placeholder="Enter password" />
                                <form:errors path="userAccount.password" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="role" class="control-label">Role:</label>
                                <form:input path="userAccount.role" class="form-control" placeholder="Enter role (e.g., Admin, Student)" />
                                <form:errors path="userAccount.role" cssClass="error" />
                            </div>
                            <!-- Fields for UserProfile -->
                            <div class="form-group">
                                <label for="fname" class="control-label">First Name:</label>
                                <form:input path="fname" class="form-control" placeholder="Enter First Name" />
                                <form:errors path="fname" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="lname" class="control-label">Last Name:</label>
                                <form:input path="lname" class="form-control" placeholder="Enter Last Name" />
                                <form:errors path="lname" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="address" class="control-label">Address:</label>
                                <form:input path="address" class="form-control" placeholder="Enter Address" />
                                <form:errors path="address" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="mobno" class="control-label">Mobile No:</label>
                                <form:input path="mobno" class="form-control" placeholder="Enter Mobile No" />
                                <form:errors path="mobno" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">Update</button>
                            </div>
                        </form:form>
        <div class="footer-links text-center mt-4">
            <a href="/lms/viewprofile.htm" class="btn btn-primary">View Profile</a>
            <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
        </div>
    </div>
</body>

</html>
