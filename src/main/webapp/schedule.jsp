<%@ page import="service.ScheduleManager" %>
<%@ page import="service.ScheduleManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:300&display=swap">
    <script src="https://kit.fontawesome.com/4afed5dafb.js" crossorigin="anonymous"></script>
    <title>Schedule</title>
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
        <%
            ScheduleManager scheduleManager = new ScheduleManager();
        %>
        <table>
            <thead>
            <tr>
                <th>Day</th>
                <th>Entrance to the club</th>
            </tr>
            </thead>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(0).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(0).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(1).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(1).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(2).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(2).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(3).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(3).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(4).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(4).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(5).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(5).getTime() %></td>
            </tr>
            <tr>
                <td><%= scheduleManager.getDaysTimesList().get(6).getDay() %></td>
                <td><%= scheduleManager.getDaysTimesList().get(6).getTime() %></td>
            </tr>
        </table>
    </main>


</div>


</body>
</html>

