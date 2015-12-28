<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!--  All this done by me !! -->

<head>
<link rel="icon" type="image/png" href="images/fav.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addBank.css" />
<!--  JAVA SCRIPT!! These are where all the -->
<script src="js/jquery-1.4.2.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="js/libs/jquery-1.4.2.js"%3E%3C/script%3E'))</script>
<script src="js/jquery.flip.js"></script>

<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="icon" type="image/gif" href="${pageContext.request.contextPath}/images/animated_favicon1.gif" />


<title>eZ Loan |Update Bank</title>


</head>
<body>
	<div class="wrapper">
		<div id="banner">
			<img src="${pageContext.request.contextPath}/images/logo.png" />

			<h3>Update Bank</h3>




			<div id="albums">
				<div id="login">
					<form action="${pageContext.request.contextPath}/admin/updateBank.htm?updateId=${bankById.bankId}"
						method="post" onsubmit="return checkData()">

						<table align="center" size="120" border="0">

							<tr>

								<td>Id</td>
								<td>${bankById.bankId}</td>
							</tr>

							<tr>

								<td>Name</td>
								<td><input type="text" value="${bankById.name}" name="name"
									id="t1" size="33"></td>
							</tr>


							<tr>
								<td>Branch</td>
								<td><input type="text" value="${bankById.branch}"
									name="branch" id="t1" size="33"></td>
							</tr>



							<tr>
								<td>Address</td>
								<td><textarea rows="3" cols="25" name="address" id="t2">${bankById.address}</textarea></td>
							</tr>
							<tr>
								<td>Contact</td>
								<td><input type="text" value="${bankById.contact}"
									name="contact" id="t3" size="33"></td>
							</tr>





							<tr>

								<td align="center" colspan="2"><input type="submit"
									value="Update" class="button"></td>
							</tr>

						</table>
					</form>

					<button type="submit" class="button"
						onclick="window.location.href='${pageContext.request.contextPath}/admin/banks.htm'">Go Back</button>
				</div>
			</div>
		</div>
	</div>
	<div id="content"></div>

</body>
</html>