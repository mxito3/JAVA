package com.qq.common;

public class User implements java.io.Serializable{
    private String User_id;
    private String Password;
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
