<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.entity.TaskBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	@SuppressWarnings("unchecked")
		List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
	%>
	
	<div>タスク一覧表示画面</div>
	
	<table>
		<thead>
			<tr>
				<th>タスクID</th>
				<th>タスク名</th>
				<th>カテゴリ名</th>
				<th>期限</th>
				<th>ユーザ名</th>
				<th>ステータス名</th>
				<th>メモ</th>
				<th>登録日時</th>
				<th>更新日時</th>
			</tr>
		</thead>
		
		<tbody>
			<% for (TaskBean task : taskList) { %>
			<tr>
				<td>
					<a href="taskDetailServlet?taskId=<%=task.getTaskId() %>"><%=task.getTaskId() %></a>
				</td>
				
				<td><%=task.getTaskName() %></td>
				
				<td><%=task.getCategoryName() %></td>
				
				<% if (task.getLimitDate() != null) { %>
				<td><%=task.getLimitDate() %></td>
				<% } else { %>
				<td></td>
				<% } %>
				
				<td><%=task.getUserName() %></td>
				
				<td><%=task.getStatusName() %></td>
				
				<td><%=task.getMemo() %></td>
				
				<% Timestamp ts1 = Timestamp.valueOf(task.getCreateDatetime()); %>
				<td><%=ts1 %></td>
				
				<% Timestamp ts2 = Timestamp.valueOf(task.getUpdateDatetime()); %>
				<td><%=ts2 %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<form action="menu.jsp">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>