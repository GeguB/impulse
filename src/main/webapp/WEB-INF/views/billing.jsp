<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<ul class="nav nav-pills">
					<li class="active"><a data-toggle="pill" href="#summary">Summary</a></li>
					<li><a data-toggle="pill" href="#calls">Calls</a></li>
					<li><a data-toggle="pill" href="#texts">Texts</a></li>
					<li><a data-toggle="pill" href="#dataTransfer">Data
							Transfer</a></li>
				</ul>

				<div class="tab-content">
					<div id="summary" class="tab-pane fade in active">
						<h3>Summary</h3>
						<table class="table">
							<tr>
								<th>Service</th>
								<th>Number of use</th>
								<th>Total value</th>
							<tr>
							<tr>
								<td>${callSum.type}</td>
								<td>${callSum.count}</td>
								<td><fmt:parseNumber var="hours"
										value="${(callSum.value / 3600) % 24}" type="number"
										integerOnly="true" /> <fmt:parseNumber var="minutes"
										value="${(callSum.value / 60) % 60}" type="number"
										integerOnly="true" /> <fmt:parseNumber var="seconds"
										value="${callSum.value % 60}" type="number" integerOnly="true" />
									<c:out value="${hours}" />h<c:out value="${minutes}" />m<c:out
										value="${seconds}" />s</td>
							</tr>
							<tr>
								<td>${textSum.type}</td>
								<td>${textSum.count}</td>
								<td>${textSum.value} texts</td>
							</tr>
							<tr>
								<td>${dtSum.type}</td>
								<td>${dtSum.count}</td>
								<td>${dtSum.value} KB</td>
							</tr>
						</table>
					</div>
					<div id="calls" class="tab-pane fade">
						<h3>Calls</h3>
						<c:choose>
							<c:when test="${!empty callList}">
								<table class="table">
									<tr>
										<th width="80">From</th>
										<th width="120">To</th>
										<th width="120">Duration</th>
										<th width="200">DateTime</th>
									</tr>
									<c:forEach items="${callList}" var="connection">
										<fmt:parseNumber var="hours"
											value="${(connection.duration / 3600) % 24}" type="number"
											integerOnly="true" />
										<fmt:parseNumber var="minutes"
											value="${(connection.duration / 60) % 60}" type="number"
											integerOnly="true" />
										<fmt:parseNumber var="seconds"
											value="${connection.duration % 60}" type="number"
											integerOnly="true" />
										<tr>
											<td>${connection.phone_number}</td>
											<td>${connection.calling_to}</td>
											<td><c:out value="${hours}" />:<c:out
													value="${minutes}" />:<c:out value="${seconds}" /></td>
											<td>${connection.end_time}</td>
										</tr>
									</c:forEach>
								</table>
							</c:when>
							<c:otherwise>
								<h1>No phone calls were made...</h1>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="texts" class="tab-pane fade">
						<h3>Texts</h3>
						<c:choose>
							<c:when test="${!empty textList}">
								<table class="table">
									<tr>
										<th width="80">From</th>
										<th width="120">To</th>
										<th width="200">DateTime</th>
									</tr>
									<c:forEach items="${textList}" var="text">
										<tr>
											<td>${text.phone_number}</td>
											<td>${text.sent_to}</td>
											<td>${text.sent_time}</td>
										</tr>
									</c:forEach>
								</table>
							</c:when>
							<c:otherwise>
								<h1>No text messages were sent...</h1>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="dataTransfer" class="tab-pane fade">
						<h3>Data Transfer</h3>
						<c:choose>
							<c:when test="${!empty dataTransferList}">
								<table class="table">
									<tr>
										<th width="80">From</th>
										<th width="120">Size</th>
										<th width="200">DateTime</th>
									</tr>
									<c:forEach items="${dataTransferList}" var="dt">
										<tr>
											<td>${dt.phone_number}</td>
											<td>${dt.size}KB</td>
											<td>${dt.use_time}</td>
										</tr>
									</c:forEach>
								</table>
							</c:when>
							<c:otherwise>
								<h1>No data transfer was used...</h1>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>