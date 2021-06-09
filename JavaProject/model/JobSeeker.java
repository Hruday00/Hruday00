package model;
import java.sql.SQLException;
import java.util.Scanner;
import Controller.Client;
public class JobSeeker implements Client {

	private String name;
	private String password;
	private String email;
	private String phone;
	private String experience;
	private String city;
	private String jobSeekerId;

	public JobSeeker() {
		super();
	}
	
	public JobSeeker(String name, String password, String email, String phone, String experience, String city,
			String jobSeekerId) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.experience = experience;
		this.city = city;
		this.jobSeekerId = jobSeekerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getjobSeekerId() {
		return name;
	}

	public void setjobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public void viewDetails() {
		System.out.println("Name: " + this.getName());
		System.out.println("E-mail ID: " + this.getEmail());
		System.out.println("Password: " + this.getPassword());
		System.out.println("Phone number: " + this.getPhone());
		System.out.println("City: " + this.getCity());
		System.out.println("Experience:" + this.getExperience());
		this.jobSeekerId = this.phone + this.email;
	}

}