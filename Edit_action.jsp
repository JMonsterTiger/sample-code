<%@page language="java" import="FTMT.*"%>
<%@include file="verifyLogin.jsp"%>
<%
char userType = (char)session.getAttribute("Type");
AdminController aControl = new AdminController();

if (userType == 'a' || userType == 'A')
{
	aControl = (AdminController)session.getAttribute("AdminController"); 
}

String username = request.getParameter("Username"); 
String firstName = request.getParameter("FirstName");
String lastName = request.getParameter("LastName");
String password = request.getParameter("Password");
char type = request.getParameter("Type").charAt(0);
char status = request.getParameter("Status").charAt(0);

int result = aControl.editProfile(username, password, firstName, lastName, type, status);

if (userType == 'a' || userType == 'A')
{
	response.sendRedirect("AdminProfileMenu.jsp?Edited=" + result);
}

else
{
	response.sendRedirect("UserMenu.jsp?Edited=" + result);
}
%>