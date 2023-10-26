<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%
String idNum = (String)request.getAttribute("idNum");
String passwd = (String)request.getAttribute("passwd");
%>
<form action="AccountCreateServlet?choice=next3" method="post">
	<input type="text" name="idNum" value=${idNum }><br><br>
	패스워드(6~20자리) : <input type="text" name="passwd"><br>
	<input type="submit" value="이전" formaction="AccountCreateServlet?choice=back3" formmethod="post">
	<input type="submit" value="다음">
</form>
</body>
</html>