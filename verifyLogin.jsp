<%@ page language="java" import="FTMT.*" contentType="text/html; charset=UTF-8"%>

<%
	AccountController ac1 = (AccountController)session.getAttribute("AccountController");
	Account acct1 = (Account)session.getAttribute("Account");
	boolean loggedIn  = (boolean)session.getAttribute("LoggedIn");

	if (ac1 == null || acct1.isLoggedIn() == false)
	{
		if (ac1 == null)
		{
			System.out.println("AccountController is null");
		}
		
		else if (acct1.isLoggedIn() == false)
		{
			System.out.println("Admin is logged in: " + acct1.isLoggedIn());
		}
		response.sendRedirect("index.jsp?Error=-4");
	}

%>