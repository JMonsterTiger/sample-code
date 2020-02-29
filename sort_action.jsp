<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<head>
<title>Sort Action</title>
</head>
<%
String sortType = request.getParameter("SortType");
String requestPage = request.getParameter("RequestPage");
ArrayList<University> results = (ArrayList<University>)session.getAttribute("Results");
if (results == null)
{
	System.out.println("Results is null");
	response.sendRedirect("SearchSchool.jsp");
	return;
}
University temp;
String tempStr;
int tempInt;

if (sortType.equals("Name"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getName().compareTo(results.get(j).getName())>0) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

else if (sortType.equals("State"))
{
	System.out.println("Sorting by state...");
	for (int i = 0; i < results.size(); i++) 
    {
		System.out.println("Loop One: " + i);
        for (int j = i + 1; j < results.size(); j++) 
        {
        	System.out.println("Loop Two: " + j);
            if (results.get(i).getState().compareTo(results.get(j).getState())>0) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
                System.out.println("Sorting: results[" + i + "](old):" + temp.getName() + " - State: " + temp.getState() + " | results[" + i + "](new):" + temp.getName() + " - State: " + temp.getState());
            }
        }
    }
}

else if (sortType.equals("Location"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getLocation().compareTo(results.get(j).getLocation())>0) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

else if (sortType.equals("Expenses"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getExpenses() < results.get(j).getExpenses()) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

else if (sortType.equals("QualityLife"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getQualLife() < results.get(j).getQualLife()) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

else if (sortType.equals("SocialScale"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getSocialScale() < results.get(j).getSocialScale()) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

else if (sortType.equals("NumberStudents"))
{
	for (int i = 0; i < results.size(); i++) 
    {
        for (int j = i + 1; j < results.size(); j++) 
        {
            if (results.get(i).getNumStudents() < results.get(j).getNumStudents()) 
            {
                temp = results.get(i);
                results.set(i, results.get(j));
                results.set(j, temp);
            }
        }
    }
}

session.setAttribute("SortedResults", results);

if (requestPage != null)
{
	if (requestPage.equals("Search"))
	{
		response.sendRedirect("Search_action.jsp");
		return;
	}
	
	else if (requestPage.equals("List"))
	{
		response.sendRedirect("ListOfUniversities.jsp");
		return;
	}
}

else
{
response.sendRedirect("UserMenu.jsp");
return;
}
%>
</html>