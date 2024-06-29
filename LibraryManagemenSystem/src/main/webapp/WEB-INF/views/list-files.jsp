<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Ensure this taglib directive is present -->
        <html>

        <head>
            <title>Uploaded Files</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    padding: 20px;
                }

                ul {
                    list-style-type: none;
                }

                li {
                    padding: 8px;
                    margin-bottom: 2px;
                    background-color: #f8f8f8;
                    border: 1px solid #ddd;
                }

                a {
                    text-decoration: none;
                    color: #0066cc;
                }

                a:hover {
                    text-decoration: underline;
                }

                .footer-links {
                    margin-top: 20px;
                }
            </style>
        </head>

        <body>
            <h2>Available e-Books</h2>
            <ul>
                <%-- Dynamically populate the list of files --%>
                    <c:forEach var="file" items="${files}">
                        <li>
                            <a href="<c:choose>
                            <c:when test='${file.name.endsWith(".pdf")}'>
                                viewPdf?filename=${file.name}
                                </c:when>
                                <c:otherwise>
                                    download?filename=${file.name}
                                </c:otherwise>
                                </c:choose>" target="_blank">${file.name}
                            </a>
                        </li>
                    </c:forEach>
            </ul>
            <div class="footer-links text-center mt-4">
                <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
            </div>
        </body>

        </html>