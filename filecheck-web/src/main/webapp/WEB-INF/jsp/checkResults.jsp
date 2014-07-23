<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html>
<%-- 
    (c) 2014 Peadar Grant
--%>
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
                <td class="label">File name:</td>
                <td>${fileName}</td>
            </tr>
            <tr>
                <td class="label">Assignment:</td>
                <td>${assignmentName}</td>
            </tr>
        </table>
        <h2>Outcome</h2>
        <p style="background-color: rgb(${colourr},${colourg},${colourb})" class="outcome">${outcome}</p>
        <h2>Summary report</h2>
        <tag:autoTable cssClass="summaryTable" headings="${summaryColumns}" rows="${summary}" />
        <h2>Detail report</h2>
        <tag:autoTable cssClass="detailTable" headings="${detailColumns}" rows="${detail}" />
        <p><b>Important note!</b> The results of this automated check do not guarantee or imply award of any marks.</p>
        <p class="noprint"><a href="upload">Return to upload screen</a></p>
    </body>
</html>
