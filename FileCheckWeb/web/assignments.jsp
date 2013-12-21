<%-- 
    Document   : assignments
    Created on : Dec 9, 2013, 3:40:54 PM
    Author     : Peadar Grant
--%>

<%@page import="com.peadargrant.sw.filecheck.assignments.Assignments"%>
<%@page import="com.peadargrant.sw.filecheck.assignments.Assignment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String pageTitle = "Assignment"; 
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= pageTitle %></title>
        <link rel="stylesheet" href="filecheck.css" />
        <script src="filecheck.js"></script>
    </head>
    <body>
        <h1><%= pageTitle %></h1>
        <form method="post" action="CheckerServlet">
            <p>
                <select name="assignment">
                    <%
                    int k = 0;
                    Assignments assignments = (Assignments) session.getAttribute("assignments");
                    for ( Assignment a : assignments.getAssignment() )
                    {
                    %>
                    <option value="<%=k%>"><%= a.getTitle() %></option>
                    <%
                        k = k + 1;
                    }
                        %>
                </select>
            </p>
            <p>
                <input type="file" length="40" />
            </p>
            <p>
                <input type="submit" value="Run checks" />
            </p>
        </form>
    </body>
</html>
