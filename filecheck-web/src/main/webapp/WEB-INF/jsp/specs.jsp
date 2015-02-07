<%-- 
    (c) 2014 Peadar Grant
--%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jspf/setup.jspf" %>
<html>
    <head>
        <title>${assignment.code} <fmt:message key="specifications" /></title>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <h1>${assignment.code} <fmt:message key="specifications" /></h1>
        <table>
            <tr>
                <td class="label"><fmt:message key="assignments.url" />:</td>
                <td>${assignmentsUrl}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="assignment.code" />:</td>
                <td>${assignment.code}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="assignment" />:</td>
                <td>${assignment.title}</td>
            </tr>
        </table>
            
        <h2><fmt:message key="archive.requirements" /></h2>
        <c:if test="${assignment.archivename != null}">
            <p><b><fmt:message key="archive.must.be.named" /></b><br /><code>${assignment.archivename}</code></p>
        </c:if>
        
        <c:if test="${not empty assignment.content}">
        <h2><fmt:message key="required.files" /></h2>
        <p><fmt:message key="must.contain.files" /></p>
        <c:forEach items="${assignment.content}" var="file">
            <h3><code>${file.path}</code><c:if test="${file.advisory}"> - <fmt:message key="advisory.file" /></c:if></h3>
            <c:if test="${not empty file.check}">
            <ul>
            <c:forEach items="${file.check}" var="check">
                <li><code>${checkDetails[check]}</code> <c:if test="${check.advisory}"> - <fmt:message key="advisory.check" /></c:if></li>
            </c:forEach>
            </ul>
            </c:if>
        </c:forEach>
        </c:if>
        
        <c:if test="${not empty assignment.pattern}">
        <h2><fmt:message key="wildcard.checks" /></h2>
        <p><fmt:message key="wildcard.checks.explanation" /></p>
        <c:forEach items="${assignment.pattern}" var="pattern">
            <h3><code>*${pattern.match}</code></h3> 
            <ul>
            <c:forEach items="${pattern.check}" var="check">
                <li><code>${checkDetails[check]}</code></li>
            </c:forEach>
            </ul>
        </c:forEach>
        </c:if>
        
        <c:if test="${not empty assignment.reject}">
        <h2><fmt:message key="banned.files" /></h2>
        <p><fmt:message key="banned.files.explanation" /></p>
        <c:forEach items="${assignment.reject}" var="reject">
            <h3><code>*${reject.match}</code><c:if test="${reject.advisory}"> - <fmt:message key="advisory.file" /></c:if></h3> 
        </c:forEach>
        </c:if>
            
        <p><a href="<c:url value="/" />"><fmt:message key="return.to.home.page" /></a></p>
    </body>
</html>
