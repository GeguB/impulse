<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet">
<!--external css-->
<link href="<c:url value='/static/font-awesome/css/font-awesome.css' />"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet">
<link href="<c:url value='/static/css/style-responsive.css' />"
	rel="stylesheet">

<title>Register Page</title>

</head>
<body onload='document.loginForm.username.focus();'
	onload='document.loginForm.username.focus();'>


	<div class=title>Impulse - mobile network provider</div>
	<div id="login-page">
		<div class="container">

			<c:url var="registerAction" value="/register/new"></c:url>
			<form:form name='loginForm' class="form-login"
				action="${registerAction}" commandName="user">
				<h2 class="form-login-heading">Login with Phone number and
					Password</h2>

				<div class="login-wrap">
					<c:if test="${!empty users.username}">

						<form:label path="ID">
							<spring:message text="ID" />
						</form:label>

						<form:input path="id" readonly="true" size="8" disabled="true" />
						<form:hidden path="id" />

					</c:if>


					<form:input path="username" type="name" class="form-control"
						placeholder="username" name='username' />
					<br />
					<form:input path="email" type="email" class="form-control"
						placeholder="e-mail" name='email' />
					<br />
					<form:input path="password" type="password" class="form-control"
						placeholder="Password" name='password' />
					<form:input path="enabled" type="hidden" value="1" />
<%-- 					<form:input path="phone_number" type="hidden" value="8888888" /> --%>
					<form:input path="roles_role" type="hidden" value="ROLE_USER" />
					<br />

					<c:if test="${empty user.username}">
						<input type="submit" class="btn btn-theme btn-block"
							value="<spring:message text="Register"/>" />
					</c:if>
					<span>Don't have an account yet?<br /> <a class=""
						href="login"> Create an account </a>
					</span>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>