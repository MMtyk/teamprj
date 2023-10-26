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
String nick = (String)request.getAttribute("nick");
String nickChk = (String)request.getAttribute("nickChk");
%>
<form action="AccountCreateServlet?choice=next2" method="post">
	<input type="text" name="idNum" value=${idNum }><br><br>
	닉네임(4~10자리) : <input type="text" name="nick" value=${nick }>
	<input type="text" disabled value=${nickChk }><br>
	<input type="submit" value="이전" formaction="AccountCreateServlet?choice=back2" formmethod="post">
	<input type="submit" value="다음">
</form>
</body>
</html>