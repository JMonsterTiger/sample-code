<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<%
UserController uc = (UserController)session.getAttribute("UserController"); 
String name = (String)session.getAttribute("Username"); 
char type = (char)session.getAttribute("Type");
ArrayList<University> history = (ArrayList<University>)session.getAttribute("History"); 
String school = (String)request.getParameter("School"); 
DBController db = new DBController();

String s = uc.savedSchoolStringtoName(school);
System.out.println("School = " + s);
AdminController ac = new AdminController();
University univ = ac.getUniversity(s);
%>
<body>


<style>
body {
	font-family: "Lato", sans-serif;
}

html {align = center
	
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

.tbl-header {
	height: 300px;
	table-layout: fixed;
	background: -webkit-linear-gradient(left, #ffafbd, #ffc3a0);
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	


	font-family: 'Roboto', sans-serif;
	margin-top: 0px;
}

.tbl-content {
	height: 300px;
	margin-top: 0px;
	width: 100%;
	table-layout: fixed;
	word-break: break-all;
	word-wrap: break-word;
}

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
	padding: 14px 16px;
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
<body class=div2>

	
	<div  class="tabcontent">
		<h1>Browse Universities</h1>
		<p>Here are all Universities.</p>
	</div>


<% if (type == 'u' || type == 'U') { 
history.add(univ); %>
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
	
	
	
	
<%} %>

<%if(type == 'a' || type == 'A') { %>
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

	
	
	
	
	
	
<%} %>

	






</body>
<% 

if(univ != null)
{
%>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<th colspan="2" align="center" style="vertical-align: top;" bgcolor="DodgerBlue">Viewing School: <%=univ.getName()%><br>
</th>
</tr>
<tr>
<td style="vertical-align: top;">STATE<br>
</td>
<td style="vertical-align: top;"><%= univ.getState()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">LOCATION<br>
</td>
<td style="vertical-align: top;"><%= univ.getLocation()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">CONTORL<br>
</td>
<td style="vertical-align: top;"><%= univ.getControl()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
</td>
<td style="vertical-align: top;"><%= univ.getNumStudents()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% FEMALE<br>
</td>
<td style="vertical-align: top;"><%= univ.getPercFemales()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SAT VERBAL<br>
</td>
<td style="vertical-align: top;"><%= univ.getSatVerbal()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SAT MATH<br>
</td>
<td style="vertical-align: top;"><%= univ.getSatMath()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">EXPENSES<br>
</td>
<td style="vertical-align: top;"><%= univ.getExpenses()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% FINANCIAL AID<br>
</td>
<td style="vertical-align: top;"><%= univ.getPercAid()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
</td>
<td style="vertical-align: top;"><%= univ.getNumApply()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% ADMITTED<br>
</td>
<td style="vertical-align: top;"><%= univ.getPercAdmit()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% ENROLLED<br>
</td>
<td style="vertical-align: top;"><%= univ.getPercEnrolled()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">ACADEMICS SCALE(1-5)<br>
</td>
<td style="vertical-align: top;"><%= univ.getAcadScale()%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SOCIAL SCALE(1-5)<br>
</td>
<td style="vertical-align: top;"><%= univ.getSocialScale() %><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">QUALITY OF LIFE SCALE(1-5)<br>
</td>
<td style="vertical-align: top;"><%= univ.getQualLife() %><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">EMPHASES<br>
</td>
<td style="vertical-align: top;">
<table style="text-align: left; width: 100%;" border="1"
cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;"><%=db.getEmphases(school)%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><br>
</td>
</tr>
</tbody>
</table>

<br>
</td>
</tr>
</tbody>
</table>
<% }

else{
	response.sendRedirect("viewSavedSchool.jsp?Error=1");
}
%>
<br>
</body>
</html>