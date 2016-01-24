<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<br />
	<br />
	<br /> Your user id: ${user.id}
	<br /> Your username: ${user.username}
	<br /> Your registered email: ${user.email}
	<br /> Your account balance: ${user.account}
	<br /> ${user.enabled}
	<br /> ${user.roles_role}	
	<br /> ${user.password}
	
	<br /> Current time is: ${time}
</body>
</html>