<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Library Management System - Add/Update an Event</title>
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
            <style>
                .form-control {
                    margin-bottom: 15px;
                }

                .error {
                    color: red;
                    font-style: italic;
                }

                /* Additional styles to enhance form appearance */
                .container {
                    max-width: 800px;
                    margin-top: 20px;
                }

                .card {
                    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                    transition: 0.3s;
                }

                .card:hover {
                    box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
                }

                .footer-links {
                    margin-top: 20px;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <div class="card">
                    <div class="card-header bg-primary text-white text-center">
                        <h3>Add an Event</h3>
                    </div>
                    <div class="card-body">
                        <form:form modelAttribute="event" class="form-horizontal">
                            <form:errors path="*" class="alert alert-danger" />
                            <div class="form-group">
                                <label for="eventName" class="control-label">Event Name:</label>
                                <form:input path="eventName" id="eventName" class="form-control"
                                    placeholder="Enter Event Name" />
                                <form:errors path="eventName" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="startTime" class="control-label">Start Time:</label>
                                <form:input path="startTime" id="startTime" type="datetime-local" class="form-control"
                                    placeholder="Enter Start Time" />
                                <form:errors path="startTime" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="endTime" class="control-label">End Time:</label>
                                <form:input path="endTime" id="endTime" type="datetime-local" class="form-control"
                                    placeholder="Enter End Time" />
                                <form:errors path="endTime" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="capacity" class="control-label">Capacity:</label>
                                <form:input path="capacity" id="capacity" type="number" class="form-control"
                                    placeholder="Enter Capacity" />
                                <form:errors path="capacity" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="location" class="control-label">Location:</label>
                                <form:input path="location" id="location" class="form-control" placeholder="Enter Location" />
                                <form:errors path="location" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="footer-links text-center mt-4">
                <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
            </div>
        </body>

        </html>