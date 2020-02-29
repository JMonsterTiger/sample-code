<%@page language="java" import="FTMT.* , java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html><title>Delete Profile</title></html>
<%
AdminController ac = new AdminController();
String deleteUniv = request.getParameter("Name");

int result = ac.removeUniversity(deleteUniv);

response.sendRedirect("ListOfUniversities.jsp?Removed=" + result);
%>