<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<div>ログアウト画面</div>
	
	<div>お疲れ様でした！<%=(String) session.getAttribute("userName") %>さん</div>
	
	<% session.invalidate(); %>
	
	<div>ログアウトしました。</div>
	
	<form action="login.jsp">
		<input type="submit" value="ログイン画面へ">
	</form>
</body>
</html>