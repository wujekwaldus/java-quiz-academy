<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<jsp:include page="menu.jsp" />
	<div class="container">
		<c:if test="${newUserRegistered}">
			<div class="alert alert-success">
				<p>Zarejestrowano nowego użytkownika.</p>
			</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Rejestracja użytkownika</div>
			<div class="panel-body">
				<div class="row">
					<form:form action="/java-quiz-academy/user/new" commandName="userForm" method="POST">
						<div class="col-sm-7">
							<p>Rejestracja w serwisie da Ci możliwość</p>
							<ul class="list-group">
								<li class="list-group-item">Dodawania nowych pytań</li>
								<li class="list-group-item">Wskazówki po rozwiązaniu testu</li>
								<li class="list-group-item">Możliwość nawiązania współpracy</li>
							</ul>
						</div>
						<div class="col-sm-5">
							<div class="form-group">
								<label for="email">Email: <form:errors style="color: red; font-weight: bold;" path="email" /></label>
								<form:input type="text" class="form-control" id="email" path="email" />
							</div>
							<div class="form-group">
								<label for="name">Imie: <form:errors style="color: red; font-weight: bold;" path="name" /></label>
								<form:input type="text" class="form-control" id="name" path="name" />
							</div>
							<div class="form-group">
								<label for="password">Hasło: <form:errors style="color: red; font-weight: bold;" path="password" /></label>
								<form:input type="password" class="form-control" id="password" path="password" />
							</div>
							<div class="form-group">
								<label for="password">Powtórz hasło:</label>
								<form:input type="password" class="form-control" id="password2" path="passwordRepeated" />
							</div>
							<button type="submit" class="btn btn-default">Zarejestruj</button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>