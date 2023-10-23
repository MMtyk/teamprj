<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="AccountCreateServlet?choice=create" method="post">
	아이디(4~10자리) : <input type="text" name="id">
	<input type="submit" value="중복확인" formaction="AccountCreateServlet?choice=checkId" formmethod="post"><br>
	닉네임(4~10자리) : <input type="text" name="nick">
	<input type="submit" value="중복확인" formaction="AccountCreateServlet?choice=checkNick" formmethod="post"><br>
	패스워드(6~20자리) : <input type="text" name="pass"><br>
	패스워드 재입력 : <input type="text" name="pass2"><br><br>
	<button type="button" onclick="location.href='login.html'">취소</button>
	<input type="submit" value="회원가입">
</form>
</body>
</html>