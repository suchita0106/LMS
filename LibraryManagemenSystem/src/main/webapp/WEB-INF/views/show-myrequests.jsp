<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Requests</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>My Requests</h1>
        <!-- Table code here -->
        <table class="table table-bordered">
            <!-- Table header here -->
            <thead class="thead-dark">
                <tr>
                    <th>Book Name</th>
                    <th>Request Date</th>
                    <th>Return Date</th>
                    <th>Status</th>
                    <th>Approved By</th>
                </tr>
            </thead>
            <tbody>
                <!-- Table rows here -->
                <c:forEach var="request" items="${reqList}">
                    <tr>
                        <td>${request.bookName}</td>
                        <td><fmt:formatDate value="${request.issueDate}" pattern="dd-MMM-yyyy" /></td>
                        <td><fmt:formatDate value="${request.returnDate}" pattern="dd-MMM-yyyy"/></td>
                        <td>${request.statusFlg}</td>
                        <td>${request.adminusername}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Buttons -->
        <div class="mt-3">
            <a href="/lms/logout.htm" class="btn btn-danger">Logout</a>
            <a href="/lms/welcome.htm" class="btn btn-primary">Home</a>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
