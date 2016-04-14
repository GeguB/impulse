<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#content:before {
	content: "\f155 ";
}
</style>
<html>
<head>
<title>Browse for a new deal</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
		<%@ include file="/WEB-INF/views/sidebar.jsp"%>
	</sec:authorize>
	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				<c:choose>
					<c:when test="${!empty listPlans}">
						<table class="tg">
							<tr>
								<th width="80">Plan ID</th>
								<th width="120">Plan Name</th>
								<th width="120">Plan Price</th>
							</tr>
							<c:forEach items="${listPlans}" var="plan">
								<tr>
									<td>${plan.id}</td>
									<td>${plan.name}</td>
									<td>${plan.price}</td>
								</tr>
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