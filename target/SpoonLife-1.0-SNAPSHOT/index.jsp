<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <header>
            <h1><%= "Hello localhost!" %></h1>
        </header>

        <div class="container">
            <main></main>

            <footer>
                <p>Servlet gym site</p>
            </footer>
        </div>
    </body>
</html>