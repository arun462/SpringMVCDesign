<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>${myValue3}</h2>
<form:form action="signup" method="post" modelAttribute="userDto">

<table>
<tr><td>firstName</td><td><form:input type="text" path="firstname"/></td></tr>
<tr><td>lastName</td><td><form:input type="text" path="lastname"/></td></tr>
<tr><td>userName</td><td><form:input type="text" path="username"/></td></tr>
<tr><td>password</td><td><form:input type="text" path="password"/></td></tr>
<tr><td>userEmail</td><td><form:input type="text" path="useremail"/></td></tr>
<tr><td>signup</td><td><input type="submit" value="signup"/></td></tr>

</table>

</form:form>
<a href="login">click here to login</a><br>
<a href="usermail">click here for already registered user to verify you account</a>
</body>
</html>