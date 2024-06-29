<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Requests</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container button {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Book Requests</h2>
        
        <form>
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Book Name</th>
                        <th>User Name</th>
                        <th>Request Date</th>
                        <th>Return Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="request" items="${requests}">
                        <tr>
                            <td>${request.bookName}</td>
                            <td>${request.userName}</td>
                            <td><fmt:formatDate value="${request.issueDate}" pattern="dd-MMM-yyyy" /></td>
                            <td><fmt:formatDate value="${request.returnDate}" pattern="dd-MMM-yyyy" /></td>
                            <td>${request.statusFlg}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <div class="button-container">
                <a href="/lms/logout.htm" class="btn btn-danger">Logout</a>
                <a href="/lms/welcome.htm" class="btn btn-primary">Home</a>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS (optional, only needed if you require Bootstrap JavaScript features) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
