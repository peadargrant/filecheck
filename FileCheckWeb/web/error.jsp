<%-- 
    Document   : error
    Created on : Dec 9, 2013, 3:41:19 PM
    Author     : Peadar Grant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="filecheck.css" />
        <script src="filecheck.js"></script>
    </head>
    <body>
        <h1>Error</h1>
        <p class="errorText"><%= session.getAttribute("errorText") %>
        <p><a href="index.jsp">Go back to start</a></p>
    </body>
</html>
