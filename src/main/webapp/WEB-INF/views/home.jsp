<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Feed</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
		<h2>Latest News</h2>

		<ul>
			<c:forEach items="${news}" var="newsEntry">
				<li class="list-group-item">
						<label>${newsEntry.header}</label> <small>${newsEntry.postDate}</small>									
						<button type="submit" class="btn btn-default pull-right" >Delete</button>
						<button type="submit" class="btn btn-default pull-right" >Edit</button>
					<p>
						<span>Tag: ${newsEntry.type}</span>
					</p>
					<p>
						<span>${newsEntry.content}</span>
					</p></li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>