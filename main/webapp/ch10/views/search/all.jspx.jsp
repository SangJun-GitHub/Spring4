<html
        xmlns:jsp="http://java.sun.com/JSP/Page"
        xmlns:c="http://java.sun.com/jsp/jstl/core"
        xmlns:spring="http://www.springframework.org/tags"
        version="2.0">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:output omit-xml-declaration="yes" />
<spring:message code="main.title" var="title" />
<spring:message code="search.subtitle" var="subtitle" />
<spring:message code="search.name" var="name" />
<spring:message code="search.type" var="type" />
<spring:message code="search.location" var="location" />
<head>
    <title>${title}</title>
</head>
<body style="font-family: verdana;">
<h2>${subtitle}</h2>
<c:if test="${not empty docs}">
    <table>
        <tbody>
        <c:forEach items="${docs}" var="doc" varStatus="status">
            <tr>
                <td>
                    <table>
                        <tbody>
                        <tr>
                            <td align="right">${name}</td>
                            <td>${doc.name}</td>
                        </tr>
                        <tr>
                            <td align="right">${type}</td>
                            <td>${doc.type.name}</td>
                        </tr>
                        <tr>
                            <td align="right">${location}</td>
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