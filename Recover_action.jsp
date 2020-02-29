<%@page language="java" import="FTMT.*" import="java.util.*"%>
<html>
<head>
<title>Recover Action</title>
</head>
<%
String email = request.getParameter("Username");
%>
<body>
<form action="mailto:<%=email%>" method="post" enctype="text/plain">

</form>
</body>
</html>