<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Feed</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp" />

	<div class="container">

		<div class="row">
			<h1>Edit News Entry</h1>
		</div>

		<spring:url value="/news/edit" var="formUrl" />
		<form:form action="${formUrl}" method="post" modelAttribute="newsEntry">

			<div class="row">

				<div class="form-group">
					<label for="news-header">Header</label>
					<form:input path="header" cssClass="form-control" id="news-header" />
					<form:errors path="header" cssStyle="color:red"/>
				</div>

				<div class="form-group">
					<label for="news-tag">Tag</label>
					<form:select path="tag" cssClass="selectpicker" id="news-tag"
						items="${tagOptions}" />
				</div>

				<div class="form-group">
					<label for="news-content">Content</label>
					<form:textarea path="content" cssClass="form-control" id="news-content"
						rows="4" />
						<form:errors path="content" cssStyle="color:red"/>
				</div>

				<button type="submit" class="btn btn-default">Edit</button>

			</div>

		</form:form>

	</div>
</body>
</html>