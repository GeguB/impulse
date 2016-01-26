<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script class="include" type="text/javascript"
	src="static/js/jquery.dcjqaccordion.2.7.js"></script>
<aside>
	<div id="sidebar" class="nav-collapse"
		style="overflow: hidden; outline: none;" tabindex="5000">
		<ul class="sidebar-menu" id="nav-accordion">
			<li class="mt"><a href="index"><i class="fa fa-home"></i>Home
					page</a></li>
			<li><a href="profile"><i class="fa fa-user"></i>Profile</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="users"><i class="fa fa-users"></i>Manage users</a></li>
			</sec:authorize>
			<li><a href="recharge"><i class="fa fa-battery-three-quarters"></i>Recharge</a></li>
			<li><a href="billing"><i class="fa fa-phone"></i>Connection
					History</a></li>
			<li><a href="account"><i class="fa fa-credit-card"></i>Account
					History</a></li>
			<li><a href="plans"><i class="fa fa-usd"></i>Price Plans</a></li>
			<li><a href="contact"><i class="fa fa-phone"></i>Contact us</a></li>
			<li><a href="about"><i class="fa fa-info"></i>About</a></li>
		</ul>
	</div>
</aside>