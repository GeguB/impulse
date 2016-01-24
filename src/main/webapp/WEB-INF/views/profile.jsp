<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<%@ include file="/WEB-INF/views/top_bar.jsp"%>
	<br />
	<br />
	<br /> Welcome to your profile ${user}
	<br /> Current time is: ${time}
</body>
</html>