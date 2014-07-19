<%-- 
    Document   : autoTable
    Created on : Jul 19, 2014, 8:35:11 PM
    Author     : Peadar Grant
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="automatic table generator" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="headings" type="java.util.List"%>
<%@attribute name="rows" type="java.util.List"%>
<%@attribute name="cssClass"%>

        <table class="${cssClass}">
            <tr>
                <c:forEach items="${headings}" var="heading">
                    <th>${heading}</th>
                </c:forEach>
            </tr>
            <c:forEach items="${rows}" var="row">
                <tr style="background-color: ${row.color}">
                    <c:forEach items="${row.contents}" var="cell">
                    <td>${cell}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>