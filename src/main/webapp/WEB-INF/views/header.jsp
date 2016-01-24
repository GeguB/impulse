<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Bootstrap core CSS -->
<link href="static/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="static/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="static/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="static/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="static/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/style-responsive.css" rel="stylesheet">
<!--header start-->
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start-->
	<a href="landing" class="logo"><b>IMPULSE</b></a>
	<!--logo end-->
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><c:url value="/j_spring_security_logout" var="logoutUrl" />

				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form> <a class="logout" href="javascript:formSubmit()">Logout</a></li>
		</ul>
		<div class="nav notify-row" id="top_menu">
			<ul class="nav">
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<li class="pull-left col-md-4">Welcome,
							${pageContext.request.userPrincipal.name}</li>
						<li class="col-md-8">Your account balance: <p class="centered">${user.account}</p>
						</li>
					</c:when>
					<c:otherwise>
						<a href="login">Log in</a>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	Welcome to your profile ${user}
</header>

<!--header end-->
<br />
<br />
<br />
<br />