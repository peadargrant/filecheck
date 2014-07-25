<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
    (c) 2014 Peadar Grant
--%>
<%@include file="/WEB-INF/jspf/setup.jspf" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
        <title><fmt:message key="filecheck.web" /></title>
    </head>
    <body>
        <h1><fmt:message key="filecheck.web" /></h1>
        <p><fmt:message key="intro" /></p>
        <p><b><fmt:message key="assignments.url" />: </b><a href="${assignmentsUrl}">${assignmentsUrl}</a></p>
        <h2><fmt:message key="get.started" /></h2>
        <p><a href="upload"><fmt:message key="upload.your.file" /></a></p>
        <h2><fmt:message key="further.information" /></h2>
        <p><a href="https://github.com/peadargrant/filecheck"><fmt:message key="github.project.page" /></a>
        <p><a href="resources/LICENSE.txt"><fmt:message key="license" /></a></p>
    </body>
</html>
