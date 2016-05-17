<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#content:before {
	content: "\f007";
}
</style>
<html>

<title>${user.username}'sprofile</title>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/sidebar.jsp"%>

	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				<table class="table">
					<thead>
						<tr>
							<th>Parameter</th>
							<th>Value</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>User ID</td>
							<td>${user.id}</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>${user.username}</td>
						</tr>
						<tr>
							<td>E-mail address</td>
							<td>${user.email}</td>
						</tr>
						<tr>
							<td>Phone number</td>
							<td><c:choose>
									<c:when test="${empty phone_number.number}">No phone number assigned to user</c:when>
									<c:otherwise>${phone_number.number}</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td>Role</td>
							<td>${user.roles_role}</td>
						</tr>
						<tr>
							<td>Total account</td>
							<td>${user.account} PLN</td>
						</tr>
						<tr>
							<td>Minutes left</td>
							<td>${user.minutes_left} minutes</td>
						</tr>
						<tr>
							<td>Texts left</td>
							<td>${user.texts_left} texts</td>
						</tr>
						<tr>
							<td>Data Transfer left</td>
							<td>${user.kb_left} KB</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>