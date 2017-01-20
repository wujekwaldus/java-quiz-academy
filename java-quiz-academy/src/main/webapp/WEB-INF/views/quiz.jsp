<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Java Academy Quiz</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Java Academy Quiz</h1>
		<p>Sprawdź na jakim poziomie jest Twoja wiedza z programowania!</p>
	</div>
	<div class="container">
		<c:forEach items="${questions}" var="q">
			<div class="panel panel-default">
				<div class="panel-heading" style="font-weight: bold;">${q.text}</div>
				<div class="panel-body">

					<c:forEach var="o" items="${q.options}">
						<div class="row" style="margin-left: 20px;">
							<c:if test="${q.type=='SINGLE_CHOICE'}">
								<input type="radio" name="answer_${q.id }" value="${o.id}" />${o.text}
						</c:if>
							<c:if test="${q.type=='MULTIPLE_CHOICE'}">
								<input type="checkbox" name="answer_${q.id }" value="${o.id}" />${o.text}
						</c:if>
						</div>
					</c:forEach>
				</div>
				<div class="panel-footer" style="font-weight: bold; font-size: 10px;">${q.area.text}</div>
			</div>
		</c:forEach>
	</div>



</body>
</html>