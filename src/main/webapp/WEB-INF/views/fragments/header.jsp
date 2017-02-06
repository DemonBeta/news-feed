<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">News Feed</a>
		</div>

		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/"/>">All News</a></li>
			
			<li><a href="<spring:url value="/news/add"/>">Manage News</a></li>
		</ul>

		<spring:url value="/search" var="searchUrl" />
		<form:form action="${searchUrl}" method="post"
			modelAttribute="searchRequest">
			<ul class="nav navbar-nav navbar-right">
				<li>
				<form:select path="tag"
						cssClass="selectpicker" id="news-tag" items="${searchTagOptions}" />
				</li>
				<li><form:input path="header" cssClass="form-control"
						placeholder="Header" id="news-header" /></li>
				<li><form:input path="content" cssClass="form-control"
						placeholder="Content" id="news-content" /></li>
				<li>
					<button type="submit" class="btn btn-default">Search</button>
				</li>
			</ul>
		</form:form>

	</div>
</nav>