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
				<section class="panel">
					<div class="panel-body">
						<div class="wrap_controls">
							<ul class="nav nav-pills"
								style="margin: 0px; padding: 0px; list-style-type: none; display: flex; justify-content: center; text-size: 15px">
								<li><a href=""><span class="calls">Calls</span></a></li>
								<li><a href="#"><span class="texts">Texts</span></a></li>
								<li><a href="#"><span class="dataTransfer">DataTransfer</span></a></li>
							</ul>
						</div>
					</div>
				</section>
				<div id="calls">
					<c:choose>
						<c:when test="${!empty callList}">
							<table class="tg">
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
										<td><c:out value="${hours}" />:<c:out value="${minutes}" />:<c:out
												value="${seconds}" /></td>
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
				<div id="texts">
					<c:choose>
						<c:when test="${!empty textList}">
							<table class="tg">
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
				<div id="dataTransfer">
					<c:choose>
						<c:when test="${!empty dataTransferList}">
							<table class="tg">
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

	<%@ include file="/WEB-INF/views/footer.jsp"%>
	<script src="static/js/history-hide.js" type="text/javascript"></script>

</body>
</html>