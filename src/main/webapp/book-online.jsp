<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:300&display=swap">
    <script src="https://kit.fontawesome.com/4afed5dafb.js" crossorigin="anonymous"></script>
    <title>Spoon Life</title>
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
        <div class="herobox1">
            <h1>Spoon Life</h1>
            <p>This gym does not exist. It's just a functioning site that could serve for someone's gym.</p>
            <p>This site was started by a student to acquire practical Java skills and future employment. This project is based on servlets.</p>
            <a href="#myPopup" class="mybutton">Book Online</a>
        </div>
        <div class="herobox2">
            <img src="<%=request.getContextPath() + "/images/istockphoto-1322158059-612x612.jpg"%>" alt="photo">
        </div>
    </main>
    <div class="cards">
        <div class="card1">
            <a href="#myPopup">
                <i class="fa-solid fa-file-pen"></i>
                <h2>Book Online</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate magni expedita temporibus aut est deserunt.
                </p>
            </a>
            <div id="myPopup" class="popup">
                <a href="#" class="popup-close">&times;</a>
                <form>
                    <h3>Name<input type="text" name="nameField" required></h3>
                    <h3>Surname<input type="text" name="surnameField" required></h3>
                    <h3>Phone number<input type="text" name="numberField" required></h3>
                    <h3>Months<select name="dataField" required>
                        <option value="1">1M, 25$</option>
                        <option value="3">3M, 70$</option>
                        <option value="6">6M, 130$</option>
                        <option value="12">12M, 220$</option>
                    </select></h3>
                    <button type="submit">Reserve</button>
                </form>
                <%@ page import="service.BookingManager"%>
                <%@ page import="service.NewsManager" %>
                <%@ page import="service.BookingManager" %>
                <%
                    BookingManager bookingManager = new BookingManager(request.getParameter("nameField"),
                                                  request.getParameter("surnameField"),
                                                  request.getParameter("numberField"),
                                                  request.getParameter("dataField"));
                    bookingManager.book();
                %>
            </div>
        </div>
        <div class="card2">
            <a href="${pageContext.request.contextPath}/trainers">
                <i class="fa-solid fa-dumbbell"></i>
                <h2>Trainers</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate magni expedita temporibus aut est deserunt.
                </p>
            </a>
        </div>
        <div class="card3">
            <a href="${pageContext.request.contextPath}/schedule">
                <i class="fa-solid fa-clipboard-list"></i>
                <h2>Schedule</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate magni expedita temporibus aut est deserunt.
                </p>
            </a>
        </div>
        <div class="card4">
            <a href="${pageContext.request.contextPath}/contacts">
                <i class="fa-solid fa-phone"></i>
                <h2>Contacts</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate magni expedita temporibus aut est deserunt.
                </p>
            </a>
        </div>
    </div>
    <div class="message">
        <h1>Last news</h1>
    </div>
    <div class="testimonials">
        <%
            NewsManager newsManager = new NewsManager();
        %>
        <div class="tbox">
            <p><h2><%= newsManager.getNewsList().get(0).getNews_title() %></h2></p>
            <p><%= newsManager.getNewsList().get(0).getNews_text() %></p>
            <p><%= newsManager.getNewsList().get(0).getPublication_data() %></p>
        </div>
        <div class="tbox">
            <p><h2><%= newsManager.getNewsList().get(1).getNews_title() %></h2></p>
            <p><%= newsManager.getNewsList().get(1).getNews_text() %></p>
            <p><%= newsManager.getNewsList().get(1).getPublication_data() %></p>
        </div>
        <div class="tbox">
            <p><h2><%= newsManager.getNewsList().get(2).getNews_title() %></h2></p>
            <p><%= newsManager.getNewsList().get(2).getNews_text() %></p>
            <p><%= newsManager.getNewsList().get(2).getPublication_data() %></p>
        </div>
        <div class="tbox">
            <p><h2><%= newsManager.getNewsList().get(3).getNews_title() %></h2></p>
            <p><%= newsManager.getNewsList().get(3).getNews_text() %></p>
            <p><%= newsManager.getNewsList().get(3).getPublication_data() %></p>
        </div>
    </div>
</div>
</body>
</html>
