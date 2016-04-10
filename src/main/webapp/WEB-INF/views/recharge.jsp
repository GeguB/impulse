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
					class="bold">${user.account}</span><br /> <br />Recharge your
				account with:
				<c:url var="recharge" value="/rechargeWith"></c:url>
				<form:form method="POST" action="${recharge}" commandName="user">
					<input name="price" type="number" step="0.1"/>
					<input type="submit" value="<spring:message text="Recharge!"/>" />
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
