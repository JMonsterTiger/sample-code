<%@page language="java" import="FTMT.*, java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<%
String added = request.getParameter("Added");
if (added != null)
{
 if (added == "0")
 {
	 %>
	 <h2>Please fill out all forms</h2>
	 <%
 }
}
AdminController ac = (AdminController)session.getAttribute("AdminController");
String name = request.getParameter("Name");

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
		<h1>Add User</h1>
		<p>Fill out information and hit add to approve.</p>
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
<body>
<form method="post" action="Add_action.jsp" name="addUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1">
<tbody>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username" required> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password" required> </td>
</tr>
<tr>
<td style="vertical-align: top;">First Name<br>
</td>
<td style="vertical-align: top;"><input name="FirstName" required><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName" required><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td style="vertical-align: top;"><input name="Type" required> </td>
</tr>
<tr>
<td style="vertical-align: top;">Status<br>
</td>
<td style="vertical-align: top;"><input name="Status" required> </td>
</tr>

<tr>
<td style="vertical-align: top;"><input value="Add"
name="Add" type="submit" required></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset" required></td>
</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>

