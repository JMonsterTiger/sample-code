<%@page language="java" import="FTMT.* , java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html><title>Delete Profile</title></html>
<%
	char type = request.getParameter("selectedType").charAt(0); 
	AdminController ac = new AdminController();
	UserController uc = new UserController();
	String deleteUsername = request.getParameter("Username");
	String currentUsername = (String)session.getAttribute("Username");
	Account acct = ac.getProfile(currentUsername);
	ArrayList<String> savedList = new ArrayList<String>();
if(currentUsername.equals(deleteUsername))
{
	response.sendRedirect("AdminProfileMenu.jsp");
	return;
}
	if(type == 'U'||type == 'u')
	{
	 savedList = uc.viewSavedSchools(deleteUsername);	 
	 
	 for(String univName : savedList)
	 {
		univName = uc.savedSchoolStringtoName(univName);
		// System.out.println(univName)
		uc.removeSavedSchool(currentUsername, univName.toUpperCase());
	 }

	}
	if(acct.getType() =='U'||acct.getType() == 'u')
	{
		 response.sendRedirect("index.jsp?Error=-1");
		 return;		
	}
	else{
	int result = ac.removeProfile(deleteUsername);
	System.out.println("Delete (ln28) result: [" + result + "]");
	response.sendRedirect("AdminProfileMenu.jsp?Removed=" + result);
	return;
	}
%>