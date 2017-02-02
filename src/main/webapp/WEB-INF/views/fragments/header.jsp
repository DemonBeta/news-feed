<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">News Feed</a>
		</div>

		<ul class="nav navbar-nav">

			<li><a href="<spring:url value="/"/>">All News</a></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">Manage
					News <span class="caret"></span>
			</a>

				<ul class="dropdown-menu" role="menu">
					<li><a href="<spring:url value="/project/add"/>">Add</a></li>
					<li><a href="<spring:url value="/project/find"/>">Find</a></li>
				</ul></li>

		</ul>
	</div>
</nav>