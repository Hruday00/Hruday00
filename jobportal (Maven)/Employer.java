package org.project.jobportal;

import java.util.Scanner;

public class Employer implements Client{
	
	private String name;
	private String phone;
	private String email;
	private String password;
	private String companyName;
	private String companyType;
	private String job;
	private String employerId;
	
	
	public Employer() {
		super();
	}
	
	public Employer(String name, String phone, String email, String password, String companyName, String companyType,
			String job, String employerId) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.companyName = companyName;
		this.companyType = companyType;
		this.job = job;
		this.employerId = employerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmployerId(){
		return employerId;
	}
	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}
	
	public void viewDetails() {
		
		System.out.println("Name: "+this.getName());
		System.out.println("E-mail ID: "+this.getEmail());
		System.out.println("Password: "+this.getPassword());
		System.out.println("Phone number: "+this.getPhone());
		System.out.println("Company Name: "+this.getCompanyName());
		System.out.println("Company Type: "+this.getCompanyType());
		System.out.println("Job roll: "+this.getJob());
		
	}

}
