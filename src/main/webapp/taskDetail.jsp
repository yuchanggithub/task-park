<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク詳細画面</title>
</head>
<body>
	<% TaskBean bean = (TaskBean) session.getAttribute("taskBean"); %>
	
	<div>タスク詳細画面</div>
	
	<table>
		<tr>
			<th>タスクID</th>
			
			<td><%=bean.getTaskId() %></td>
		</tr>
		
		<tr>
			<th>タスク名</th>
			
			<td><%=bean.getTaskName() %></td>
		</tr>
		
		<tr>
			<th>カテゴリ名</th>
			
			<td><%=bean.getCategoryName() %></td>
		</tr>
		
		<tr>
			<th>期限</th>
			
			<% if (bean.getLimitDate() != null) { %>
			<td><%=bean.getLimitDate() %>円</td>
			<% } else { %>
			<td></td>
			<% } %>
		</tr>
		
		<tr>
			<th>ユーザ名</th>
			
			<td><%=bean.getUserName() %></td>
		</tr>
		
		<tr>
			<th>ステータス名</th>
			
			<td><%=bean.getStatusName() %></td>
		</tr>
		
		<tr>
			<th>メモ</th>
			
			<td><%=bean.getMemo() %></td>
		</tr>
		
		<tr>
			<th>登録日時</th>
			
			<% Timestamp ts1 = Timestamp.valueOf(bean.getCreateDatetime()); %>
			<td><%=ts1 %></td>
		</tr>
		
		<tr>
			<th>更新日時</th>
			
			<% Timestamp ts2 = Timestamp.valueOf(bean.getUpdateDatetime()); %>
			<td><%=ts2 %></td>
		</tr>
	</table>
	
	<div>
		<form action="taskUpdate.jsp">
			<input type="submit" value="変更する">
		</form>
		
		<form action="taskDelete.jsp">
			<input type="submit" value="削除する">
		</form>
		
		<form action="taskListServlet">
			<input type="submit" value="一覧表示">
		</form>
	</div>
</body>
</html>