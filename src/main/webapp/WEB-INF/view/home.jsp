<!DOCTYPE html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">--%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FourScouts OAuth2 Discord Demo</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
    <link rel="stylesheet" th:href="@{/css/styles.css}">
</head>
<body>
<section class="section">
    <div class="container has-text-centered">
        <div class="column is-6 is-offset-3">
            <h1 class="title">FourScouts OAuth2 Discords asdasdDemo</h1>

			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal"/>
				<button onClick="logout()" class="btn btn-primary">Logout</button>
			</sec:authorize>

            <sec:authorize access="isAnonymous()">
                <div class="box">
                    <a href="/oauth2/authorization/discord">Log in with Discord</a>
                </div>
            </sec:authorize>

            <%--			<div sec:authorize="isAuthenticated()">--%>
            <%--				<div class="box">--%>
            <%--					Hello, <strong th:text="${#authentication.name}">FourScouts</strong>!--%>
            <%--					Hello, <strong th:text="${#authentication}">FourScouts</strong>!--%>
            <%--				</div>--%>
            <%--			</div>--%>

            <%--			<div sec:authorize="isAnonymous()">--%>
            <%--				<div class="box">--%>
            <%--					<a class="button is-blurple" th:href="@{/oauth2/authorization/discord}">Log in with Discord</a>--%>
            <%--				</div>--%>
            <%--			</div>--%>
        </div>
    </div>
</section>
</body>
</html>
