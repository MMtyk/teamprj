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
<input type=button value="로그아웃">
</body>
</html>