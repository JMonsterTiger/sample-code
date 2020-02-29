<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<title>Search Results</title>
<%
ArrayList<University> sortedResult = (ArrayList<University>)session.getAttribute("SortedResults");

UserController uc = new UserController();
AccountController acctC = new AccountController();

String username = (String)session.getAttribute("Username"); 

String school = request.getParameter("School"); 
String state = request.getParameter("State");
String location = request.getParameter("Location");
String control = request.getParameter("Control");
String numStudentsLow = request.getParameter("numStudentsLow"); 
String numStudentsHigh = request.getParameter("numStudentsHigh"); 
String percFemLow = request.getParameter("percFemLow");
String percFemHigh = request.getParameter("percFemHigh");
String satVerbLow = request.getParameter("satVerbLow");
String satVerbHigh = request.getParameter("satVerbHigh");
String satMathLow = request.getParameter("satMathLow");
String satMathHigh = request.getParameter("satMathHigh");
String expensesLow = request.getParameter("expensesLow"); 
String expensesHigh = request.getParameter("expensesHigh"); 
String percFinAidLow = request.getParameter("percFinAidLow");
String percFinAidHigh = request.getParameter("percFinAidHigh");
String numAppLow = request.getParameter("numAppLow");
String numAppHigh = request.getParameter("numAppHigh");
String percAdmitLow = request.getParameter("percAdmitLow");
String percAdmitHigh = request.getParameter("percAdmitHigh");
String percEnrolledLow = request.getParameter("percEnrolledLow"); 
String percEnrolledHigh = request.getParameter("percEnrolledHigh"); 
String acadScaleLow = request.getParameter("acadScaleLow");
String acadScaleHigh = request.getParameter("acadScaleHigh");
String socialScaleLow = request.getParameter("socialScaleLow");
String socialScaleHigh = request.getParameter("socialScaleHigh");
String qualLifeLow = request.getParameter("qualLifeLow");
String qualLifeHigh = request.getParameter("qualLifeHigh");
String emphases1 = request.getParameter("emphases1");
String emphases2 = request.getParameter("emphases2");
String emphases3 = request.getParameter("emphases3");
String[] emphases = new String[5];

if(emphases1 != "")
{
	emphases[0] = emphases1;
}
if(emphases2 != "")
{
	emphases[1] = emphases2;
}
if(emphases3 != "")
{
	emphases[2] = emphases3;
}

if (school == "" && state == "" && location == "" && control == "" && numStudentsLow == "" && numStudentsHigh == "" && percFemLow == "" && 
	percFemHigh == "" && satVerbLow == "" && satVerbHigh == "" && satMathLow == "" && satMathHigh == "" && expensesLow == "" && 
	expensesHigh == "" && percFinAidLow == "" && percFinAidHigh == "" && numAppLow == "" && numAppHigh == "" && 
	percAdmitLow == "" && percAdmitHigh == "" && percEnrolledLow == "" && percEnrolledHigh == "" && acadScaleLow == "" && 
	acadScaleHigh == "" && socialScaleLow == "" && socialScaleHigh == "" && qualLifeLow == "" && qualLifeHigh == "" && emphases1 == "" && 
	emphases2 == "" && emphases3 == "")
{
	response.sendRedirect("SearchSchool.jsp?Error=1");
}

ArrayList<University> results = new ArrayList();

if (sortedResult != null)
{
	results = sortedResult;
	session.setAttribute("SortedResults", null);
}

else
{
	if (school == null && state == null && location == null && control == null && numStudentsLow == null && numStudentsHigh == null && percFemLow == null && 
			percFemHigh == null && satVerbLow == null && satVerbHigh == null && satMathLow == null && satMathHigh == null && expensesLow == null && 
			expensesHigh == null && percFinAidLow == null && percFinAidHigh == null && numAppLow == null && numAppHigh == null && 
			percAdmitLow == null && percAdmitHigh == null && percEnrolledLow == null && percEnrolledHigh == null && acadScaleLow == null && 
			acadScaleHigh == null && socialScaleLow == null && socialScaleHigh == null && qualLifeLow == null && qualLifeHigh == null && emphases1 == null && 
			emphases2 == null && emphases3 == null)
		{
			response.sendRedirect("SearchSchool.jsp?Error=1");
		}
	
	else
	{
	results = uc.searchSchools(school, state, location, control, numStudentsLow, numStudentsHigh,
    		percFemLow, percFemHigh, satVerbLow, satVerbHigh, satMathLow, satMathHigh, expensesLow, expensesHigh, percFinAidLow, percFinAidHigh, numAppLow, 
    		numAppHigh, percAdmitLow, percAdmitHigh, percEnrolledLow, percEnrolledHigh, acadScaleLow, acadScaleHigh, socialScaleLow,
    		socialScaleHigh, qualLifeLow, qualLifeHigh, emphases);
	session.setAttribute("Results", results);
	}
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
</head>


<body class=div2>

	
	<div  class="tabcontent">
		<h1>Browse Universities</h1>
		<p>Here are all Universities.</p>
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
    		
<table style="text-align: center; width: 100%;" border="1">
<tbody>
<tr>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Name" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td  style="vertical-align: top;">
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="State" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Location" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td >
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="Expenses" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="QualityLife" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td >
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="SocialScale" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td>
	<form method="post" action="sort_action.jsp" name="Sort">
    <input name="SortType" value="NumberStudents" type="submit">
    <input name="RequestPage" value="Search" type="hidden">
	</form>
</td>
<td colspan="2">View and Save</td>
</tr>
<%
if (results.size() != 0)
{
for (University univ : results)
{
String schoolName = univ.getName();%>
<tr>
	<td> <%out.println(schoolName);%></td>
	<td > <%out.println(univ.getState()) ;%></td>
	<td> <%out.println(univ.getLocation());%></td>
	<td > <%out.println(univ.getExpenses());%></td>
	<td> <%out.println(univ.getQualLife());%></td>
	<td > <%out.println(univ.getSocialScale());%></td>
	<td> <%out.println(univ.getNumStudents());%></td>
	<td align="center" style="vertical-align: top;">
	<form method="post" action="viewSpecific.jsp" name="View">
    <input name="View" value="View School" type="submit">
    <input name="School" value="<%=schoolName%>" type="hidden">
	</form>
	</td>
	<td align="center" style="vertical-align: top;">
	<form method="post" action="saveSchool_action.jsp" name="Add">
    <input name="Add" value="Save School" type="submit">
    <input name="School" value="<%=schoolName%>" type="hidden">
	</form>
	</td>
	</tr>
	<% }}
	else { %>
	<tr>
	<td>No results found</td>
	</tr>
	<% } %>
</tbody>
</table>
</body>
</html>
    		
