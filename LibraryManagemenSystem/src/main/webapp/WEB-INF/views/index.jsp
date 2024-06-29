<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Library Management System</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body, html {
      height: 100%;
      margin: 0;
      font-family: Arial, sans-serif;
    }
    .bg-image {
      /* The image used */
      background-image: url("https://source.unsplash.com/featured/?library");
      
      /* Full height */
      height: 100%;

      /* Center and scale the image nicely */
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
    }
    .overlay-text {
      background: rgba(0, 0, 0, 0.5); /* Black background with transparency */
      color: white;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      z-index: 2;
      width: 80%;
      padding: 20px;
      text-align: center;
    }

    /* Custom Button Styles */
    .btn-custom-login {
        background-color: #3498db; /* blue */
        border: 1px solid #2980b9;
    }
    .btn-custom-login:hover {
        background-color: #2980b9; /* dark blue */
    }

    .btn-custom-console {
        background-color: #2ecc71; /* green */
        border: 1px solid #27ae60;
    }
    .btn-custom-console:hover {
        background-color: #27ae60; /* dark green */
    }

    .btn-custom-logout {
        background-color: #f39c12; /* orange */
        border: 1px solid #d35400;
    }
    .btn-custom-logout:hover {
        background-color: #d35400; /* dark orange */
    }

    .btn-custom-register {
        background-color: #f382ed; /* orange */
        border: 1px solid #f382ed;
    }
    .btn-custom-register:hover {
        background-color: #f382ed; /* dark orange */
    }
</style>

</head>
<body>
  <div class="bg-image">
    <div class="overlay-text">
        <h1>Welcome to the Library Management System</h1>
        <p>Explore our vast collection of books and manage your library account.</p>
        <a href="/lms/userlogin.htm" class="btn btn-custom-login">Login</a>
        <a href="/lms/console.htm" class="btn btn-custom-console">Console</a>
        <a href="/lms/logout.htm" class="btn btn-custom-logout">Logout</a>
    </div>
</div>


  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
