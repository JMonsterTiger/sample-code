<%@page language="java" import="FTMT.*" import="java.util.*"%>
<% 
boolean loggedIn = false;
UserController uc = new UserController();
AccountController acctC = new AccountController();
AdminController ac = new AdminController();
char type = 'n';
ArrayList<University> history = new ArrayList<University>();

String username = request.getParameter("Username");
String password = request.getParameter("Password");

if (username == "" || password == "")
{
	response.sendRedirect("index.jsp?Error=2");
	return;
}

int result = acctC.login(username, password);

if (result == 2) // Login Successful
{
	loggedIn = true;
	Account acct = uc.getUser(username);
	type = acct.getType();
	session.setAttribute("AccountController", acctC);
	session.setAttribute("Username", username);
	session.setAttribute("LoggedIn", loggedIn);
	session.setAttribute("Type", type);
	
	
	acct.setLoggedIn(true);
	session.setAttribute("Account", acct);
	
	if (type == 'u' || type == 'U')
	{
		session.setAttribute("History", history);
		session.setAttribute("UserController", uc);
		response.sendRedirect("UserMenu.jsp?name=" + username);
		return;
	}
	
	if (type == 'a' || type == 'A')
	{
		session.setAttribute("AdminController", ac);
		response.sendRedirect("AdminMenu.jsp?name=" + username);
		return;
	}
}

else if (result == 1) // Inactive
{
	response.sendRedirect("index.jsp?Error=1");
	return;
}

else if (result == 0) // Unmatched
{
	response.sendRedirect("index.jsp?Error=0");
	return;
}
%>
