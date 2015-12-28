<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="icon" type="image/png" href="images/fav.png" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>eZ Loans | Home</title>
<!-- Reset CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css" />
<!-- Our CSS-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
<!-- Java Scripts-->

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.animated.innerfade.js"></script>
<script src="${pageContext.request.contextPath}/js/modernizr.custom.63321.js"></script>


<script type="text/javascript">
	   $(document).ready(
				function(){
						$('ul#animated-portfolio').animatedinnerfade({
						speed: 3000,<!--set speed-->
						timeout: 5000,<!--set Time-->
						type: 'sequence',<!--set type - sequence or random-->
						containerheight: '300px',
						containerwidth: '800px',
						animationSpeed: 2500,
						animationtype: 'fade',<!--Animation type - fade or slider-->
						bgFrame: 'none',
						controlBox: 'none',
						displayTitle: 'none'					});
			});
			
			
  	</script>

</head>


<body>
	<!--LOGO-->
	<div id="logo"></div>
	<!-- Navribbon -->
	<ul id="navribbon">



		<li><a href="#" title="Our Clients"><spring:message
					code="welcome.clients" /></a></li>




		<li><a href="#" title="Our Services">SERVICES</a></li>

		<li><a href="#" title="Come work for us !!">CAREERS</a></li>

		<li><a href="index.jsp" title="About Us">ABOUT</a></li>

		<li><a href="index.jsp" title="Contact Us">CONTACT</a></li>

	</ul>
	<div id="animation">

		<ul id="animated-portfolio">
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/banner.jpg" alt="eZ Loan"
					title="eZ Loan" /></a></li>
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/banner2.jpg" alt="eZ Loan"
					title="eZ Loan" /></a></li>
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/banner3.jpg" alt="eZ Loan"
					title="eZ Loan" /></a></li>

		</ul>
	</div>
	<div id="body">
		<div id="info">
			<p>&nbsp;</p>
			<h1>Why go eZ ?</h1>
			<br>
				<p align="justify">At eZ Loan, we invest in our communities and
					work with our community based partners to provide creative
					solutions that respond to local community development needs. Our In
					the Community e-newsletter highlights some of our initiatives and
					the impact we are having nationwide across the many communities we
					serve.</p>
		</div>

		<div id="login">
			<!-- <h1 align="right"> Log In</h1> -->

			<br> <!-- <form action="validate.htm" method="post">
				<p class="textInput">
					User ID &nbsp; &nbsp;&nbsp;&nbsp;<input type="text" name="username" class="textInput" /></p>
				<br>
				<p class="textInput">
					Password  &nbsp;&nbsp; <input type="password" name="password" class="textInput" />
				</p>
				<br>
			
				<input type="submit" value="Submit" id="submit" />
			</form> --> <section class="main">
				<form class="form-2"  action="../j_spring_security_check" method="post">
					<h1>
						<span class="log-in">Log in</span> or <span class="sign-up">sign
							up</span>
					</h1>
					<p class="float">
						<label for="login"><i class="icon-user"></i>Username</label> <input
							type="text" name="j_username" placeholder="Username or email">
					</p>
					<p class="float">
						<label for="password"><i class="icon-lock"></i>Password</label> <input
							type="password" name="j_password" placeholder="Password"
							class="showpassword">
					</p>
					<p class="clearfix">
						<a href="register.htm" class="log-twitter">Register</a> <input
							type="submit" name="submit" value="Log in">
					</p>
				</form>
				</section> <!-- <button type="submit" id="button" 
			onclick="JavaScript:window.location='register.htm';">Register</button> -->
		</div>
	</div>



</body>
<%@ include file="footer.jsp"%>
</html>
