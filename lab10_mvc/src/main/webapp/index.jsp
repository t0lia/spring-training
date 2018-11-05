<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Index</title>
</head>
<body>

<h1>All countries</h1>
<a href="country.html">
    Add Country >>
</a>
<br/>
<table>
    <thead>
    <tr>
        <td><b>Country</b></td>
        <td><b>Code</b></td>
    </tr>
    </thead>
    <c:forEach var="listValue" items="${all}">
        <tr>
            <td>
                <c:out value="${listValue.name}"/>
            </td>
            <td>
                <c:out value="${listValue.codeName}"/>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${not empty country}">
    <br/>
    added new country: ${country.name}
</c:if>
</body>
</html>