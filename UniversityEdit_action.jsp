<%@page language="java" import="FTMT.*"%>
<%@include file="verifyLogin.jsp"%>
<%
AdminController ac = (AdminController)session.getAttribute("AdminController"); 
String name = request.getParameter("Name");
String location = request.getParameter("Location");
String state = request.getParameter("State");
String acadScaleStr = request.getParameter("AcadScale");
int acadScale = Integer.parseInt(acadScaleStr);

String expensesStr = request.getParameter("Expenses");
int expenses = Integer.parseInt(expensesStr);

String numApplyStr = request.getParameter("NumApply");
int numApply = Integer.parseInt(numApplyStr);

String percAdmitStr = request.getParameter("PercAdmit");
double percAdmit = Double.parseDouble(percAdmitStr);

String percAidStr = request.getParameter("PercAid");
double percAid = Double.parseDouble(percAidStr);

String percEnrollStr = request.getParameter("PercEnrolled");
double percEnroll = Double.parseDouble(percEnrollStr);

String percFemaleStr = request.getParameter("PercFemale");
double percFemale = Double.parseDouble(percFemaleStr);

String qualLifeStr = request.getParameter("QualLife");
int qualLife = Integer.parseInt(qualLifeStr);

String satMathStr = request.getParameter("SATMath");
int satMath = Integer.parseInt(satMathStr);

String socialScaleStr = request.getParameter("SocialScale");
int socialScale = Integer.parseInt(socialScaleStr);

String control = request.getParameter("Control");

String numStudentsStr = request.getParameter("NumStudents");
int numStudents = Integer.parseInt(numStudentsStr);

String satVerbalStr = request.getParameter("SATVerbal");
int satVerbal = Integer.parseInt(satVerbalStr);

int result = ac.editUniversity(name, state, location, control, numStudents, percFemale, satVerbal,
        satMath, expenses, percAid, numApply, percAdmit, percEnroll, 
        acadScale, socialScale, qualLife);

response.sendRedirect("AdminMenu.jsp?Edited=" + result);

%>