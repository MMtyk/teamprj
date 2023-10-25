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
String id = (String)request.getAttribute("id");
String idChk = (String)request.getAttribute("idChk");
String nickChk = (String)request.getAttribute("nickChk");
%>
<form action="AccountCreateServlet?choice=create" method="post">
	아이디(4~10자리)a : <input type="text" name="id" value=${id }>
	<input type="submit" value="중복확인" formaction="AccountCreateServlet?choice=checkId" formmethod="post">
	<input type="text" disabled value=${idChk }><br>
	닉네임(4~10자리) : <input type="text" name="nick" value=${nick }>
	<input type="submit" value="중복확인" formaction="AccountCreateServlet?choice=checkNick" formmethod="post">
	<input type="text" disabled value=${nickChk }><br>
	패스워드(6~20자리) : <input type="text" name="pass"><br>
	패스워드 재입력 : <input type="text" name="pass2"><br><br>
	<button type="button" onclick="location.href='login.jsp'">취소</button>
	<input type="submit" value="회원가입">
</form>
</body>
</html>