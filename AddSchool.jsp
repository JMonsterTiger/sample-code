<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%AdminController ac = (AdminController)session.getAttribute("AdminController");
String name = request.getParameter("Name"); %>

<style>
body {
	font-family: "Lato", sans-serif;
}

html {align = center;
	
}

table {
	background: -webkit-linear-gradient(left, #5b6467,#2884bb);
	background: linear-gradient(to right, #5b6467,#2884bb);
	font-family: 'Roboto', sans-serif;
	width: 100%;
	table-layout: fixed;
	color: white;
	
}

.div2{
background-image: url(http://sydney.edu.au/dam/corporate/images/architecture/quadrangle/high-quad-shot1.jpg/_jcr_content/renditions/cq5dam.web.1440.960.2x.jpeg);

  /* Full height */
  height: 85%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;}	



section {
	margin: 50px; th { padding : 20px 15px;
	text-align: left;
	font-weight: 500;
	font-size: 12px;
	color: #fff;
	text-transform: uppercase;
}

td {
	padding: 15px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 12px;
	color: #fff;
	border-bottom: solid 1px rgba(255, 255, 255, 0.1);
	width: 100%;
	table-layout: fixed;
}

}

.tablink {
	float: left;
	  
	color: black;
	background: linear-gradient( 90deg,
      rgba(255, 225, 132, .7) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(32, 113, 120, .3) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(255, 150, 102, .3) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(23, 76, 79, .1) 50%, rgba(255,255,255, 0) 50%);
  background-size: 7em 7em, 5em 5em, 3em 3em, 1em 1em;
  background-color: #F5E9BE;

	border: none;
	outline: none;
	cursor: pointer;
	padding: 12px 12px;
	font-size: 17px;
	width: 25%;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	background-repeat: repeat-x;
}

.tablink:hover {
	  background: linear-gradient( 90deg,
      rgba(120,80,39,.9) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(32, 113, 120, .9) 50%, rgba(205,133,63, .8) 50%),
    linear-gradient( 90deg,
      rgba(255, 30, 102, .9) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(205,133,63, .9) 50%, rgba(255,255,255, 0) 50%);
  background-size: 7em 7em, 5em 5em, 3em 3em, 1em 1em;
  background-color: #F5E9BE;
	color: white;
	transition-delay: .1s;
}

/* Style the tab content */
.tabcontent {

	 background-size: 100%;

	text-align: center;
}


</style>


<body class = div2>

	<div class="tabcontent">
		<h1>Add University</h1>
		<p>Fill in all information and hit add when ready to submit.</p>
	</div>
	
	<form method="post" action="AdminMenu.jsp">
		<button class="tablink" >Profile Menu</button>

		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="Logout_action.jsp">
		<button class="tablink" >Logout</button>
		<input name="Logout" value="Log Out" type="hidden"> 
		<input name="Username" value=<%=name%> type="hidden">
	</form>



	<form method="post" action="AdminEdit.jsp">
		<button class="tablink"
			>Profile Settings</button>
    <input name="Edit" value="Your Profile" type="hidden">
    <input name="Username" value=<%=name%> type="hidden">
	</form>
	



<form method="post" action="AdminProfileMenu.jsp" name="Edit">
<button class="tablink" >List of Users</button>
    <input name="Edit" value="Profile List" type="hidden">
    <input name="Username" value=<%=name%> type="hidden">
</form>


    <form method="post" action="ListOfUniversities.jsp">
		<button class="tablink">Universities List</button>
		<input name="ViewSchools" value="View List of Schools" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>
	


	<form method="post" action="UniversityEditMenu.jsp">
		<button class="tablink"
			>Search to Edit</button>
		 <input name="SearchEdit" value="Search to Edit" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>



<form method="post" action="AddSchool.jsp" name="AddUniversity">

		<button class="tablink">Add University</button>
    <input name="AddUniversity" value="Add University" type="hidden">
    	<input name="Username" value=<%=name%> type="hidden">
</form>



	
<form>
		<button class="tablink"
			>...</button>
		
	</form>




</body>
<form method="post" action="AddSchool_action.jsp" name="addUser">
<table style="text-align: left; width: 100%;" border="1">
<tbody>
<tr>
<th>
Add University
</th>
<td align="right" colspan="1" rowspan="1" style="vertical-align: top;">
    <input name="AddSchool" value="Add University" type="submit">
</td>
</tr>
<tr>
<td>Name</td>
<td><input name="SchoolName" required>
</td>
</tr>
<tr>
<td>State</td>
<td><input name="State" required>
</td>
</tr>
<tr>
<td>Location</td>
<td><input name="Location"required>
</td>
</tr>
<tr>
<td>Control</td>
<td><input name="Control"required>
</td>
</tr>
<tr>
<td>AcadScale</td>
<td><input type="number"name="AcadScale"required min="1" max="5" >
</td>
</tr>
<tr>
<td>Expenses</td>
<td><input min="1" type="number"name="Expenses"required>
</td>
</tr>
<tr>
<td>Number Applied</td>
<td><input min="1" type="number"name="NumApply"required>
</td>
</tr>
<tr>
<td>Percent Admitted</td>
<td><input min="1" max="100" type="number"name="PercAdmit"required>
</td>
</tr>
<tr>
<td>Percent Aided</td>
<td><input min="1" max="100" type="number"name="PercAid"required>
</td>
</tr>
<tr>
<td>Percent Enrolled</td>
<td><input min="1" max="100" type="number"name="PercEnroll"required>
</td>
</tr>
<tr>
<td>Percentage of Females</td>
<td><input min="1" max="100" type="number"name="PercFemale"required>
</td>
</tr>
<tr>
<td>Quality of Life (out of 5)</td>
<td><input min="1" max="5" type="number"name="QualLife"required>
</td>
</tr>
<tr>
<td>SAT Math Score</td>
<td><input min="1" max="1600" type="number"name="SATMath"required>
</td>
</tr>
<tr>
<td>Social Scale (out of 5)</td>
<td><input min="1" max="5" type="number"name="SocialScale"required>
</td>
</tr>
<tr>
<td>Number of Students</td>
<td><input min="1" type="number"name="NumStudents"required>
</td>
</tr>
<tr>
<td>SAT Verbal Score</td>
<td><input min="1" max="1600" type="number"name="SATVerb"required>
</td>
</tr>
</tbody>
</table>
</form>
</html>