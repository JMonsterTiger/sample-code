<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<%
AdminController ac = new AdminController();
UserController uc = new UserController();
String school = (String)request.getParameter("School");

System.out.println("School: '" + school + "'");

University univ = ac.getUniversity(school);

System.out.println("Univ: '" + univ.getName() + "'");

ArrayList<University> recSchools = uc.viewRecSchools(univ);
String name = (String)session.getAttribute("Username");
Account user  = (Account)session.getAttribute("Account");

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
background-image: url(https://www.otago.ac.nz/_assets/OtagoCorporate/gfx/campaign.jpg);

  /* Full height */
  height: 85%; 
padding: 50px;
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



<body>

	<div id="User Settings" class="tabcontent">
		<h1>Here is your Users Information</h1>		
	</div>
	




	<form method="post" action="UserMenu.jsp">
		<button class="tablink" >User Menu</button>

		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="Logout_action.jsp">
		<button class="tablink" >Logout</button>
		<input name="Logout" value="Log Out" type="hidden"> 
		<input name="Username" value=<%=name%> type="hidden">
	</form>



	<form method="post" action="UserProfileMenu.jsp">
		<button class="tablink"
			>User Settings</button>
		<input name="Edit" value="View Profile" type="hidden"> 
		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="SearchSchool.jsp">
		<button class="tablink"
			>Search Specific Universities</button>
		<input name="Search" value="Search for Schools" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>



	<form method="post" action="ListOfUniversities.jsp">

		<button class="tablink"
			
			>Browse All Universities</button>
		<input name="ViewSchools" value="View List of Schools" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>




	<form method="post" action="viewSavedSchool.jsp">

		<button class="tablink"
			>Your Saved Schools</button>
		<input name="SavedList" value="Saved School List" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="ViewHistory.jsp">
		<button class="tablink"
			>Browsing History</button>
		<input name="History" value="View Browsing History" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>
	
<form>
		<button class="tablink"
			>...</button>
		
	</form>




</body>

<body class = div2>
<table style="text-align: center; width: 100%;" border="1">
<tbody>
<tr>
<td colspan="9" align="center" style="vertical-align: center;"><b>
Similar Universities to <%=school%></b>
</td>

</tr>
<tr>
<td>
	Name
</td>
<td style="vertical-align: top;">
	State
</td>
<td>
	Location
</td>
<td>
	Expenses
</td>
<td>
	Quality of Life
</td>
<td>
	Social Scale
</td>
<td>
	Number of Students
</td>
<td colspan="2">
View and Save
</td>
</tr>
<% 
for (University rec : recSchools)
	{ %>
	<tr>
	<td> <%out.println(rec.getName());%></td>
	<td> <%out.println(rec.getState()) ;%></td>
	<td> <%out.println(rec.getLocation());%></td>
	<td> <%out.println(rec.getExpenses());%></td>
	<td> <%out.println(rec.getQualLife());%></td>
	<td> <%out.println(rec.getSocialScale());%></td>
	<td> <%out.println(rec.getNumStudents());%></td>
	<td align="center" style="vertical-align: top;">
		<form method="post" action="viewSpecific.jsp" name="View">
	    <input name="View" value="View School" type="submit">
	    <input name="School" value="<%=rec.getName()%>" type="hidden">
		</form>
	</td>
	<td align="center" style="vertical-align: top;">
		<form method="post" action="saveSchool_action.jsp" name="Add">
	    <input name="Add" value="Save School" type="submit">
	    <input name="School" value="<%=rec.getName()%>" type="hidden">
		</form>
	</td>
	</tr>
<% } %>
</tbody>
</table>
</body>
</html>