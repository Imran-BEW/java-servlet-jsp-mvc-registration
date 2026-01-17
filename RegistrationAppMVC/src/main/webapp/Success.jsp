<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Registration</title>
</head>
<body>
<%
String uname = (String) session.getAttribute("uname");
%>
<h1>Hey <%=uname%> you have successfully registered.</h1>
</body>
</html>