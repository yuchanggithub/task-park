<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.entity.CategoryBean, model.entity.UserRegisterBean, model.entity.StatusBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");

// List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
List<UserRegisterBean> userList = (List<UserRegisterBean>) session.getAttribute("userList");
List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
%>

<header>
	<h1>タスク登録画面</h1>
</header>

<form action = "taskRegisterServlet" method = "POST">
	<table>

    <!-- タスク名を入力 -->
    <tr>
      <th>タスク名</th>
      <td>
        <input type = "text" name = "taskName">
      </td>
    </tr>

    <!-- カテゴリを入力 -->
		<tr>
			<th>カテゴリ</th>
			<td>
				<select name = "categoryId">
				<%
				for (CategoryBean category : categoryList) {
				%>
				<option value = "<%=category.getCategoryId()%>">
				<%=category.getCategoryName()%>
				</option>
				<%
				}
				%>
				</select>
			</td>
		</tr>

    <!-- 期限を入力 -->
    <tr>
			<th>期限</th>
			<td>
				<input type = "date" name = "limitDate">
			</td>
		</tr>

    <!-- 担当者を入力 -->
    <tr>
			<th>担当者</th>
			<td>
				<select name = "userId">
				<%
				for (UserRegisterBean user : userList) {
				%>
				<option value = "<%=user.getUserId()%>">
				<%=user.getUserName()%>
				</option>
				<%
				}
				%>
      </select>
      </td>
    </tr>

    <!-- ステータスを入力 -->
    <tr>
      <th>ステータス</th>
      <td>
        <select name = "statusCode">
        <%
        for (StatusBean status : statusList) {
        %>
        <option value = "<%=status.getStatusCode()%>">
        <%=status.getStatusName()%>
        </option>
        <%
        }
        %>
      </select>
      </td>
    </tr>

    <!-- メモを入力 -->
		<tr>
			<th>メモ</th>
			<td>
				<input type = "text" name = "memo">
			</td>
		</tr>

	</table><br>

	<!-- 登録ボタン -->
	<input type = "submit" value = "タスクを登録">

	<!-- クリアボタン -->
	<input type = "reset" value = "クリア">

</form>

<!-- メニュー画面へボタン -->
<form action = "menu.jsp" method = "POST">
	<input type = "submit" value = "メニュー画面へ">
</form>

</body>
</html>
