<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Book Details</h1>
        <div class="row mt-4">
       
            <div class="col-md-8">
                <h3>Title: ${book.title}</h3>
                <p><strong>Author:</strong> ${book.author} </p>
                <p><strong>Issue Date:</strong> <%= new java.util.Date() %></p>
                <p><strong>Return Date:</strong> <%= calculateReturnDate() %></p>

                <p class="text-danger">* Note: A penalty will be incurred if the book is not returned on time.</p>
          

                                            <!-- Each button is now within its own form -->
                                            <form action="/request/myrequest.htm" method="post">
                                                <input type="hidden" name="bookID" value="${book.id}" />
                                                <input type="hidden" name="bookName" value="${book.title}" />
                                                <input type="hidden" name="IssueDate" value="<%= new java.util.Date() %>" />
                                                <input type="hidden" name="ReturnDate" value="<%= calculateReturnDate() %>" />
                                                <input type="hidden" name="statusFlg" value="P" />
                                                <a href="/lms/welcome.htm" class="btn btn-primary">Home</a>
                                                <button type="submit" class="btn btn-primary">continue</button>
                                            </form>
                                            
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <%-- Custom Java method to calculate return date --%>
    <%!

        public String calculateReturnDate() {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.add(java.util.Calendar.DATE, 15); // Adding 15 days
            return calendar.getTime().toString();
        }
    %>
</body>
</html>
