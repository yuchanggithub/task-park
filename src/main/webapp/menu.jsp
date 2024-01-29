<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<div>メニュー画面</div>
	
	<div>ようこそ！<%=(String) session.getAttribute("userName") %>さん</div>
	
	<form action="taskRegisterServlet">
		<input type="submit" value="タスク登録">
	</form>
	
	<form action="taskListServlet">
		<input type="submit" value="タスク一覧">
	</form>
	
	<form action="logout.jsp">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>