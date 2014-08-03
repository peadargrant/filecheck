<%-- 
    (c) 2014 Peadar Grant
--%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jspf/setup.jspf" %>
<html>
    <head>
        <title><fmt:message key="filecheck.upload" /></title>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <h1><fmt:message key="filecheck.upload" /></h1>
        <p><b><fmt:message key="assignments.url" />:</b> <a href="${assignmentsUrl}">${assignmentsUrl}</a></p>
        <form method="post" action="check" enctype="multipart/form-data">
            <table class="form">
                <tr>
                    <td class="step"><fmt:message key="step" /> 1</td>
                    <td><fmt:message key="select.assignment" /></td>
                    <td>
                        <select id="assignment" name="assignment">
                        <c:forEach items="${assignments}" var="assignment">
                            <option value="${assignment.code}"<c:if test="${assignment.code==preselect}"> selected="selected"</c:if>>${assignment.title}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="step"><fmt:message key="step" /> 2</td>
                    <td><fmt:message key="upload.your.file" /></td>
                    <td><input type="file" name="file"/></td>
                </tr>
                <tr>
                    <td class="step"><fmt:message key="step" /> 3</td>
                    <td><fmt:message key="click.to.start" /></td>
                    <td><input type="submit" name="submit" value="Upload and check..."/></td>
                </tr>
            </table>
        </form>
        <p><b><fmt:message key="please.note" /></b> <fmt:message key="delay.warning" /></p>
        <p><a href="<c:url value="/" />"><fmt:message key="return.to.home.page" /></a></p>
    </body>
</html>
