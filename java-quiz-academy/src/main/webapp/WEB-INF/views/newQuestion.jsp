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
<script type="text/javascript">
	var answerIndex = 0;
	function newAnswer() {
		var newAnswerTemplate = '<input type="text" class="form-control" name="answers['+answerIndex+'].text" placeholder="Wpisz treść odpowiedzi">Poprawna: <input type="checkbox" name="answer['+answerIndex+'].correct" value="true"/><br/>';
		$('#newQuestionAnswers').append(newAnswerTemplate);
		answerIndex++;
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<sec:authentication var="user" property="principal" />
	<div class="container">

		<spring:hasBindErrors name="newQuestionCommand">
			<div class="panel panel-danger">
				<div class="panel-heading" style="font-weight: bold;">Wystąpiły następujące błędy walidacji:</div>
				<div class="panel-body" style="font-weight: bold;">
					<c:if test="${errors.hasFieldErrors('area')}">
					 ${errors.getFieldError('area').defaultMessage} <br />
					</c:if>
					<c:if test="${errors.hasFieldErrors('level')}">
					  ${errors.getFieldError('level').defaultMessage} <br />
					</c:if>
					<c:if test="${errors.hasFieldErrors('text')}">
					  ${errors.getFieldError('text').defaultMessage} <br />
					</c:if>
					<c:if test="${errors.hasFieldErrors('type')}">
					  ${errors.getFieldError('type').defaultMessage} <br />
					</c:if>
					<c:if test="${errors.hasFieldErrors('answers')}">
					 ${errors.getFieldError('answers').defaultMessage} <br />
					</c:if>
				</div>
			</div>
		</spring:hasBindErrors>

		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Witaj: ${user.name}</div>
			<div class="panel-body">
				<div id="newQuestion" class="text-left">
					<h4 class="modal-title">Nowe Pytanie</h4>
					<form action="/java-quiz-academy/question/new" method="post">
						<div class="form-group">
							<label for="area">Kategoria pytania:</label><br />
							<c:forEach items="${areas}" var="area">
								<input type="radio" value="${area.id}" name="area" checked="checked">${area.name}
												</c:forEach>
						</div>
						<div class="form-group">
							<label for="level">Poziom trudności:</label><br />
							<c:forEach items="${levels}" var="level">
								<input type="radio" value="${level}" name="level" checked="checked">${level.text}
												</c:forEach>
						</div>
						<div class="form-group">
							<label for="text">Treść:</label>
							<textarea class="form-control" rows="4" name="text"></textarea>
						</div>
						<div class="form-group">
							<label for="type">Rodzaj pytania:</label> <br /> <input type="radio" value="SINGLE_CHOICE" name="type" checked="checked">Jednokrotny
							wybór <input type="radio" value="MULTIPLE_CHOICE" name="type">Wielokrotny wybór
						</div>
						<div class="form-group">
							<label for="text">Odpowiedzi:</label><br />
							<button type="button" class="btn btn-success btn-xs" onclick="newAnswer()">Nowa odpowiedź (+)</button>
							<br />
							<div id="newQuestionAnswers"></div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button type="submit" class="btn btn-default">Wyślij pytanie</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>