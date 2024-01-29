<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath() %>/js/clearLoginForm.js"></script>
<title>ログイン画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		UserBean bean = (UserBean) request.getAttribute("userBean");
		String errorMessage = (String) request.getAttribute("errorMessage");
	%>
	
	<div>ログイン画面</div>
	
	<% if (errorMessage != null) { %>
	<div><%=errorMessage %></div>
	<% } %>
	
	<div>ユーザIDとパスワードを入力してください</div>
	
	<form action="loginServlet" method="POST">
		
		<div>
			<label for="userId">ユーザID</label>
			<input type="text" id="userId" name="userId" value="<% if (bean != null) { %><%=bean.getUserId() %><% } %>" maxlength="24" required>
		</div>
		
		<div>
			<label for="password">パスワード</label>
			<input type="password" id="password" name="password" value="<% if (bean != null) { %><%=bean.getPassword() %><% } %>" maxlength="32" required>
		</div>
		
		<input type="submit" value="ログイン">
		
		<input type="button" onclick="clearLoginForm()" value="クリア">
		
	</form>
</body>
</html>