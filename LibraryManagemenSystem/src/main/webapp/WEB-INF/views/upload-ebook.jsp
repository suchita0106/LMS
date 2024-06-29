<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Upload File</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            form {
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #333;
            }

            label {
                font-size: 16px;
                color: #666;
            }

            input[type="file"] {
                margin-top: 5px;
            }

            button {
                background-color: #4CAF50;
                color: white;
                border: none;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 10px 2px;
                cursor: pointer;
                border-radius: 5px;
            }

            button:hover {
                background-color: #45a049;

            }

            .footer-links {
                margin-top: 20px;
            }
        </style>
    </head>

    <body>
        <h2>Upload your file</h2>
        <form action="/lms/uploadebook.htm" method="post" enctype="multipart/form-data">
            <label for="file">Choose file to upload:</label>
            <input type="file" id="file" name="file" required><br><br>
            <button type="submit">Upload</button>
        </form>
        <div class="footer-links text-center mt-4">
            <a href="/lms/welcome.htm" class="btn btn-secondary">Home Page</a>
        </div>
    </body>

    </html>