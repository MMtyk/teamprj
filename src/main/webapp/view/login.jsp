<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form action="/teamprj/LoginServlet?choice=login" method="post">
	아이디 : <input type="text" name="op1"><br>
	패스워드 : <input type="password" name="op2"><br><br>
	<input type="submit" value="로그인">
	<input type="submit" formaction="/teamprj/LoginServlet?choice=create" formmethod="post" value="회원가입">
</form>
</body>
</html>