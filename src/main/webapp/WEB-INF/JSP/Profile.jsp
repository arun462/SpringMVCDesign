<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${UserDto}</h1>

<<%-- form:form method="post" action="profile" modelAttribute="UserDto">

<tr><td>firstName</td><td><form:input path="firstname" readonly="true"/></td></tr>
<tr><td>lastName</td><td><form:input  path="lastname" readonly="true"/></td></tr>
<tr><td>userName</td><td><form:input  path="username" readonly="true"/></td></tr>
<tr><td>password</td><td><form:input  path="password" readonly="true"/></td></tr>
<tr><td>userEmail</td><td><form:input path="useremail" readonly="true"/></td></tr>
<tr><td>getProfile</td><td><input type="submit" value="getProfile"/></td></tr>
</form:form> --%>

</body>
</html>