<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
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
        <spring:message code="selectedNews"/>
    </title>
</head>

<body>


<main role="main">
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
                ${news.title}
            </h1>
        </div>
    </section>


    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card mb-4 box-shadow">
                        <div class="card-body">
                            <p class="card-text">${news.brief}</p>
                            <img class="card-img-top"
                                 data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                                 alt="Card image cap">
                            <p class="card-text">${news.content}</p>
                        </div>
                    </div>
                    <p class="float-right"><a class="btn btn-primary btn-md"
                                              href="/admin/editNewsPage?newsId=${news.newsId}"
                                              role="button"><spring:message code="editNews"/></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <form:form modelAttribute="comment" action="addComment/${news.newsId}" method="post">
            <table border="0">
                <thead>
                <tr>
                    <th><spring:message code="comment.add"/></th>
                </tr>
                </thead>
                <tbody>
                <tr></tr>
                <tr>
                    <td><spring:message code="comment.Author"/></td>
                    <td><textarea name="author" cols="100" rows="1" style="word-wrap: break-word"
                                  class="form-control mr-sm-2" aria-label="Search"></textarea></td>
                </tr>
                <tr>
                    <td><spring:message code="comment.Description"/></td>
                    <td><textarea name="description" cols="100" rows="5" style="word-wrap: break-word"
                                  class="form-control mr-sm-2" aria-label="Search"></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <br>
                        <input type="submit" class="btn btn-primary btn-md"
                               value="<spring:message code="comment.add"/>">
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <html:messages id="author_err" property="comAuthor_err">
            <div style="color:red">
                <bean:write name="author_err"/>
            </div>
        </html:messages>

        <html:messages id="desc_err" property="comDesc_err">
            <div style="color:red">
                <bean:write name="desc_err"/>
            </div>
        </html:messages>

        <div class="container">
            <form:form action="admin//deleteComment/${news.newsId}" method="get">
            <c:forEach items="${news.commentList}" var="comment">
            <div class="comments">
                <div class="row">
                    <div class="col-md-11">
                        <div class="metadata">
                            <span class="date">${comment.dateCreated}</span>
                        </div>
                        <h3 class="title-comments">
                                ${comment.author}
                        </h3>
                        <ul class="media-list">
                            <li class="media">
                                <div class="media-body">
                                    <div class="media-text text-justify">${comment.description}</div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-1">
                        <input type="checkbox" name="checkedComments" value="${comment.commentId}">
                    </div>
                </div>

                <hr>
                </c:forEach>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <c:if test="${not empty news.commentList}">
                        <div class="float-right">
                            <button type="submit" class="btn btn-danger btn-md"><spring:message
                                    code="comment.delete"/></button>
                        </div>
                    </c:if>
                </sec:authorize>
                </form:form>
                <br>
            </div>
        </div>
    </div>
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
<link type="text/css" rel="stylesheet" href="/css/style.css"/>

</body>
</html>



