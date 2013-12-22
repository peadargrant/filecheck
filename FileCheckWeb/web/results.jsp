<%-- 
    Document   : index
    Created on : Dec 9, 2013, 10:52:43 AM
    Author     : peadar
--%>

<%@page import="java.awt.Color"%>
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
        <title><%= pageTitle%></title>
        <link rel="stylesheet" href="css/filecheck.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.js"></script>
        <script src="filecheck.js"></script>
        <link rel="stylesheet" type="text/css" href="css/dataTables.css">
        <script>
            var dataTablesOptions = {
                                        "aLengthMenu": [1000],
                                        "iDisplayLength": 1000,
                                    };
            $(document).ready(function() {
                $('table.display').dataTable(dataTablesOptions);
            });
        </script>
    </head>
    <body>
        <h1><%= pageTitle%></h1>
        <table>
            <tbody>
                <tr>
                    <td class="label">Assignment</td>
                    <td class="value"><%= rtm.getAssignmentName()%></td>
                </tr>
                <tr>
                    <td class="label">File name</td>
                    <td class="value">File name not available</td>
                </tr>
            </tbody>
        </table>
        <h2>Test result</h2>
        <p id="result" class="<%= stm.getFinalOutcome().toString()%>"><%= stm.getFinalOutcome().toString()%></p>
        <h2>Summary</h2>
        <div>
            <table id="summary" class="display">
                <thead>
                    <tr>
                        <%
                            for (int k = 0; k < stm.getColumnCount(); k++) {
                        %>
                        <th><%= stm.getColumnName(k)%></th>
                            <%
                                }
                            %>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int r = 0; r < stm.getRowCount(); r++) {
                    %>
                    <tr>
                        <%
                            for (int k = 0; k < stm.getColumnCount(); k++) {
                        %>
                        <td class="<%= stm.getValueAt(r, 0)%>"><%= stm.getValueAt(r, k)%></td>
                        <%
                            }
                        %>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <h2>Detailed report</h2>
        <div>
            <table id="detail" class="display">
                <thead>
                    <tr>
                        <%
                            for (int k = 0; k < rtm.getColumnCount(); k++) {
                        %>
                        <th><%= rtm.getColumnName(k)%></th>
                            <%
                                }
                            %>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int r = 0; r < rtm.getRowCount(); r++) {
                    %>
                    <tr>
                        <%
                            for (int k = 0; k < rtm.getColumnCount(); k++) {
                        %>
                        <td class="<%= rtm.getValueAt(r, 3)%>"><%= rtm.getValueAt(r, k)%></td>
                        <%
                            }
                        %>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <h2>Exit</h2>
        <div>
            <p><a href="assignments.jsp">Go back to assignment page</a></p>
        </div>

    </body>
</html>
