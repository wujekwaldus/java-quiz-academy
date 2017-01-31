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
		<button type="button" class="btn btn-default">Quiz</button>
		<button type="button" class="btn btn-default">O mnie</button>
		<button type="button" class="btn btn-default">Praca w IT - FAQ</button>
		<button type="button" class="btn btn-default">Szkolenia JAVA</button>
		<button type="button" class="btn btn-default">Rejestracja</button>
		<sec:authorize var="loggedIn" access="isAuthenticated()" />
		<c:choose>
			<c:when test="${loggedIn}">
				<button type="button" class="btn btn-success" onclick="$('#logoutForm').submit();">Wyloguj:
					${pageContext.request.userPrincipal.name}</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModalDiv">Logowanie</button>
			</c:otherwise>
		</c:choose>

	</div>
	<div class="container">
		<spring:hasBindErrors name="randomQuizSearchCriteria">
			<div class="panel panel-danger">
				<div class="panel-heading" style="font-weight: bold;">Wystąpiły następujące błędy walidacji:</div>
				<div class="panel-body" style="font-weight: bold;">
					${errors.hasFieldErrors('area') ? errors.getFieldError('area').defaultMessage : ''}<br /> ${errors.hasFieldErrors('level') ? errors.getFieldError('level').defaultMessage : ''}<br />
				</div>
			</div>
		</spring:hasBindErrors>
		<c:if test="${param.errorLogin != null}">
			<div class="alert alert-danger">
				<p>Niepoprawne dane do logowania.</p>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				<p>Zostałeś wylogowany.</p>
			</div>
		</c:if>


		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Skonfiguruj swój test</div>
			<form action="/java-quiz-academy/quiz/">
				<div class="panel-body">

					<div class="row">
						<div class="col-sm-4">
							Wybierz interesujące Cię obszary:
							<c:forEach items="${areas}" var="area">
								<div class="checkbox">
									<label><input type="checkbox" value="${area.id}" name="area">${area.name}</label>
								</div>
							</c:forEach>
						</div>
						<div class="col-sm-8">Możesz skonfigurować swój test wybierając tylko te obszary, które Cię interesują. Liczba pytań
							zależy od ilości wybranych obszarów. Dla każdgo obszaru system wylosuje 10 pytań.</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							Wybierz interesujący Cię poziom trudności:
							<c:forEach items="${levels}" var="level">
								<div class="radio">
									<label><input type="radio" value="${level}" name="level" checked="checked">${level.text}</label>
								</div>
							</c:forEach>
						</div>
						<div class="col-sm-8">Możesz wybrać poziom trudności swojego testu. Jednak UWAGA: wybierając poziom trudności "Senior"
							system wylosuje pytania także z poziomu junior lub developer. W przypadku wyboru "Developera" system wybierze junior i
							developer.</div>
					</div>
				</div>
				<div class="panel-footer">
					<button type="submit" class="btn btn-default">Rozpocznij test</button>
				</div>
			</form>
		</div>

		<div id="loginModalDiv" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Panel logowania użytkownika</h4>
					</div>
					<div class="modal-body">
						<c:url var="loginUrl" value="/" />
						<form action="${loginUrl}" method="POST">
							<div class="form-group">
								<label for="email">Nazwa użytkownika</label> <input type="text" class="form-control" id="email" name="email">
							</div>
							<div class="form-group">
								<label for="password">Hasło:</label> <input type="password" class="form-control" id="password" name="password">
							</div>
							<button type="submit" class="btn btn-default">Zaloguj</button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>