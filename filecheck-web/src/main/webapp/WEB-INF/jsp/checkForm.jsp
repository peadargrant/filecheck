<!DOCTYPE html>
<%-- 
    (c) 2014 Peadar Grant
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>FileCheck upload</title>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <h1>FileCheck upload</h1>
        <p><b>Assignments URL:</b> <a href="${assignmentsUrl}">${assignmentsUrl}</a></p>
        <form method="post" action="check" enctype="multipart/form-data">
            <table>
                <tr>
                    <td><b>Step 1:</b> Select assignment</td>
                    <td>
                        <select id="assignment" name="assignment">
                        <c:forEach items="${assignments}" var="assignment">
                                <option value="${assignment.code}">${assignment.title}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><b>Step 2:</b> Upload your ZIP, JAR, WAR or EAR file:</td>
                    <td><input type="file" name="file"/></td>
                </tr>
                <tr>
                    <td><b>Step 3:</b> Click to start the process</td>
                    <td><input type="submit" name="submit" value="Upload and check..."/></td>
                </tr>
            </table>
        </form>
        <p><b>Please note!</b> depending on the size of your submission and on the
            check to be performed, there may be a considerable delay before the 
            report is displayed. Please be patient, and do not repeatedly click
            the submit button.</p>
        <p><a href="<c:url value="/" />">Return to home page</a></p>
    </body>
</html>
