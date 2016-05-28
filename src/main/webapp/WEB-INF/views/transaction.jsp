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
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:choose>
					<c:when test="${!empty plan}">
						You have bought ${plan.name} for price of ${plan.price} PLN. Your account balance is now ${user.account} PLN.
						<br />Transaction ID is ${deal.id}
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>