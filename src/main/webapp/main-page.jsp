<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Spoon Life</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <script>
            var popup = document.getElementById('myPopup');
            window.onclick = function(event) {
                if (event.target === popup) {
                    popup.style.display = "none";
                }
            }
        </script>
        <div class="container">
            <header>
                <h1><%= "Spoon Life" %></h1>
            </header>

            <main>
                <h2><a href="#myPopup">Order a subscription</a></h2>
                <div id="myPopup" class="popup">
                    <a href="#" class="popup-close">&times;</a>
                    <form>
                        <h3>Name<input type="text" name="nameField" required></h3>
                        <h3>Surname<input type="text" name="surnameField" required></h3>
                        <h3>Phone number<input type="text" name="numberField" required></h3>
                        <h3>Months<select name="data" required>
                            <option value="1">1M</option>
                            <option value="3">3M</option>
                            <option value="6">6M</option>
                            <option value="12">12M</option>
                        </select></h3>
                        <button type="submit">Reserve</button>
                    </form>
                    <%@ page import="controller.Checker, controller.DBManager, java.sql.SQLException"%>
                    <%
                        String bookingMessage = "";
                        String phoneNumber = request.getParameter("numberField");
                        if (phoneNumber == null)
                            phoneNumber = "";
                        if (Checker.process(phoneNumber)) {
                            try {
                                try {
                                    Class.forName("org.sqlite.JDBC");
                                } catch (ClassNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                                DBManager.insertContact(request.getParameter("nameField"),
                                        request.getParameter("surnameField"),
                                        request.getParameter("numberField"),
                                        request.getParameter("data"));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            bookingMessage = "Your data have been added!";
                        } else {
                            bookingMessage = "Such phone-number entered incorrectly or already exists!";
                        }
                    %>
                    <h2><%= bookingMessage %></h2>
                </div>
            </main>

            <footer>
                <p>Servlet gym site</p>
            </footer>
        </div>

    </body>
</html>
