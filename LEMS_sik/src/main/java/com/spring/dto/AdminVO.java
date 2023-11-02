
package com.spring.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class AdminVO {
	private String adminNum;
	private	String email;
	private String pwd;
	private String name;
	private String roll;
	private Date regDate;
	private String phone; // 전화번호
	private String picture; // 사진파일 경로/파일명
	private int enabled; // 사용여부
	private String address;// 주소
	
	public String getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public Date getRegDate() {
		return regDate;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "AdminVO [adminNum=" + adminNum + ", email=" + email + ", pwd=" + pwd + ", name=" + name + ", roll="
				+ roll + ", regDate=" + regDate + "]";
	}
		
		
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}

