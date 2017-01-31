<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModalDiv">Logowanie</button>

	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Panel Administracyjny</div>
			<div class="panel-body">
				<div class="row">
					<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/'">Powrót na
						stronę główną</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>