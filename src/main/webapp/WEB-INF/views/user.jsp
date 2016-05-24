<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
#content:before {
	content: "\f0c0";
}
</style>
<html>
<head>
<title>Manage User - Admin Page</title>

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
				<div class="centered">
					<h1>Manage Users</h1>
					<c:url var="addAction" value="/user/add"></c:url>
<%-- 					<form:form action="${addAction}" commandName="user"> --%>
<!-- 						<table> -->
<%-- 							<c:if test="${!empty users.username}"> --%>
<!-- 								<tr> -->
<%-- 									<td><form:label path="ID"> --%>
<%-- 											<spring:message text="ID" /> --%>
<%-- 										</form:label></td> --%>
<%-- 									<td><form:input path="id" readonly="true" size="8" --%>
<%-- 											disabled="true" /> <form:hidden path="id" /></td> --%>
<!-- 								</tr> -->
<%-- 							</c:if> --%>
<!-- 							<tr> -->
<%-- 								<td><form:label path="username"> --%>
<%-- 										<spring:message text="Name" /> --%>
<%-- 									</form:label></td> --%>
<%-- 								<td><form:input path="username" /></td> --%>
<!-- 							</tr> -->
<!-- 							<tr> -->
<%-- 								<td><form:label path="email"> --%>
<%-- 										<spring:message text="email" /> --%>
<%-- 									</form:label></td> --%>
<%-- 								<td><form:input path="email" /></td> --%>
<!-- 							</tr> -->
<!-- 							<tr> -->
<%-- 								<td><form:label path="password"> --%>
<%-- 										<spring:message text="password" /> --%>
<%-- 									</form:label></td> --%>
<%-- 								<td><form:input path="password" /></td> --%>
<!-- 							</tr> -->
<!-- 							<tr> -->
<%-- 								<td colspan="2"><c:if test="${!empty user.username}"> --%>
<!-- 										<input type="submit" -->
<%-- 											value="<spring:message text="Edit User"/>" /> --%>
<%-- 									</c:if> <c:if test="${empty user.username}"> --%>
<%-- 										<input type="submit" value="<spring:message text="Add User"/>" /> --%>
<%-- 									</c:if></td> --%>
<!-- 							</tr> -->
<!-- 						</table> -->
<%-- 					</form:form> --%>
				</div>
				<c:if test="${!empty listUsers}">
					<table class="tg">
						<tr>
							<th width="80">User ID</th>
							<th width="120">User Name</th>
							<th width="120">User email</th>
							<th width="120">Password</th>
							<th width="120">Is enabled?</th>
							<th width="120" colspan="2">Actions</th>
						</tr>
						<c:forEach items="${listUsers}" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.username}</td>
								<td>${user.email}</td>
								<td>${user.password}</td>
								<td><c:if test="${user.enabled == 1}">True</c:if> <c:if
										test="${user.enabled == 0}">False</c:if></td>
<%-- 								<td><a href="<c:url value='/edit/${user.username}' />">Edit</a></td> --%>
								<td><a href="<c:url value='/remove/${user.username}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>