<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Book Requests</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">

        <h1 class="mt-4 mb-4">All Book Requests</h1>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Book Name</th>
                    <th>User Name</th>
                    <th>Request Date</th>
                    <th>Return Date</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="request" items="${bookReqList}">
                    <tr>
                        <td>${request.id}</td>
                        <td>${request.bookName}</td>
                        <td>${request.userName}</td>
                        <td><fmt:formatDate value="${request.issueDate}" pattern="dd-MMM-yyyy" /></td>
                        <td><fmt:formatDate value="${request.returnDate}" pattern="dd-MMM-yyyy"/></td>
        <td>Pending</td>

                        <td>
                            <form action="/request/processRequest.htm" method="post" class="d-inline">
                                <input type="hidden" name="requestId" value="${request.id}" />
                                <input type="hidden" name="statusFlg" value="A" />
                                <input type="hidden" name="bookID" value="${request.bookID}" />
                                <button type="submit" class="btn btn-success">Approve</button>
                            </form>
                            <form action="/request/processRequest.htm" method="post" class="d-inline">
                                <input type="hidden" name="requestId" value="${request.id}" />
                                <input type="hidden" name="statusFlg" value="J" /> 
                                <input type="hidden" name="bookID" value="${request.bookID}" />
                                <button type="submit" class="btn btn-danger">Reject</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-end mb-3">
            <a href="/lms/welcome.htm" class="btn btn-primary mr-2">Home</a>
            <a href="/lms/logout.htm" class="btn btn-danger">Logout</a>
        </div>
    </div>
</body>
</html>
