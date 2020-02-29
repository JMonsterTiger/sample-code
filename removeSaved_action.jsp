<%@page language="java" import="FTMT.* , java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html></html>
<%
String school = (String)request.getParameter("School");
String username = (String)session.getAttribute("Username");
UserController uc = new UserController();

int result = uc.removeSavedSchool(username, school);

response.sendRedirect("viewSavedSchool.jsp?Removed=" + result);
%>