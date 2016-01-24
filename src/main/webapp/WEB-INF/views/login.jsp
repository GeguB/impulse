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




</head>
<body onload='document.loginForm.username.focus();'>
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name == null}">
			<div class=title>Impulse - mobile network provider</div>
			<div id="login-page">
				<div class="container">
					<form name='loginForm' class="form-login"
						action='j_spring_security_check' method='POST'>
						<h2 class="form-login-heading">Login with Phone number and
							Password</h2>
						<div class="login-wrap">
							<c:if test="${not empty error}">
								<div class="error">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="msg">${msg}</div>
							</c:if>
							<input type="text" class="form-control" placeholder="User ID"
								name='username' autofocus> <br> <input
								type="password" class="form-control" placeholder="Password"
								name='password'> <label class="checkbox"> <span
								class="pull-right"> <a data-toggle="modal"
									href="login.html#myModal">Forgot Password?</a>
							</span>
							</label>
							<button class="btn btn-theme btn-block" type="submit"
								name="submit" value="submit">
								<i class="fa fa-lock"></i> SIGN IN
							</button>
							<hr>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<div class="login-social-link centered">
							<p>or you can sign in via your social network</p>
							<button class="btn btn-facebook" type="submit">
								<i class="fa fa-facebook"></i> Facebook
							</button>
							<button class="btn btn-twitter" type="submit">
								<i class="fa fa-twitter"></i> Twitter
							</button>
						</div>

						<div class="registration">
							Don't have an account yet?<br /> <a class="" href="register">
								Create an account </a>
						</div>
					</form>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/views/header.jsp"%>
			<div class="container">
				<h1>YOU ARE ALREADY LOGGED IN
					${pageContext.request.userPrincipal.name}, YOU DUMBFUCK!</h1>
				<c:url value="/j_spring_security_logout" var="logoutUrl" />

				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<h1>
					<a class="logout" href="javascript:formSubmit()"> LOG YO'SELF
						THE FUCK AWAY!</a>
				</h1>
			</div>
		</c:otherwise>
	</c:choose>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value='/static/js/jquery.js' />"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>

</body>
</html>