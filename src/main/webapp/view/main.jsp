<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String op1 = (String)request.getAttribute("op1");
out.print(op1);
%>

<input type="text" name="nm" value=${op1 }><br>
<input type=button value="로그아웃" onclick="location.href='login.jsp'">
</body>
</html>