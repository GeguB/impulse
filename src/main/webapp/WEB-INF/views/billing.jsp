<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#content:before {
	content: "\f095";
}
</style>
<html>
<head>
<title>Billing</title>
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
					<c:when test="${!empty connList}">
<!-- 						<table class="tg"> -->
<!-- 							<tr> -->
<!-- 								<th width="80">From</th> -->
<!-- 								<th width="120">To</th> -->
<!-- 								<th width="120">Duration</th> -->
<!-- 								<th width="200">DateTime</th> -->
<!-- 							</tr> -->
<%-- 							<c:forEach items="${connList}" var="connection"> --%>
<%-- 								<fmt:parseNumber var="hours" value="${(connection.duration / 3600) % 24}" type="number" integerOnly="true"/> --%>
<%-- 								<fmt:parseNumber var="minutes" value="${(connection.duration / 60) % 60}" type="number" integerOnly="true"/> --%>
<%-- 								<fmt:parseNumber var="seconds" value="${connection.duration % 60}" type="number" integerOnly="true"/> --%>
<!-- 								<tr> -->
<%-- 									<td>${connection.phone_number}</td> --%>
<%-- 									<td>${connection.calling_to}</td> --%>
<%-- 									<td><c:out value="${hours}"/>:<c:out value="${minutes}"/>:<c:out value="${seconds}"/></td> --%>
<%-- 									<td>${connection.end_time}</td> --%>
<!-- 								</tr> -->
<%-- 							</c:forEach> --%>
<!-- 						</table> -->


						<table class="tg">
							<tr>
								<th width="80">From</th>
								<th width="120">To</th>
								<th width="200">DateTime</th>
							</tr>
							<c:forEach items="${connList}" var="text">
								<tr>
									<td>${text.phone_number}</td>
									<td>${text.sent_to}</td>
									<td>${text.sent_time}</td>
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