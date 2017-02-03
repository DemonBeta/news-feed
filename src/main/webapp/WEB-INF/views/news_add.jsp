<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Feed</title>

<script>
	var ctx = "${pageContext.request.contextPath}"
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/global.css"/>" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
<script src="<spring:url value="/resources/js/resource.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>News Entry</h1>
		</div>

		<spring:url value="/manage_news/save" var="formUrl" />
		<form:form action="${formUrl}" method="post" modelAttribute="newsEntry">

			<div class="row">

				<div class="form-group">
					<label for="resource-name">Header</label>
					<form:input path="header" cssClass="form-control" id="news-header" />
				</div>

				<div class="form-group">
					<label for="resource-type">Tag</label>
					<form:select path="type" cssClass="selectpicker" id="news-tag"
						items="${tagOptions}" />
				</div>

				<div class="form-group">
					<label for="notes">Content</label>
					<form:textarea path="content" cssClass="form-control" id="news-content"
						rows="4" />
				</div>

				<button type="submit" class="btn btn-default">Submit</button>

			</div>

		</form:form>

	</div>

</body>
</html>