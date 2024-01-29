package model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskBean {
	
	private int taskId;
	private String taskName;
	private int categoryId;
	private String categoryName;
	private LocalDate limitDate;
	private String userId;
	private String userName;
	private char statusCode;
	private String statusName;
	private String memo;
	private LocalDateTime createDatetime;
	private LocalDateTime updateDatetime;
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public LocalDate getLimitDate() {
		return limitDate;
	}
	
	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public char getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(char statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}
	
	public void setCreateDatetime(LocalDateTime createDatetime) {
		this.createDatetime = createDatetime;
	}
	
	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}
	
	public void setUpdateDatetime(LocalDateTime updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
