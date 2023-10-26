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
String id = (String)request.getAttribute("id");
String idChk = (String)request.getAttribute("idChk");
%>
<form action="AccountCreateServlet?choice=next1" method="post">
	<input type="text" name="idNum" value=${idNum }><br><br>
	아이디(4~10자리) : <input type="text" name="id" value=${id }>
	<input type="text" disabled value=${idChk }><br>
	<input type="submit" value="이전" formaction="AccountCreateServlet?choice=back1" formmethod="post">
	<input type="submit" value="다음">
</form>
</body>
</html>