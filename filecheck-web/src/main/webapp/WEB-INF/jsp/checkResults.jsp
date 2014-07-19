<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
 Copyright Peadar Grant.
 All rights reserved.
-->
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
        <table class="summaryTable">
            <tr>
                <c:forEach items="${summaryColumns}" var="column">
                    <th>${column}</th>
                </c:forEach>
            </tr>
            <c:forEach items="${summary}" var="summaryLine">
                <tr style="background-color: ${summaryLine.color}">
                    <c:forEach items="${summaryLine.contents}" var="summaryCell">
                    <td>${summaryCell}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <h2>Detail report</h2>
        <table class="detailTable">
            <tr>
                <c:forEach items="${detailColumns}" var="column">
                    <th>${column}</th>
                </c:forEach>
            </tr>
            <c:forEach items="${detail}" var="detailLine">
                <tr style="background-color: ${detailLine.color}">
                    <c:forEach items="${detailLine.contents}" var="detailCell">
                    <td>${detailCell}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <p><b>Important note!</b> The results of this automated check do not guarantee or imply award of any marks.</p>
        <p class="noprint"><a href="upload">Return to upload screen</a></p>
    </body>
</html>
