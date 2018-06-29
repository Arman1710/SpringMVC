<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://jakarta.apache.org/struts/tags-html" %>
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
            </ul>
        </div>
    </nav>
</header>

<main role="main">
    <%--<html:link action="/main">--%>
        <%--<spring:message code="mainPage"/>--%>
    <%--</html:link>--%>
    <%--<form:form action="selectedNews">--%>
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3"><spring:message code="mainPage"/></h1>
            </div>
        </div>

    <div class="row">
        <div class="col-2">
            <div class="container">
                <%--<p class="float-left">--%>
                    <%--<spring:url value="/selectedNews/${newsId}" var="selectedNewsUrl"/>--%>
                    <a class="btn btn-primary btn-lg" href="/addNewsPage" role="button"><spring:message
                            code="addNews"/></a><br><br>
                    <a><button type="submit" class="btn btn-primary btn-lg"><spring:message code="removeNews"/></button></a>
                </p>
            </div>
        </div>
        <div class="col-10">
            <div class="container">
                <div class="row">
                    <c:forEach items="${newsList}" var="news">
                        <div class="col-12">
                            <h2>${news.title}</h2>
                            <p>${news.brief}</p>
                            <spring:url value="/selectedNews/${newsId}" var="selectedNewsUrl"/>
                            <p class="float-right"><a class="btn btn-secondary"  href="${selectedNewsUrl}"
                                  role="button"><spring:message code="open"/></a>


                                <%--<a><html:checkbox property="checkboxValue" value="${news.newsId}"/></a>--%>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <hr>
        </div>
        </div>
    <%--</form:form>--%>
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
