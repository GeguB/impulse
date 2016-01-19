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


<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

.title {
	margin-top: 30px;
	text-align: center;
	font-size: 45px;
}
</style>

</head>
<body onload='document.loginForm.username.focus();'>

	<div class=title> Impulse - mobile network provider</div>
	<div id="login-page">
		<div class="container">
			<form name='loginForm' class="form-login"
				action='j_spring_security_check' method='POST'>
				<h2 class="form-login-heading">Login with Phone number and Password</h2>

				<div class="login-wrap">
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<input type="text" class="form-control" placeholder="User ID" name='username' autofocus> 
					<br> 
					<input type="password" class="form-control" placeholder="Password" name='password'> 
					<label class="checkbox"> 
					<span class="pull-right"> <a data-toggle="modal" href="login.html#myModal">Forgot Password?</a>
					</span>
					</label>
					<button class="btn btn-theme btn-block" type="submit" name="submit"
						value="submit">
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
					Don't have an account yet?<br /> 
					<a class="" href="#"> Create an account </a>
				</div>
			</form>
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value='/static/js/jquery.js' />"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>

	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript"
		src="<c:url value='/static/js/jquery.backstretch.min.js' />">
		
	</script>
	<!-- 
	<script>
		$.backstretch("<c:url value='/static/img/login-bg.jpg' />", {
			speed : 500
		});
	</script>
	 -->
</body>
</html>