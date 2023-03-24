<%@ page import="service.ContactsManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:300&display=swap">
    <script src="https://kit.fontawesome.com/4afed5dafb.js" crossorigin="anonymous"></script>
    <title>Contacts</title>
</head>
<body>

<div class="container">
    <header>
        <div class="logo">
            <img src="<%=request.getContextPath() + "/images/gym-and-fitness-logo-png.webp"%>" width="150" height="100" alt="logo">
        </div>


        <nav>
            <a href="${pageContext.request.contextPath}/book" class="navbutton">Main page</a>
            <a href="${pageContext.request.contextPath}/trainers" class="navbutton">Trainers</a>
            <a href="${pageContext.request.contextPath}/schedule" class="navbutton">Schedule</a>
            <a href="${pageContext.request.contextPath}/contacts" class="navbutton">Contacts</a>
        </nav>
    </header>


        <p>
            <%
                ContactsManager contactsManager = new ContactsManager();
            %>
            <h3>
                <%= contactsManager.getContactsList().get(0).getCOMMUNICATION_TYPE() + ": " %>
                <%= contactsManager.getContactsList().get(0).getLINK() %>
            </h3>

            <h3>
                <%= contactsManager.getContactsList().get(1).getCOMMUNICATION_TYPE() + ": "  %>
                <%= contactsManager.getContactsList().get(1).getLINK() %>
            </h3>

            <h3>
                <%= contactsManager.getContactsList().get(2).getCOMMUNICATION_TYPE() + ": " %>
                <%= contactsManager.getContactsList().get(2).getLINK() %>
            </h3>

            <h3>
                <%= contactsManager.getContactsList().get(3).getCOMMUNICATION_TYPE() + ": " %>
                <%= contactsManager.getContactsList().get(3).getLINK() %>
            </h3>
        </p>


</div>


</body>
</html>

