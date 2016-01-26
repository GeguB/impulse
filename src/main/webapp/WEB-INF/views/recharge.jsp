<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
#content:before {
	content: "\f241";
}
</style>
<html>

<title>Recharge</title>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/sidebar.jsp"%>

	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				Recharge your account.<br /> Your current balance: <span
					class="bold">${user.account}</span><br /> <br />Recharge you
				account with:
				<c:url var="addAction" value="/user/add"></c:url>
				<form:form action="${addAction}" commandName="user">
					<form:input path="account" />
					<input type="submit" value="<spring:message text="Edit User"/>" />
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
