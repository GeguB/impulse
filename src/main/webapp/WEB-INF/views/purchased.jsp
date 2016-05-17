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
	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				<c:choose>
					<c:when test="${!empty dealsList}">
						<table class="tg">
							<tr>
								<th width="120">Deal ID</th>
								<th width="80">User ID</th>
								<th width="80">Plan ID</th>
							</tr>
							<c:forEach items="${dealsList}" var="deal">
								<tr>
									<td>${deal.id}</td>
									<td>${deal.user_ID}</td>
									<td>${deal.plan_ID}</td>
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