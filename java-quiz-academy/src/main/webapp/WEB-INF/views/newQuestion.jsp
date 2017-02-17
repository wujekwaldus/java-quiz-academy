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
		var newAnswerTemplate = '<input type="text" class="form-control" name="answers['+answerIndex+'].text" placeholder="Wpisz treść odpowiedzi"><input type="checkbox" name="answers['+answerIndex+'].correct" value="true"/> <label for="answers'+answerIndex+'.correct1">Poprawna?</label><input type="hidden" name="_answers['+answerIndex+'].correct" value="on"><br/>';
		$('#newQuestionAnswers').append(newAnswerTemplate);
		answerIndex++;
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<sec:authentication var="user" property="principal" />
	<div class="container">
		<spring:hasBindErrors name="createQuestionCommand">
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
					<form:form action="/java-quiz-academy/question/new" commandName="createQuestionCommand" method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="area">Kategoria pytania:</label><br />
									<c:forEach items="${areas}" var="area">
										<div class="radio">
											<label> <form:radiobutton path="area" value="${area.id}" label="${area.name}" />
											</label>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="level">Poziom trudności:</label><br />
									<c:forEach items="${levels}" var="level">
										<form:radiobutton path="level" value="${level}" label="${level.text}" />
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="text">Treść:</label>
							<form:textarea path="text" rows="4" cssClass="form-control" />
						</div>
						<div class="form-group">
							<label for="type">Rodzaj pytania:</label> <br />
							<form:radiobutton path="type" value="SINGLE_CHOICE" label="Jednokrotny wybór" />
							<form:radiobutton path="type" value="MULTIPLE_CHOICE" label="Wielokrotny wybór" />
						</div>
						<div class="form-group">
							<label for="text">Odpowiedzi:</label><br />
							<button type="button" class="btn btn-success btn-xs" onclick="newAnswer()">Nowa odpowiedź (+)</button>
							<br />
							<div id="newQuestionAnswers">
								<c:forEach var="answer" items="${createQuestionCommand.answers}" varStatus="status">
									<form:input path="answers[${status.index}].text" cssClass="form-control" placeholder="Wpisz treść odpowiedzi" />
									<form:checkbox path="answers[${status.index}].correct" value="true" label="Poprawna?" />
									<script type="text/javascript">
										answerIndex++;
									</script>
								</c:forEach>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button type="submit" class="btn btn-default">Wyślij pytanie</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>