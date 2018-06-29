<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>
        <bean:message key="mainPage"/>
    </title>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/Locale.do?method=russian"><bean:message key="locale.russian"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Locale.do?method=english"><bean:message key="locale.english"/></a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<main role="main">
    <html:link action="/main">
        <bean:message key="mainPage"/>
    </html:link>
    <html:form action="/deleteNews">
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><bean:message key="mainPage"/></h1>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <c:forEach items="${newsForm.newsList}" var="news">
                <div class="col-md-4">
                    <h2>${news.title}</h2>
                    <p>${news.brief}</p>
                    <p><a class="btn btn-secondary" href="/selectedNews.do?newsId=${news.newsId}"
                          role="button"><bean:message key="open"/> &raquo;</a>
                        <a><html:checkbox property="checkboxValue" value="${news.newsId}"/></a>
                    </p>
                </div>
            </c:forEach>
        </div>
    </div>
    <hr>
    </div>



</main>

<div class="container">
    <p class="float-left">
        <a class="btn btn-primary btn-lg" href="/pages/addNews.jsp" role="button"><bean:message
                key="addNews"/>&raquo;</a><br><br>
        <a><button type="submit" class="btn btn-primary btn-lg"><bean:message key="removeNews"/>&raquo;</button></a>
    </p>
</div>
</html:form>

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
