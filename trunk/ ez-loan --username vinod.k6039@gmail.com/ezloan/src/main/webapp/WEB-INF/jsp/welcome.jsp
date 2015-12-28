<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="icon" type="image/png" href="images/fav.png" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>eZ Loans | Welcome</title>
<!-- Reset CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css" />
<!-- Our CSS-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/banks.css" />
<!-- Java Scripts-->

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.animated.innerfade.js"></script>


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



		<li><a href="${pageContext.request.contextPath}/admin/banks.htm" title="Banks">Banks</a> <!--  This will be a controller URI -->
			<ul>
				<!-- <li><a href="#">Chase</a></li>
	<li><a href="#">Bank Of America</a></li> -->
			</ul></li>

		<li><a href="${pageContext.request.contextPath}/admin/getdepartments.htm" title="Departments">Departments</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/admin/populateEmp.htm">Employees</a></li>
			</ul></li>
		<li><a href="#" title="Tools">Tools</a>
			<ul>
				<li><a href="#">Application Status</a></li>
				<li><a href="#">Messages</a></li>
				<li><a href="#">Reports</a></li>

			</ul></li>

		<li><a href="#" title="Loans">Loans</a></li>

		<li><a href="${pageContext.request.contextPath}/admin/customers.htm" title="Customers">Customers</a></li>

		<li><a href="logout.htm" title="Log Out">Log Out</a></li>
	</ul>


	<div id="body">
		<h3 style="font-weight: bold;">New Customers:</h3>

		<form action="deleteBank.htm" method="post" id="bbbb">

			<table border="2" width="100%" align="center">
				<tr style="background-color: #2f99ca; color: white">
					<td><font size="4" color="white">ID </font></td>
					<td><font size="4" color="white">Name</font></td>
					<td><font size="4" color="white">Address</font></td>
					<td><font size="4" color="white">Email</font></td>
					<td><font size="4" color="white">Occupation</font></td>
					<td><font size="4" color="white">Company</font></td>
					<td><font size="4" color="white">Salary</font></td>
					<td></td>
					<td></td>

					<c:forEach items="${newCustomers}" var="item"
						varStatus="custStatus">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>

							<td>${item.address}</td>
							<td>${item.email}</td>
							<td>${item.occupation}</td>
							<td>${item.company}</td>
							<td>${item.salary}</td>
							<td><a
								href="customerDecision.htm?id=${item.id}&decision=APPROVED"
								id="go_button" class="go_button" />Approve</td>
							<td><a
								href="customerDecision.htm?id=${item.id}&decision=REJECTED"
								id="go_button" class="go_button" />Reject</td>

						</tr>

					</c:forEach>
				</tr>
			</table>
	</div>



</body>

</html>
