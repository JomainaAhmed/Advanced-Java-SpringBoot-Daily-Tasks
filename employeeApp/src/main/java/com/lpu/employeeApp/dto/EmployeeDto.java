package com.lpu.employeeApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeDto {
	
	@NotBlank(message = "name should not be blank")
	private String name;
	private long phone;
	@Email(message = "email should be valid")
	@Pattern(regexp = "")
	private String email;
	@Min(value = 18, message = "Age must be above 18")
	private int age;
	
	public EmployeeDto() {
		super();
	}
	
	@NotBlank(message = "name should not be blank")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
