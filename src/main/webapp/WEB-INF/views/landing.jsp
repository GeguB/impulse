<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Landing page</title>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/sidebar.jsp"%>
	<div class="centered" id="main-content">
		<h2>Welcome to teh landing page</h2>
		<a href="profile">
			<div class="col-md-4">
				<div class="white-panel">
					<div class="white-header">My profile</div>
					<div class="box2"><span class="fa fa-user"></span></div>
				</div>
			</div>
		</a> <a href="billing">
			<div class="col-md-4">
				<div class="white-panel">
					<div class="white-header">Connection History</div>
					<div class="box2"><span class="fa fa-phone"></span></div>
				</div>
			</div>
		</a> <a href="account">
			<div class="col-md-4">
				<div class="white-panel">
					<div class="white-header">Account History</div>
					<div class="box2"><span class="fa fa-credit-card"></span></div>
				</div>
			</div>
		</a>
		<br />
		<div class="col-md-2"></div>
		<a href="plans">
			<div class="col-md-4">
				<div class="white-panel">
					<div class="white-header">Price plans</div>
					<div class="box2"><span class="fa fa-usd"></span></div>
				</div>
			</div>
		</a> <a href="contact">
			<div class="col-md-4">
				<div class="white-panel">
					<div class="white-header">Contact us</div>
					<div class="box2"><span class="fa fa-pencil-square-o"></span></div>
				</div>
			</div>
		</a>
		<div class="col-md-2"></div>
	</div>

	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>