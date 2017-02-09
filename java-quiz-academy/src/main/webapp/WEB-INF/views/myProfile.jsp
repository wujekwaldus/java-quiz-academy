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
	<sec:authentication var="user" property="principal" />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Witaj: ${user.name}</div>
			<div class="panel-body">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">Mój profil</a></li>
					<li><a data-toggle="tab" href="#tests">Moje Testy</a></li>
					<li><a data-toggle="tab" href="#questions">Moje Pytania</a></li>
				</ul>
				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						<h3>Moj profil</h3>
						<p>....</p>
					</div>
					<div id="tests" class="tab-pane fade">
						<h3>Moje Testy</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Data</th>
									<th>Wynik</th>
									<th>Szczegóły</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="r" items="${results}" varStatus="i">
									<tr>
										<td>${r.resolveDateFormatted}</td>
										<td>${r.score}%</td>
										<td>
											<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#testResults_${i.index}">szczegóły</button>
											<div id="testResults_${i.index}" class="modal fade" role="dialog">
												<div class="modal-dialog text-left">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
															<h4 class="modal-title">Odpowiedzi w teście</h4>
														</div>
														<div class="modal-body">
															<c:forEach items="${r.answers}" var="a">
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
																		<div class="panel-footer" style="font-weight: bold; font-size: 11px; color: #DD0000">Zaznaczono złą
																			odpowiedź lub nie wszystkie zaznaczone odpowiedzi są prawidłowe.</div>
																	</c:if>

																</div>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="questions" class="tab-pane fade">
						<h3>Moje Pytania</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Treść</th>
									<th>Kategoria</th>
									<th>Poziom trudności</th>
									<th>Rodzaj</th>
									<th>Akceptacja</th>
									<th>Akcje</th>
								</tr>
							</thead>
							<tbody>
								<!-- TODO: moje pytania -->
							</tbody>
						</table>
						<form action="/java-quiz-academy/question/newQuestion">
							<button type="submit" class="btn btn-default btn-xs">Nowe Pytanie</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>