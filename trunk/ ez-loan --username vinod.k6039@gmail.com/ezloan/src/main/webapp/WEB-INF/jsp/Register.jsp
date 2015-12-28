<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!--  All this done by me !! -->

<head>
<link rel="icon" type="image/png" href="favicon.png"></link>
<link rel="icon" type="image/gif" href="images/animated_favicon1.gif" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css" />
<!--  JAVA SCRIPT!! These are where all the -->
<script src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="${pageContext.request.contextPath}/js/libs/jquery-1.4.2.js"%3E%3C/script%3E'))</script>
<script src="${pageContext.request.contextPath}/js/jquery.flip.js"></script>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
<link rel="icon" type="image/gif" href="${pageContext.request.contextPath}/images/animated_favicon1.gif" />


<title>eZ Loan | Register</title>


</head>
<body>
	<div class="wrapper">
		<div id="banner">
			<img src="${pageContext.request.contextPath}/images/logo.png" />

			<h3>Welcome to eZ Loan: Register</h3>




			<div id="albums">
				<div id="login">

					<form:form method="post" onsubmit="return checkData()"
						commandName="CUSTOMER">

						<table align="center" size="120" border="0">
							<tr>
								<td>CustumerName</td>
								<td><input type="text" name="name" id="t1" size="33"></td>
							</tr>


							<tr>
								<td>User Name</td>
								<td><input type="text" name="uname" id="t1" size="33"></td>
							</tr>


							<tr>
								<td>Password</td>
								<td><input type="password" name="password" id="t1"
									size="33"></td>
							</tr>


							<tr>
								<td>Address</td>
								<td><textarea rows="3" cols="25" name="address" id="t2"></textarea></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email" id="t3" size="33"></td>
							</tr>




							<tr>
								<td>SSN</td>
								<td><input type="text" name="ssn" id="t4" size="33"></td>
							</tr>

							<tr>
								<td>Occupation</td>
								<td><input type="text" name="occupation" id="t5" size="33"></td>
							</tr>




							<tr>
								<td>Company/Business</td>
								<td><input type="text" name="company" id="t6" size="33"></td>
							</tr>




							<tr>
								<td>Business Address</td>
								<td><textarea rows="3" cols="25" name="caddress" id="t7"
										size="33"></textarea></td>
							</tr>
							<tr>
								<td>Contact No</td>
								<td><input type="text" name="contact" id="t8" size="33"
									maxlength="12"></td>
							</tr>
							<tr>
								<td>Salary Per Annum</td>
								<td><input type="text" name="salary" id="t9" size="33"></td>
							</tr>

							<!-- <tr>
	<td>Designation</td>
	<td><input type="text" name="Designation" id="t10"></td>
</tr> -->


							<tr>
								<td>Gender</td>
								<td><input type="radio" name="gender" checked="true"
									value="male">Male <input type="radio" name="gender"
										value="female">Female</td>
							</tr>

							<tr>

								<td align="center" colspan="2"><input type="submit"
									value="Register" id="submit"></td>
								<!--
	Some Dynamic Control Here
	<input type="hidden" name="bank">   -->
							</tr>

						</table>
					</form:form>
					<button type="submit" id="submit2"
						onclick="window.location.href='${pageContext.request.contextPath}/auth/logout.htm'">Go Back</button>
					<div id="content"></div>
</body>
</html>
