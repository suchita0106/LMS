<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Library Management System - Login</title>
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
      <style>
        .form-control {
          margin-bottom: 15px;
        }

        .error {
          color: red;
          font-style: italic;
        }
      </style>
    </head>

    <body>
      <div class="container mt-5">
        <div class="row justify-content-center">
          <div class="col-md-6">
            <div class="card">
              <div class="card-header bg-primary text-white">
                <h3 class="text-center">User Login</h3>
              </div>
              <div class="card-body">
                <form:form modelAttribute="user" class="form-horizontal" action="login.htm" method="post">
                  <form:errors path="*" class="alert alert-danger" />
                  <div class="form-group">
                    <label for="username" class="control-label">Username:</label>
                    <form:input path="username" id="username" class="form-control" placeholder="Enter username" />
                    <form:errors path="username" cssClass="error" />
                  </div>
                  <div class="form-group">
                    <label for="password" class="control-label">Password:</label>
                    <form:input path="password" id="password" type="password" class="form-control"
                      placeholder="Enter password" />
                    <form:errors path="password" cssClass="error" />
                  </div>
                  <div class="form-group">
                    <input type="hidden" name="roomName" value="${room.roomName}" />
                    <button type="submit" class="btn btn-success">Login</button>
                  </div>

                </form:form>

                <div class="text-center">
                  <p>New User? Sign up <a href="/lms/userregister.htm" class="btn btn-link">Sign up</a></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>