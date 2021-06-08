package com.example.dto;

public class RegisterRequest {
	private String id;
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String phone;
    
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

    
    
    public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(confirmPassword);
    }


}
