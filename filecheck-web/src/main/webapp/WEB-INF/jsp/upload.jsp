<%-- 
    (c) 2014 Peadar Grant
--%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jspf/setup.jspf" %>
<html>
    <head>
        <title><fmt:message key="filecheck.upload" /></title>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
        <script>
            function unlockForm() {
                document.getElementById("submitButton").disabled=false;
                document.getElementById("submissionFeedback").innerHTML="";
            }
            function showSpecs() {
                window.location = "specs?assignment=" + document.getElementById("assignment").value;
                return false;
            }
            function processForm() {
                if ( document.getElementById("uploadFile").files.length == 0 ) {
                    alert("<fmt:message key="upload.warning" />");
                    return false;
                }
                document.getElementById("submitButton").disabled=true;
                document.getElementById("submissionFeedback").innerHTML="<fmt:message key="please.wait" />...";
                return true;
            }
        </script>
    </head>
    <body onpageshow="unlockForm();">
        <h1><fmt:message key="filecheck.upload" /></h1>
        <form method="post" action="check" onsubmit="return processForm();" enctype="multipart/form-data">
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
                        <button onclick="return showSpecs();"><fmt:message key="show.specifications" />...</button>
                    </td>
                </tr>
                <tr>
                    <td class="step"><fmt:message key="step" /> 2</td>
                    <td><fmt:message key="upload.your.file" /></td>
                    <td><input id="uploadFile" type="file" name="file"/></td>
                </tr>
                <tr>
                    <td class="step"><fmt:message key="step" /> 3</td>
                    <td><fmt:message key="click.to.start" /></td>
                    <td><input id="submitButton" type="submit" name="submit" value="<fmt:message key="upload.and.check" />..."/></td>
                </tr>
            </table>
        </form>
        <p><b><fmt:message key="please.note" /></b> <fmt:message key="delay.warning" /></p>
        <p class="actionMessage" id="submissionFeedback"></p>
    </body>
</html>
