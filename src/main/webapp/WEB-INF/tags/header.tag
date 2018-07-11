<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/main"><spring:message code="mainPage"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?lang=ru"><spring:message code="locale.russian"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?lang=en"><spring:message code="locale.english"/></a>
                </li>
            </ul>
            <form:form id="logoutForm" method="POST" action="/logout">
                <button type="submit" class="btn btn-primary btn-sm"><spring:message code="logOut"/></button>
            </form:form>
        </div>
    </nav>
</header>