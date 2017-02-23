<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="jumbotron text-center">
	<h1>Java Academy</h1>
	<p>Sprawdź na jakim poziomie jest Twoja wiedza z programowania!</p>
	<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/'">Quiz</button>
	<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/about'">O mnie</button>
	<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/workFAQ'">Praca w IT -
		FAQ</button>
	<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/trening'">Szkolenia
		JAVA</button>
	<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/registration'">Rejestracja</button>
	<sec:authorize var="loggedIn" access="isAuthenticated()" />
	<sec:authorize var="isAdmin" access="hasAnyRole('ADMIN')" />
	<sec:authentication var="user" property="principal" />
	<c:choose>
		<c:when test="${loggedIn}">
			<button type="button" class="btn btn-success" onclick="$('#logoutForm').submit();">Wyloguj: ${user.name}</button>
		</c:when>
		<c:otherwise>
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModalDiv">Logowanie</button>
		</c:otherwise>
	</c:choose>
	<c:if test="${loggedIn}">
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/user/me?activeTab=profile'">Mój profil</button>
	</c:if>
	<c:if test="${isAdmin}">
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/admin/'">Panel Administracyjny</button>
	</c:if>
	<c:if test="${loggedIn}">
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</c:if>
	<div id="loginModalDiv" class="modal fade" role="dialog">
		<div class="modal-dialog text-left">
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
