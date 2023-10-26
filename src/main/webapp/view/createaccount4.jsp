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
String passChk = (String)request.getAttribute("passChk");
%>
<form action="AccountCreateServlet?choice=next4" method="post">
	<input type="text" name="idNum" value=${idNum }><br><br>
	패스워드 확인 : <input type="text" name="passwd2"><br><br>
	<input type="text" disabled value=${passChk }><br>
	<input type="submit" value="이전" formaction="AccountCreateServlet?choice=back4" formmethod="post">
	<input type="submit" value="계정생성">
</form>
</body>
</html>