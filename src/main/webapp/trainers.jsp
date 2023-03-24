<%@ page import="service.TrainerManager" %>
<%@ page import="service.TrainerManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:300&display=swap">
    <script src="https://kit.fontawesome.com/4afed5dafb.js" crossorigin="anonymous"></script>
    <title>Trainers</title>
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
    <main>
        <h1>List of trainers</h1>
        <%
            TrainerManager trainerManager = new TrainerManager();
        %>
    </main>
    <div class="trainerBox">
        <h2><%= trainerManager.getTrainers() %></h2>
    </div>
</div>

</body>
</html>
