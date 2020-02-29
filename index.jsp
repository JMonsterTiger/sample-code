<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="stylesheet.css">
<title>CMC: Log In</title>
<head>

</head>
<%
String error = request.getParameter("Error");
String msg = request.getParameter("Msg");
if (msg != null)
{
	if (msg.equals("1"))
	 {
		 out.println("<p>Successfully Logged Out</p>");
	 }
	
	if (msg.equals("2"))
	 {
		 out.println("<p>Error encountered while logging you out</p>");
	 }
}

if (error != null)
{
	if (error.equals("2"))
	 {
	 out.println("<p>Please give both a username and password</p>");
	 }
	
 if (error.equals("1"))
 {
 out.println("<p>That account is deactivated, please contact an admin for futher support</p>");
 }

 else if (error.equals("0"))
 {
 out.println("<p>Wrong username or password</p>");
 }

 else if (error.equals("-4"))
 {
 out.println("<p>User must be logged in to access system pages</p>");
 }
 
 else if (error.equals("-1"))
 {
	 out.println("<p>Your profile was successfully deleted</p>");
 }
}
%>

<body>
  <h1>Login Form:</h1>

<form method="post" action="Login_action.jsp" name="Login">
<table class="center">

<tbody>
<tr>
<td colspan="2" style="vertical-align: top;"><input type="text" placeholder="Enter Username" name="Username" required></td>
</tr>
<tr>
<td colspan="2" style="vertical-align: top;"><input type="password" placeholder="Enter Password" name="Password" required></td>
</tr>

<tr>
<td style="vertical-align: top;"><input value="Log in"
name="Log in" type="submit">
</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>