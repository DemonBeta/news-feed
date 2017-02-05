<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<spring:url value="/news/edit" var="formUrl" />

	<div class="container">
		<div class="row">
			<ul>
				<h1>Latest News</h1>
				<c:forEach items="${news}" var="newsEntry">
					<form:form action="${formUrl}" method="post"
						modelAttribute="newsEntry">
						<li class="list-group-item"><label>${newsEntry.header}</label>
							<small>Post date: ${newsEntry.postDate}</small>
							<button type="submit" class="btn btn-default pull-right"
								name="delete" value="${newsEntry.newsId}">Delete</button>
							<button type="submit" class="btn btn-default pull-right"
								name="edit" value="${newsEntry.newsId}">Edit</button>
							<p>
								<span>Tag: ${newsEntry.tag}</span>
							</p>
							<p>
								<span>${newsEntry.content}</span>
							</p>
					</form:form>
				</c:forEach>
			</ul>
		</div>
	</div>

</body>
</html>