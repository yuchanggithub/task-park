package model.entity;

import java.time.LocalDateTime;

public class UserBean {
	
	private String userId;
	private String password;
	private String userName;
	private LocalDateTime updateDatetime;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}
	
	public void setUpdateDatetime(LocalDateTime updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
