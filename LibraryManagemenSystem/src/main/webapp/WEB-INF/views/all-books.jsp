<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>All Books</title>
                <!-- Bootstrap CSS -->
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                    <h1 class="mt-4">All Books</h1>
                    <table class="table table-striped mt-4">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Quantity</th>
                                <th>Action</th> <!-- Added column for the action button -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${bookList}" var="book">
                                <tr>
                                    <td>${book.id}</td>
                                    <td>${book.title}</td>
                                    <td>${book.author}</td>
                                    <td>${book.quantity}</td>
                                    <td>
                                        <form action="/lms/books/bookdetails" method="post">
                                            <input type="hidden" name="bookId" value="${book.id}">
                                            <button type="submit" class="btn btn-primary">Request</button>
                                        </form>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="footer-links text-center mt-4">
                        <a href="/lms/welcome.htm" class="btn btn-primary">Home</a>
                        <a href="/lms/downloadebook.htm" class="btn btn-primary action-button">Download e-Book</a>
                        <a href="/lms/logout.htm" class="btn btn-danger">Logout</a>
                </div>

                <!-- Bootstrap JS and dependencies -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </body>

            </html>