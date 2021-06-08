package com.example.dto;

import java.time.LocalDateTime;

public class Member {
	private String member_id;
	private String email;
	private String password;
	private String name;
	private String phone;
	//private LocalDateTime registerDateTime;
	public Member(String member_id,String email, String password, String name, String phone)
	{
	this.member_id=member_id;
	this.email = email;
	this.password = password;
	this.name = name;
	this.phone=phone;
	//this.registerDateTime = regDateTime;
	}
	public String getId() {
		return member_id;
	}
	public void setId(String member_id) {
		this.member_id = member_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
