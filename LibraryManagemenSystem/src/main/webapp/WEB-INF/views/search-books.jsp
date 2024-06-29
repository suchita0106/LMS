<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Search Books</title>
      <!-- Bootstrap CSS for styling -->
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
      <body onload="initializeInputs()">
        <script>
        function toggleInput(selection) {
            var authorInput = document.getElementById('authorInput');
            var titleInput = document.getElementById('titleInput');
            var criteriaInput = document.getElementById('criteria');
        
            if (selection.value === 'author') {
                authorInput.disabled = false;
                titleInput.disabled = true;
                criteriaInput.value = 'A';
            } else {
                authorInput.disabled = true;
                titleInput.disabled = false;
                criteriaInput.value = 'T';
            }
        }
        
        function initializeInputs() {
            var searchCriteria = document.getElementById('searchCriteria');
            toggleInput(searchCriteria); // Initialize input states based on the default selection
        }
        </script>
        </body>
        
    </head>

    <body>
      <div class="container mt-5">
        <h2>Search for a Book</h2>
        <form action="/lms/books/searchbook.htm" method="POST">
          <div class="form-group">
              <label for="searchCriteria">Search By:</label>
              <select id="searchCriteria" class="form-control" onchange="toggleInput(this)">
                  <option value="author">Author</option>
                  <option value="title">Title</option>
              </select>
          </div>
          <div class="form-group">
              <label for="authorInput">Author:</label>
              <input type="text" class="form-control" id="authorInput" name="author" placeholder="Enter author's name" disabled="false">
          </div>
          <div class="form-group">
              <label for="titleInput">Title:</label>
              <input type="text" class="form-control" id="titleInput" name="title" placeholder="Enter book title" disabled="true">
          </div>
          <input type="hidden" id="criteria" name="criteria" value="A">
          <button type="submit" class="btn btn-primary mr-2">Search</button>
          <a href="/lms/welcome.htm" class="btn btn-secondary">Home</a>
      </form>

        <!-- Book list section -->
        <div class="mt-3">
          <h3>Search Results:</h3>
          <table class="table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="book" items="${books}">
                <tr>
                  <td>${book.id}</td>
                  <td>${book.title}</td>
                  <td>${book.author}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <!-- Bootstrap JS and dependencies -->
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>