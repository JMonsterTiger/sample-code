<%@page language="java" import="FTMT.*"%>
<%
String username = request.getParameter("Username");
AccountController aCtrl = (AccountController)session.getAttribute("AccountController");

if (aCtrl != null)
{
	int result = aCtrl.logOut(username);

	if (result == 1)
	{
		session.setAttribute("LoggedIn", false);
		response.sendRedirect("index.jsp?Msg=1");
		return;
	}
}

response.sendRedirect("index.jsp?Msg=2");
%>