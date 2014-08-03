<%-- 
    (c) 2014 Peadar Grant
--%>
<!DOCTYPE html>
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
