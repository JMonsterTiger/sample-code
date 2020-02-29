<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<body>
<% 
UserController uc = (UserController)session.getAttribute("UserController");
AdminController ac = (AdminController)session.getAttribute("AdminController"); 
String name = (String)session.getAttribute("Username"); 
Account user  = (Account)session.getAttribute("Account");
%>
Hello User <%=name%> !
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">ADD A USER</a>
</td>

</tr>
<tr>
<td style="vertical-align: top;">
Edit</td>
<td style="vertical-align: top; text-align: center;">Full name
</td>
<td style="vertical-align: top; text-align: center;">Username
</td>
<td style="vertical-align: top; text-align: center;">Password
</td>
<td style="vertical-align: top; text-align: center;">Type
</td>
<td style="vertical-align: top; text-align: center;">Status
</td>
<td style="vertical-align: top;">Delete
</td>
</tr>
<% 
ArrayList<Account> userList = ac.viewAllProfiles();
for (Account acct : userList) 
{
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value=<%=acct.getUsername()%> type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%=acct.getFirstName()+ " " + acct.getLastName()%>
</td>
<td style="vertical-align: top;"><%=acct.getUsername()%>
</td>
<td style="vertical-align: top;"><%=acct.getPassword()%>
</td>
<td style="vertical-align: top;"><%=acct.getType()%>
</td>
<td style="vertical-align: top;"><%=acct.getStatus()%>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="Username" value=<%=acct.getUsername()%> type="hidden">
</form>
</td>
</tr>
<%
} 
%>
</tbody>
</table>
</body>
</html>

