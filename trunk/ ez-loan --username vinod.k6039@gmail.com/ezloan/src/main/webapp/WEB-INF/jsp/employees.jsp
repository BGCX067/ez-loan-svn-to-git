<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="icon" type="image/png" href="images/fav.png" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>eZ Loans | Employees</title>
<!-- Reset CSS -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css" />
<!-- Our CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/banks.css" />

<!-- Java Scripts-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.animated.innerfade.js"></script>

<!-- <script src="http://jqueryjs.googlecode.com/files/jquery-1.2.6.min.js"
	type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/js/popup.js" type="text/javascript"></script>



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

						 $("select[id$='selecteddept']").change(function() {
						//	alert("______WELCOME_______");		
							 //alert("Mot!");
							 var departmentName= $("select[id$='selecteddept']").val();
							 var row="";
							 //alert("pselectedAnswerId = "+pselectedAnswerId);
							 $.getJSON("${pageContext.request.contextPath}/admin/employeeByDepartmentName.htm", { departmentName: departmentName}, function(jsonResponse) {
								 if(!jQuery.isEmptyObject(jsonResponse)) {
									 
									  row="<table border=\"2\" width=\"100%\" align=\"center\">"+
										"<tr style=\"background-color: #2f99ca; color: white\">"+
											"<td><font size=\"4\" color=\"white\">ID </font></td>"+
											"<td><font size=\"4\" color=\"white\">Name</font></td>"+
											"<td><font size=\"4\" color=\"white\">Designation</font></td>"+
											"<td><font size=\"4\" color=\"white\">Email</font></td>"+
											"<td><font size=\"4\" color=\"white\">Contact</font></td>"+
											"<td><font size=\"4\" color=\"white\">Department</font></td>"+
											"<td></td>"+
										"</tr>";
									 
										 jQuery.each(jsonResponse, function(i, val) {
											 jQuery.each(val, function(i, employee) {
											//	alert("NAme = "+employee['empName']);
												//##################################//
												//##################################//
												//##################################//
												//##################################//		
                                                //###########MMMMMMMMMM///////////////
                                                //###################################
                                                //###################################
                                                //
												row=row+"<tr>"+
												"<td>"+employee['empId']+"</td>"+
												"<td><a href=\"goToUpdate.htm?updateId="+employee['empId']+"\">"+employee['empName']+"</td>"+
												"<td>"+employee['designation']+"</td>"+
												"<td>"+employee['email']+"</td>"+
												"<td>"+employee['contact']+"</td>"+
												"<td>"+employee['department']+"</td>"+
												"<td><input type=\"checkbox\" value=\""+employee['empId']+"\" name=\"checkboxids\""+"/></td>"+
											    "</tr>";
											 });			 
					        			}); //end of the for each loop
					        			 $('#dTableSection').html(row);
									//	 alert("Row____"+row);
					       		 }  //end of if loop checking the null condition
					       	 });
						});	 
			});
			
			
  	</script>

</head>


<body>
	<!--LOGO-->
	<div id="logo"></div>
	<!-- Navribbon -->
	<ul id="navribbon">

		<!-- hello this a test -->


		<li><a href="${pageContext.request.contextPath}/auth/goHome.htm" title="Home">Home</a>
			<ul>
				<!-- <li><a href="#">Chase</a></li>
	<li><a href="#">Bank Of America</a></li> -->
			</ul></li>

		<li><a href="${pageContext.request.contextPath}/admin/banks.htm" title="Banks">Banks</a>
			<ul>
			</ul></li>
		<li><a href="#" title="Employees">Tools</a>
			<ul>
				<li><a href="#">Application Status</a></li>
				<li><a href="#">Messages</a></li>
				<li><a href="#">Reports</a></li>

			</ul></li>

		<li><a href="#" title="Loans">Loans</a></li>

		<li><a href="#" title="Customers">Customers</a></li>

		<li><a href="${pageContext.request.contextPath}/auth/logout.htm" title="Log Out">Log Out</a></li>
	</ul>

	<div id="body">

		<form:form name="empbydept" id="empbydept" action="${pageContext.request.contextPath}/admin/empByDept.htm"
			method="get" commandName="formItems">
			<h4>
				Employees:&nbsp;
				<form:select path="selecteddept" size="1">
					<form:options items="${departmentList}" itemValue="name"
						itemLabel="name" />
				</form:select>

				<!--
		<select name="selecteddept" id="selecteddept" onchange="document.empbydept.submit()"> 
			<option>Select Employees</option>
			<option>ALL</option>
			<c:forEach items="${departmentList}" var="dept" varStatus="deptStatus">
  			<option>${dept.name} </option>
  			</c:forEach>
		</select>
		
		
		-->
			</h4>

		</form:form>


		<button type="submit" id="button" value="vinod">Add Employee</button>
		<button class="button"
			onclick='document.getElementById("bbbb").submit()'>Delete
			Employee</button>
		<button id="button"
			onclick="JavaScript:window.location='getdepartments.htm';"
			value="departments">Departments</button>
		<!--  POPUP STARTS HERE--------------------------------------------------------- -->

		<div id="popupContact">
			<a id="popupContactClose">x</a>
			<h1>Add Employee</h1>
			<p id="contactArea">


				<form:form action="${pageContext.request.contextPath}/admin/addEmp.htm" method="post">

					<table align="center" size="120" border="0">
						<tr>
							<td>Name</td>
							<td><input type="text" name="empName" id="t1" size="33"></td>
						</tr>


						<tr>
							<td>Designation</td>
							<td><input type="text" name="designation" id="t1" size="33"></td>
						</tr>

						<tr>
							<td>Email</td>
							<td><input type="text" name="email" id="t1" size="33"></td>
						</tr>

						<tr>
							<td>Contact</td>
							<td><input type="text" name="contact" id="t3" size="33"></td>
						</tr>

						<tr>
							<td>Department</td>
							<td><select name="department">
									<c:forEach items="${departmentList}" var="dept"
										varStatus="deptStatus">
										<option>${dept.name}</option>
									</c:forEach>
							</select></td>

							<%-- <td>Id</td>
							<td><select name="department">
							<c:forEach items="${departmentList}" var="dept" varStatus="deptStatus">
  										<option>${dept.deptId}</option>
  							</c:forEach>
								</select></td> --%>
						</tr>

						<tr>

							<td align="center" colspan="2"><input type="submit"
								value="Add" class="button"></td>
							<!--
	Some Dynamic Control Here
	<input type="hidden" name="bank">   -->
						</tr>

					</table>
				</form:form>


			</p>
		</div>

		<div id="backgroundPopup"></div>
		<!-- Popup ends here -->
		<br></br>



		<form action="deleteBank.htm" method="post" id="bbbb">

			<div id="dTableSection">

				<table border="2" width="100%" align="center">
					<tr style="background-color: #2f99ca; color: white">
						<td><font size="4" color="white">ID </font></td>
						<td><font size="4" color="white">Name</font></td>
						<td><font size="4" color="white">Designation</font></td>
						<td><font size="4" color="white">Email</font></td>
						<td><font size="4" color="white">Contact</font></td>
						<td><font size="4" color="white">Department</font></td>
						<td></td>
					</tr>

					<c:forEach items="${empList}" var="item" varStatus="bankStatus">
						<tr>
							<td>${item.empId}</td>
							<td><a href="${pageContext.request.contextPath}/admin/goToUpdate.htm?updateId=${item.empId}">${item.empName}</td>
							<td>${item.designation}</td>
							<td>${item.email}</td>
							<td>${item.contact}</td>
							<td>${item.department}</td>
							<td><input type="checkbox" value="${item.empId}"
								name="checkboxids" /></td>
						</tr>

					</c:forEach>
					<!--  This will dynamically generate the bank details -->
				</table>
			</div>

			<!-- <button type="submit" class="deletebutton"
			onclick="JavaScript:window.location='deleteBank.htm' ;">Delete
			Bank</button> -->



		</form>

	</div>

	<div id="content"></div>
	<%@ include file="footer.jsp"%>
</body>

</html>