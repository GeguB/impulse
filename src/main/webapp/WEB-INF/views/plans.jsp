<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
						<table class="table table-hover">
							<tr>
								<th width="120">Plan Type</th>
								<th width="80">Plan ID</th>
								<th width="200">Plan Name</th>
								<th width="120">Plan Value</th>
								<th width="120">Plan Price</th>
								<th width="100"></th>
							</tr>
							<c:forEach items="${listPlans}" var="plan">
								<c:choose>
									<c:when test="${plan.type == 'text'}">
										<c:set var="unit" value="Texts" />
									</c:when>
									<c:when test="${plan.type == 'call'}">
										<c:set var="unit" value="minutes" />
									</c:when>
									<c:when test="${plan.type == 'transfer'}">
										<c:set var="unit" value="KB" />
									</c:when>
									<c:otherwise>
										<c:set var="unit" value="" />
									</c:otherwise>
								</c:choose>
								<tr>
								<form:form action="transaction" method="post">
									<td>${plan.type}</td>
									<td>${plan.id}<input type="hidden" name="planid" value="${plan.id}" /></td>
									<td>${plan.name}</td>
									<td>${plan.value} <c:out value="${unit}" /></td>
									<td>${plan.price}</td>
									<td>		
									
									<input type="submit" name="transaction" class="btn btn-round btn-default" value="Buy!" /></td>
								</form:form>
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