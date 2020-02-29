<%@page language="java" import="FTMT.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<title>Save School Action</title>
</html>
<%
String school = (String)request.getParameter("School");
String username = (String)session.getAttribute("Username");

UserController uc = (UserController)session.getAttribute("UserController");
AdminController ac = new AdminController();
int result = uc.addSavedSchool(username, school);

response.sendRedirect("viewSavedSchool.jsp?Added=" + result);
%>value="<%=request.getAttribute("brand")%>"