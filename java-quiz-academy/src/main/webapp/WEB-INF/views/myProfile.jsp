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
	function setCursor(element, cursor) {
		element.style.cursor = cursor;
	}
	function orderBy(field) {
		$("#questionContextSortBy").val(field);
		$("#questionContextForm").submit();
	}
	function usePageSize(size) {
		$("#questionContextPageSize").val(size);
		$("#questionContextForm").submit();
	}
	function usePageNumber(number){
		$("#questionContextPageNumber").val(number);
		$("#questionContextForm").submit();
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<sec:authentication var="user" property="principal" />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading" style="font-weight: bold;">Witaj: ${user.name}</div>
			<div class="panel-body">
				<ul class="nav nav-tabs">
					<li <c:if test="${activeTab=='profile'}"> class="active" </c:if>><a data-toggle="tab" href="#home">Mój profil</a></li>
					<li <c:if test="${activeTab=='tests'}"> class="active" </c:if>><a data-toggle="tab" href="#tests">Moje Testy</a></li>
					<li <c:if test="${activeTab=='questions'}"> class="active" </c:if>><a data-toggle="tab" href="#questions">Moje
							Pytania</a></li>
				</ul>
				<div class="tab-content">
					<div id="home" class="tab-pane fade<c:if test="${activeTab=='profile'}"> in active</c:if>">
						<h3>Moj profil</h3>
						<p>....</p>
					</div>
					<div id="tests" class="tab-pane fade<c:if test="${activeTab=='tests'}"> in active</c:if>">
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
					<div id="questions" class="tab-pane fade<c:if test="${activeTab=='questions'}"> in active</c:if>">
						<h3>Moje Pytania</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th class="col-sm-6" onmouseover="setCursor(this, 'pointer')" onmouseout="setCursor(this, 'default')"
										onclick="orderBy('text')">Treść <span class="glyphicon glyphicon-chevron-up" style="padding-left: 90%;"></span></th>
									<th class="col-sm-1" onmouseover="setCursor(this, 'pointer')" onmouseout="setCursor(this, 'default')"
										onclick="orderBy('area.name')">Kategoria</th>
									<th class="col-sm-2" onmouseover="setCursor(this, 'pointer')" onmouseout="setCursor(this, 'default')"
										onclick="orderBy('level')">Poziom trudności</th>
									<th class="col-sm-1" onmouseover="setCursor(this, 'pointer')" onmouseout="setCursor(this, 'default')"
										onclick="orderBy('active')">Akceptacja</th>
									<th class="col-sm-2">Akcje</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="4" align="center">
										<ul class="pagination pagination-sm">
											<c:forEach begin="1" end="${quesionContext.totalPages}" varStatus="status">
												<li <c:if test="${quesionContext.pageNumber == status.index-1}">class="active"</c:if>><a href="#" onclick="usePageNumber(${status.index-1})">${status.index}</a></li>
											</c:forEach>
										</ul>
									</td>
									<td colspan="1" align="right">Pokaż w tabeli:<select class="form-control"
										style="width: 75px;" id="pageSizeQuestionsPick" onchange="usePageSize(this.value)">
											<option <c:if test="${quesionContext.pageSize == 1}">selected="selected"</c:if>>1</option>
											<option <c:if test="${quesionContext.pageSize == 5}">selected="selected"</c:if>>5</option>
											<option <c:if test="${quesionContext.pageSize == 10}">selected="selected"</c:if>>10</option>
											<option <c:if test="${quesionContext.pageSize == 20}">selected="selected"</c:if>>20</option>
									</select>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="q" items="${quesionContext.result}">
									<tr>
										<td>${q.text}</td>
										<td>${q.area.name}</td>
										<td>${q.level.text}</td>
										<td><c:if test="${q.active}">
												<input type="checkbox" disabled="disabled" checked="checked" />
											</c:if> <c:if test="${!q.active}">
												<input type="checkbox" disabled="disabled" />
											</c:if></td>
										<td><a href="#"> <span class="glyphicon glyphicon-remove"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<form action="/java-quiz-academy/user/me" id="questionContextForm">
							<input type="hidden" id="questionContextSortBy" name="sortBy" value="${quesionContext.sortBy}" /> <input type="hidden"
								id="questionContextLastSortBy" name="lastSortBy" value="${quesionContext.lastSortBy}" /> <input type="hidden"
								id="questionContextPageSize" name="pageSize" value="${quesionContext.pageSize}" /> <input type="hidden"
								id="questionContextPageNumber" name="pageNumber" value="${quesionContext.pageNumber}" /> <input type="hidden"
								id="questionContextSortDirection" name="sortDirection" value="${quesionContext.sortDirection}" /> <input type="hidden"
								name="activeTab" value="questions" />
						</form>
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