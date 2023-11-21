<%--
  Created by IntelliJ IDEA.
  User: sangjunpark
  Date: 2023-11-20
  Time: 11:34 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html
        xmlns:jsp="http://java.sun.com/JSP/Page"
        xmlns:c="http://java.sun.com/jsp/jstl/core"
        xmlns:spring="http://www.springframework.org/tags"
        version="2.0">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:output omit-xml-declaration="yes" />

<head>
    <title>My Documents</title>
</head>
<body style="font-family: verdana;">
<h2>My Documents - Search</h2>
<c:if test="${not empty docs}">
    <table>
        <tbody>
        <c:forEach items="${docs}" var="doc" varStatus="status">
            <tr>
                <td>
                    <table>
                        <tbody>
                        <tr>
                            <td align="right">Name:</td>
                            <td>${doc.name}</td>
                        </tr>
                        <tr>
                            <td align="right">Type:</td>
                            <td>${doc.type.name}</td>
                        </tr>
                        <tr>
                            <td align="right">Location</td>
                            <td>${doc.location}</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
