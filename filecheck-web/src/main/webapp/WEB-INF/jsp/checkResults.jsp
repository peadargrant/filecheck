<%-- 
    (c) 2014 Peadar Grant
--%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jspf/setup.jspf" %>
<c:set var="pageTitle" value="FileCheck results" />
<html>
    <head>
        <title>${pageTitle}</title>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <h1>${pageTitle}</h1>
        <table>
            <tr>
                <td class="label"><fmt:message key="file.name" />:</td>
                <td>${fileName}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="assignments.url" />:</td>
                <td>${assignmentsUrl}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="assignment" />:</td>
                <td>${assignmentName}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="start.time" />:</td>
                <td>${startTime}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="remote.address" />:</td>
                <td>${remoteIP}</td>
            </tr>
        </table>
        <h2><fmt:message key="outcome" /></h2>
        <p style="background-color: rgb(${colourr},${colourg},${colourb})" class="outcome">${outcome}</p>
        <h2><fmt:message key="summary.report" /></h2>
        <tag:autoTable cssClass="summaryTable" headings="${summaryColumns}" rows="${summary}" />
        <h2><fmt:message key="detail.report" /></h2>
        <tag:autoTable cssClass="detailTable" headings="${detailColumns}" rows="${detail}" />
        <p><b><fmt:message key="important.note" />!</b> <fmt:message key="marks.warning" /></p>
        <p><a href="<c:url value="/" />"><fmt:message key="return.to.home.page" /></a></p>
    </body>
</html>
