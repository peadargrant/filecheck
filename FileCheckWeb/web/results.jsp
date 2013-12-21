<%-- 
    Document   : index
    Created on : Dec 9, 2013, 10:52:43 AM
    Author     : peadar
--%>

<%@page import="java.awt.Color"%>
<%@page import="com.peadargrant.sw.filecheck.servlets.ColorToCssConverter"%>
<%@page import="com.peadargrant.sw.filecheck.gui.SummaryTableModel"%>
<%@page import="com.peadargrant.sw.filecheck.gui.ReportTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String pageTitle = "Results";

        ReportTableModel rtm = (ReportTableModel) session.getAttribute("rtm");
        SummaryTableModel stm = rtm.getSummaryTableModel();
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
        <p><%= rtm.getAssignmentName() %></p>
        <h2>Test result</h2>
        <p id="result" class="<%= stm.getFinalOutcome().toString() %>"><%= stm.getFinalOutcome().toString() %></p>
        <h2>Summary</h2>
        <table>
            <tr>
                <%         
                for ( int k = 0; k < stm.getColumnCount() ; k++ )
                {
                    %>
                    <th><%= stm.getColumnName(k) %></th>
                    <%
                }
                %>
            </tr>
                    <%
                
                for ( int r = 0; r < stm.getRowCount() ; r++ )
                {
                    %>
                    <tr class="<%= stm.getValueAt(r, 0) %>">
                <%
                for ( int k = 0; k < stm.getColumnCount() ; k++ )
                {
                    %>
                    <td><%= stm.getValueAt(r, k) %></td>
                    <%
                }
                    %>
            </tr>
                    <%
                }
                %>
                
        </table>
        <h2>Detailed report</h2>
        <table>
            <tr>
                <%         
                for ( int k = 0; k < rtm.getColumnCount() ; k++ )
                {
                    %>
                    <th><%= rtm.getColumnName(k) %></th>
                    <%
                }
                %>
            </tr>
                    <%
                
                for ( int r = 0; r < rtm.getRowCount() ; r++ )
                {
                    %>
            <tr class="<%= rtm.getValueAt(r, 3) %>">
                <%
                for ( int k = 0; k < rtm.getColumnCount() ; k++ )
                {
                    %>
                    <td><%= rtm.getValueAt(r, k) %></td>
                    <%
                }
                    %>
            </tr>
                    <%
                }
                %>
                
        </table>
                <p><a href="assignments.jsp">Go back to assignment page</a></p>
   </body>
</html>
