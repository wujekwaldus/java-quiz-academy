<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Academy</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Java Academy</h1>
		<p>Sprawdź na jakim poziomie jest Twoja wiedza z programowania!</p>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/'">Quiz</button>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/about'">O mnie</button>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/workFAQ'">Praca w IT
			- FAQ</button>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/trening'">Szkolenia
			JAVA</button>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/registration'">Rejestracja</button>
		<sec:authorize var="loggedIn" access="isAuthenticated()" />
		<sec:authentication var="user" property="principal" />
		<c:choose>
			<c:when test="${loggedIn}">
				<button type="button" class="btn btn-success" onclick="$('#logoutForm').submit();">Wyloguj: ${user.username}</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModalDiv">Logowanie</button>
			</c:otherwise>
		</c:choose>

	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Rejestracja użytkownika</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-4">
						<p>Rejestracja w serwisie da Ci możliwość</p>
						<ul class="list-group">
							<li class="list-group-item">Dodawania nowych pytań</li>
							<li class="list-group-item">Wskazówki po rozwiązaniu testu</li>
							<li class="list-group-item">Możliwość nawiązania współpracy</li>
						</ul>
					</div>
					<div class="col-sm-4">
					</div>
					<div class="col-sm-4">
						<form action="/java-quiz-academy/user/new" method="POST">
							<div class="form-group">
								<label for="email">Email:</label> <input type="email" class="form-control" id="email" name="email">
							</div>
							<div class="form-group">
								<label for="password">Hasło:</label> <input type="password" class="form-control" id="password" name="password">
							</div>
							<div class="form-group">
								<label for="password">Powtórz hasło:</label> <input type="password" class="form-control" id="password2" name="password2">
							</div>
							<button type="submit" class="btn btn-default">Zarejestruj</button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${loggedIn}">
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</c:if>
</body>
</html>