<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#content:before {
	content: "\f007";
}
</style>
<html>

<title>${user.username}'s profile</title>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/sidebar.jsp"%>

	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				<br /> Your user id: ${user.id} <br /> Your username:
				${user.username} <br /> Your registered email: ${user.email} <br />
				Your account balance: ${user.account} <br />Role:
				${user.roles_role} <br /> Current time is: ${time}
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>