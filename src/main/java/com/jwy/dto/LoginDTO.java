package com.jwy.dto;

public class LoginDTO {
	private String uid;
	private String upw;
	
	private boolean userCookie;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public boolean isUserCookie() {
		return userCookie;
	}

	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + ", userCookie=" + userCookie + "]";
	}
	
	
}
