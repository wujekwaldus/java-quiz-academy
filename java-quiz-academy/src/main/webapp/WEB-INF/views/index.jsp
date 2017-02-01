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
	<jsp:include page="menu.jsp"/>
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
	</div>
</body>
</html>