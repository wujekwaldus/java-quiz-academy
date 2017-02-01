<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Java Academy Quiz - Wynik testu</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Twój wynik to: ${result.score} %</h1>
		<p>Dziękujemy za wykonanie testu!</p>
	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">Poniżej podsumowanie testu:</div>
		</div>
		<c:forEach items="${result.answers}" var="a">
			<div class="panel panel-default">
				<div class="panel-heading" style="font-weight: bold;">${a.questionText}</div>
				<div class="panel-body">
					<c:forEach var="o" items="${a.selected}">
						<div class="row" style="margin-left: 20px;">${o.text}</div>
					</c:forEach>
				</div>

				<c:if test="${a.correct}">
					<div class="panel-footer" style="font-weight: bold; font-size: 11px; color: #00DD00">Odpowiedź poprawna.</div>
				</c:if>

				<c:if test="${!a.correct}">
					<div class="panel-footer" style="font-weight: bold; font-size: 11px; color: #DD0000">Zaznaczono złą odpowiedź lub nie
						wszystkie zaznaczone odpowiedzi są prawidłowe.</div>
				</c:if>

			</div>
		</c:forEach>
		<button type="button" class="btn btn-default" onclick="document.location.href='/java-quiz-academy/'">Powrót na stronę
			główną</button>

	</div>



</body>
</html>