<%@include file="verifyLogin.jsp"%>
<%@page language="java" import="FTMT.*"%>
<%
AdminController ac = (AdminController)session.getAttribute("AdminController"); 
String username = request.getParameter("Username");
String firstName = request.getParameter("FirstName");
String lastName = request.getParameter("LastName");
String password = request.getParameter("Password");
String typeStr = request.getParameter("Type");
String statusStr = request.getParameter("Status");
char type = 't';
char status = 't';

if (username != "" && firstName != "" && lastName != "" && password != "" && typeStr != "" && statusStr != "")
{
	type = typeStr.charAt(0);
	status = statusStr.charAt(0);
	User newUser = new User(firstName, lastName, username, password, type, status);
	ac.addProfile(newUser);
}

else
{
	response.sendRedirect("Add.jsp?Added=0");
	return;
}

response.sendRedirect("AdminProfileMenu.jsp?Added=1");
%>