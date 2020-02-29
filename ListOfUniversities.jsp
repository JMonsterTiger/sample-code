<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<%
String error = request.getParameter("Error");
String removedStr = request.getParameter("Removed");
ArrayList<University> sortedResult = (ArrayList<University>)session.getAttribute("SortedResults");
if (error != null)
{
 if (error == "1")
 {
	 %>
	 <body>Edit failed: University not found</body>
	 <%
 }
}

if (removedStr != null)
{
 int removed = Integer.parseInt(removedStr);
 if (removed > 0)
 {
	 %>
	 <body>Removed University</body>
	 <%
 }
 else
 {
	 %>
	 <body>Remove University Failed</body>
	 <%
 }
}

AdminController ac = new AdminController();
ArrayList<University> fullList = ac.viewUniversities();
session.setAttribute("Results", fullList);
char type = (char)session.getAttribute("Type");

if (sortedResult != null)
{
	fullList = sortedResult;
	session.setAttribute("SortedResults", null);
}
String name = (String)session.getAttribute("Username");
%>


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
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;}	

.tbl-header {
	height: 300px;
	table-layout: fixed;
	background: -webkit-linear-gradient(left, #2884bb, #5b6467);
	background: linear-gradient(to right, #2884bb, #5b6467);
	


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
</head>


<body class=div2>

	
	<div  class="tabcontent">
		<h1>Browse Universities</h1>
		<p>Here are all Universities.</p>
	</div>

<% if (type == 'a' || type == 'A') 
	{%>	
	
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
	
	
	
	
	
	
	<%}
	else
	{%>
	
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


<%}%>




</body>



<div class="tbl-content" style="overflow-y: scroll">

<table style="text-align: left; width: 100%;" border="1" >
<tbody>

<tr>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Name" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td style="vertical-align: top;">
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="State" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Location" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td >
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Expenses" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="QualityLife" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="SocialScale" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="NumberStudents" type="submit">
    <input name="RequestPage" value="List" type="hidden">
	</form>
</td>
<td colspan="2" align="center">View and Save</td>
</tr>
<%for (University univ : fullList) {
String schoolName = univ.getName();%>
<tr>
	<td> <%out.println(schoolName);%></td>
	<td > <%out.println(univ.getState()) ;%></td>
	<td> <%out.println(univ.getLocation());%></td>
	<td > <%out.println(univ.getExpenses());%></td>
	<td> <%out.println(univ.getQualLife());%></td>
	<td> <%out.println(univ.getSocialScale());%></td>
	<td> <%out.println(univ.getNumStudents());%></td>
	<td align="center" style="vertical-align: top;">
	<form method="post" action="viewSpecific.jsp" name="View">
    <input name="View" value="View School" type="submit">
    <input name="School" value="<%=schoolName%>" type="hidden">
	</form>
	</td>
	<% if (type == 'a' || type == 'A') 
	{%>
	<td align="center" style="vertical-align: top;">
	<form method="post" action="UniversityEdit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Name" value="<%=schoolName%>" type="hidden">
	</form>
	</td>
	<%}
	else
	{%>
	<td align="center" style="vertical-align: top;">
	<form method="post" action="saveSchool_action.jsp" name="Add">
    <input name="Add" value="Save School" type="submit">
    <input name="School" value="<%=schoolName%>" type="hidden">
	</form>
	</td>
	<%
	} %>
	</tr>
	<%} %>
</tbody>
</table>
</div>
</body>
</html>