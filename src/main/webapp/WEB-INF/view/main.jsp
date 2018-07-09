<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>
        <spring:message code="mainPage"/>
    </title>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="?lang=ru"><spring:message code="locale.russian"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?lang=en"><spring:message code="locale.english"/></a>
                </li>
                <li class="float-right">
                    <a class="nav-link" href="/"><spring:message code="logIn"/></a>
                </li>
                <form:form id="logoutForm" method="POST" action="/logout">
                    <button type="submit" class="btn btn-primary btn-sm"><spring:message code="logOut"/></button>

                </form:form>
            </ul>
        </div>
    </nav>
</header>

<main role="main">



    <form:form action="admin/deleteNews" method="get">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3"><spring:message code="mainPage"/></h1>
            </div>
        </div>

    <div class="row">
        <div class="col-1">
            <div class="container">
                <p class="float-left">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-primary btn-md" href="/admin/addNewsPage" role="button"><spring:message
                                code="addNews"/></a><br>
                        <br>
                        <a><button type="submit" class="btn btn-primary btn-md"><spring:message code="removeNews"/></button></a>
                    </sec:authorize>
                </p>
            </div>
        </div>
        <div class="col-11">
            <div class="container">
                <div class="row" >
                    <c:forEach items="${newsList}" var="news">
                        <div class="col-12">
                            <h2>${news.title}</h2>

                            <p>${news.brief}</p>

                            <p class="float-right"><a class="btn btn-success"  href="/selectedNews?newsId=${news.newsId}"
                                                      role="button"><spring:message code="open"/></a>
                                <input type="checkbox" name="checkedNews" value="${news.newsId}">
                            <hr>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <hr>
        </div>
        </div>
    </form:form>
</main>
<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>

    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/docs/4.1/dist/js/bootstrap.min.js"></script>
<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/holder.min.js"></script>

</body>
</html>
