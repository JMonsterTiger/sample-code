<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<!DOCTYPE html>
<html>
<title>University Edit</title>
<%
AdminController ac = (AdminController)session.getAttribute("AdminController");
String name = request.getParameter("Name");
University univ = ac.getUniversity(name);
%>
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
		<h1>User List</h1>
		<p>Below is a list of all users.</p>
	</div>
	
	<form method="post" action="AdminMenu.jsp">
		<button class="tablink" >Profile Menu</button>

		<input name="Username" value="<%=name%>" type="hidden">
	</form>


	<form method="post" action="Logout_action.jsp">
		<button class="tablink" >Logout</button>
		<input name="Logout" value="Log Out" type="hidden"> 
		<input name="Username" value="<%=name%>" type="hidden">
	</form>



	<form method="post" action="AdminEdit.jsp">
		<button class="tablink"
			>Profile Settings</button>
    <input name="Edit" value="Your Profile" type="hidden">
    <input name="Username" value="<%=name%>" type="hidden">
	</form>
	



<form method="post" action="AdminProfileMenu.jsp" name="Edit">
<button class="tablink" >List of Users</button>
    <input name="Edit" value="Profile List" type="hidden">
    <input name="Username" value="<%=name%>" type="hidden">
</form>


    <form method="post" action="ListOfUniversities.jsp">
		<button class="tablink">Universities List</button>
		<input name="ViewSchools" value="View List of Schools" type="hidden">
		<input name="Username" value="<%=name%>" type="hidden">
	</form>
	


	<form method="post" action="UniversityEditMenu.jsp">
		<button class="tablink"
			>Search to Edit</button>
		 <input name="SearchEdit" value="Search to Edit" type="hidden">
		<input name="Username" value="<%=name%>" type="hidden">
	</form>



<form method="post" action="AddSchool.jsp" name="AddUniversity">

		<button class="tablink">Add University</button>
    <input name="AddUniversity" value="Add University" type="hidden">
    	<input name="Username" value="<%=name%>" type="hidden">
</form>



	
<form>
		<button class="tablink"
			>...</button>
		
	</form>




</body>







<%
if (univ != null)
{
%>


<form method="post" action="UniversityEdit_action.jsp?Name=<%=univ.getName()%>" name="editSchool">
<table style="text-align: left; width: 100%;" border="1">
<tbody>
<tr>
<th colspan="2" style="text-align: center;"> Editing <%=univ.getName()%>
</th>
<tr >
<td>Location</td>
<td style="vertical-align: top;"><input name="Location" value="<%=univ.getLocation()%>"> </td>
</tr>
<tr>
<td>State</td>
<td style="vertical-align: top;"><input name="State" value="<%=univ.getState()%>"></td>
</tr>
<tr >
<td>AcadScale</td>
<td style="vertical-align: top;"><input name="AcadScale" value="<%=univ.getAcadScale()%>"> </td>
</tr>
<tr>
<td>Expenses</td>
<td style="vertical-align: top;"><input name="Expenses" value="<%=univ.getExpenses()%>"> </td>
</tr>
<tr >
<td>Number Applied</td>
<td style="vertical-align: top;"><input name="NumApply" value="<%=univ.getNumApply()%>"> </td>
</tr>
<tr>
<td>Percent Admitted</td>
<td style="vertical-align: top;"><input name="PercAdmit" value="<%=univ.getPercAdmit()%>"> </td>
</tr>
<tr >
<td>Percent Aided</td>
<td style="vertical-align: top;"><input name="PercAid" value="<%=univ.getPercAid()%>"> </td>
</tr>
<tr>
<td>Percent Enrolled</td>
<td style="vertical-align: top;"><input name="PercEnrolled" value="<%=univ.getPercEnrolled()%>"> </td>
</tr>
<tr >
<td>Percentage of Females</td>
<td style="vertical-align: top;"><input name="PercFemale" value="<%=univ.getPercFemales()%>"> </td>
</tr>
<tr>
<td>Quality of Life (out of 5)</td>
<td style="vertical-align: top;"><input name="QualLife" value="<%=univ.getQualLife()%>"> </td>
</tr>
<tr >
<td>SAT Math Score</td>
<td style="vertical-align: top;"><input name="SATMath" value="<%=univ.getSatMath()%>"> </td>
</tr>
<tr>
<td>Social Scale (out of 5)</td>
<td style="vertical-align: top;"><input name="SocialScale" value="<%=univ.getSocialScale()%>"> </td>
</tr>
<tr >
<td>Control</td>
<td style="vertical-align: top;"><input name="Control" value="<%=univ.getControl()%>"> </td>
</tr>
<tr>
<td>Number of Students</td>
<td style="vertical-align: top;"><input name="NumStudents" value="<%=univ.getNumStudents()%>"> </td>
</tr>
<tr >
<td>SAT Verbal Score</td>
<td style="vertical-align: top;"><input name="SATVerbal" value="<%=univ.getSatVerbal()%>"> </td>
</tr>
<tr>
<td align="center" rowspan="1" style="vertical-align: top;">
    <input name="Reset" value="Reset" type="reset">
</td>
<td rowspan="1" style="vertical-align: top;">
    <input align="left" name="Submit" value="Submit" type="submit">
   
</td>

</tr>
</tbody>
</table>
</form>
<table>
<tbody>
<tr>
<td align="right" rowspan="2">
 <form  method="post" action="UniversityDelete.jsp" name="deleteSchool">
		<input action="UniversityDelete.jsp" name="Delete" value="Delete University" type="Submit">
		<input name="Name" value="<%=univ.getName()%>" type="hidden">
	</form>
	</td>
	</tr>
	</tbody>
	</table>
<% }
else
{
	response.sendRedirect("ListOfUniversities.jsp?Error=1");
}
%>
</html>