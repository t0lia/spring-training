<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Country Page</title>
</head>
<body>

<form:form commandName="country">
    <label>Country</label>
    <form:input path="name" cssErrorClass="error"/>
    <br>
    <label>Code</label>
    <form:input path="codeName" cssErrorClass="error"/>
    <br>

    <input type="submit" class="btn" value="enter country"/>
</form:form>
</body>
</html>