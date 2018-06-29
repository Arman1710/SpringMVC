<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>
        <bean:message key="selectedNews"/>
    </title>
</head>

<body>


<main role="main">
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/main.do"><bean:message key="mainPage"/></a>
                    </li>

                </ul>
            </div>
        </nav>
    </header>

    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">
                ${newsForm.title}
            </h1>
        </div>
    </section>


    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col">
                    <html:form action="/moveToEditPage?newsId=${newsForm.newsId}">
                        <div class="card mb-4 box-shadow">
                            <div class="card-body">
                                <p class="card-text">${newsForm.brief}</p>
                                <img class="card-img-top"
                                     data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                                     alt="Card image cap">
                                <p class="card-text">${newsForm.content}</p>
                            </div>
                        </div>
                        <html:submit>
                            <bean:message key="editNews"/>
                        </html:submit>
                    </html:form>
                </div>
            </div>
        </div>
    </div>


    <div class="container">
        <html:form action="/addComment?newsId=${newsForm.newsId}">
            <table border="0">
                <thead>
                <tr>
                    <th><bean:message key="comment.add"/></th>
                </tr>
                </thead>
                <tbody>
                <tr></tr>
                <tr>
                    <td><bean:message key="comment.Author"/></td>
                    <td><html:text property="author"/></td>
                </tr>
                <tr>
                    <td><bean:message key="comment.Description"/></td>
                    <td><html:text property="description"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><html:submit>
                        <bean:message key="comment.add"/>
                    </html:submit>
                    </td>
                </tr>
                </tbody>
            </table>
        </html:form>

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
        <html:form action="/deleteComment?newsId=${newsForm.newsId}">
        <c:forEach items="${newsForm.commentList}" var="comment">
                <div class="comments">
                    <div class="row">
                        <div class="col">
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
                        <div class="col-md-4">
                            <html:checkbox property="checkboxValue" value="${comment.commentId}"/>
                        </div>
                    </div>
        </c:forEach>
            <html:submit>
                <bean:message key="comment.delete"/>
            </html:submit>
        </html:form>
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



