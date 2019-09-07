<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form action="usermail" modelAttribute="userMailDTO" method="post">
<table>
<tr><td>Enter email</td><td><form:input type="text" path="useremail" ></form:input></td></tr>
<tr><td colspan="2"><input type="submit" value="reverification" ></td></tr>
</table>
</form:form>

</body>
</html>