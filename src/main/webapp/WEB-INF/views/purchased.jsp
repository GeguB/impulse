<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#content:before {
	content: "\f09d";
}
</style>
<html>
<head>
<title>Purchase history</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
		<%@ include file="/WEB-INF/views/sidebar.jsp"%>
	</sec:authorize>
	<c:set var="count" value="1" scope="page" />
	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				Showing 10 latest transactions </br>
				<c:choose>
					<c:when test="${!empty dealsList}">
						<table class="table">
							<tr>
								<th width="100">No.</th>
								<th width="180">Transaction ID</th>
								<th width="100">Plan ID</th>
								<th width="150">Date of purchase</th>
							</tr>
							<c:forEach items="${dealsList}" var="deal">
								<c:choose>
									<c:when test="${count <= 10}">
										<tr>
											<td><i><c:out value="${count}" /></i></td>
											<td>${deal.id}</td>
											<td>${deal.plan_ID}</td>
											<td>${deal.made_time}</td>
										</tr>
										<c:set var="count" value="${count + 1}" scope="page" />
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h1>Nothing to show here!</h1>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>