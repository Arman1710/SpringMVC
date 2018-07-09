<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tagFile" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title><spring:message code="addNews"/></title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/main"><spring:message code="mainPage"/></a>
                </li>

            </ul>
        </div>
    </nav>
</header>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">
            <spring:message code="addNews"/>
        </h1>
    </div>
</section>

<main role="main">
    <div class="container">
        <form:form modelAttribute="news" action="admin/addNews" method="get">
            <table border="0">
                <thead>
                <tr>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <br>
                    <textarea name="title" cols="30" rows="1" style="word-wrap: break-word"  class="form-control mr-sm-2"
                              placeholder="<spring:message code="title"/>" aria-label="Search"></textarea>
                </tr>
                <tr>
                    <br>
                    <textarea name="brief" cols="30" rows="3" style="word-wrap: break-word"  class="form-control mr-sm-2"
                              placeholder="<spring:message code="brief"/>" aria-label="Search"></textarea>
                </tr>
                <tr>
                    <br>
                    <textarea name="content" cols="30" rows="10" style="word-wrap: break-word" class="form-control mr-sm-2"
                              placeholder="<spring:message code="content"/>" aria-label="Search"></textarea>
                </tr>
                <tr>
                    <br>
                    <td>
                        <button type="submit" class="btn btn-primary btn-sm "><spring:message code="submit"/>&raquo;
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <tagFile:newsValidateErrors/>

    </div>
</main>

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
</body>
</html>
