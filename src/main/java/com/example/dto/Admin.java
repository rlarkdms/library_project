package com.example.dto;

public class Admin {
	private String Admin_id;
	private String password;
	private String name;
	private String rank;
	//private LocalDateTime registerDateTime;
	public Admin(String Admin_id,String password, String name, String rank)
	{
	this.Admin_id=Admin_id;
	this.password = password;
	this.name = name;
	this.rank = rank;
	}
	public String getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(String admin_id) {
		Admin_id = admin_id;
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
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
