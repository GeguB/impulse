<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
#content:before {
	content: "\f129";
}
</style>
<html>

<title>About</title>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/sidebar.jsp"%>

	<br />
	<div id="main-content">
		<div id="content">
			<div class="inner">
				About...
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
	</body>
</html>
