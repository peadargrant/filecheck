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
        <title><fmt:message key="error" /></title>
    </head>
    <body>
        <h1><fmt:message key="error" /></h1>
        <p class="error"><fmt:message key="${message}" /></p>
        <p><a href="<c:url value="/" />"><fmt:message key="return.to.home.page" /></a></p>
    </body>
</html>
