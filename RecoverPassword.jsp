<%@page language="java" import="FTMT.*" import="java.util.*"%>
<html>
<head>
<title>Recover Password</title>
</head>
<body>
 
<table class="center">
<tbody>
<tr>
<td colspan="3" style="vertical-align: top;"><input type="text" placeholder="Enter Username (Email)" name="Username" required></td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
<td style="vertical-align: top;">
	<form method="post" action="Recover_action.jsp" name="Recover">
	<input value="Send password to email" name="SendPassword" type="submit">
	<input value="Username" name="Username" type="hidden">
	</form>
</td>
</tr>
</tbody>
</table>

</body>
</html>