package org.project.jobportal;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {

	
	public static Client signUpAs() {

		Scanner in=new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("\t\tSignUp");
		System.out.println("========================================");
		

		
		System.out.println("\nRegister as :\n");
		System.out.println("       1.Employer  |  2.Job Seeker");
		Client client=null;
		int option;
		
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			if (option == 1) {
				client = getEmployer();
				valid = true;
			} else if (option == 2) {
				client =getJobSeeker();
				valid = true;
			} else {
				System.out.println("Wrong option try again!!");
			}
		}
		
		if (client instanceof Employer) {
			HomePage.employers.put(((Employer) client).getEmail(), (Employer) client);
		} else if (client instanceof JobSeeker) {
			HomePage.jobseekers.put(((JobSeeker) client).getEmail(), (JobSeeker) client);
		}

		return client;
	}
	
	static JobSeeker getJobSeeker(){
		
		JobSeeker jobseeker=new JobSeeker();
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nEnter your details below\n");
		System.out.println("Enter your Name:");
		jobseeker.setName(in.nextLine());
		
		System.out.println("Enter your E-mail id:");
		String email = in.nextLine();
		System.out.println("Enter your Password:");
		String password = in.nextLine();
		
		while(!SignIn.isValidMail(email,password)){
            System.out.println("\nEnter your E-mail id:");
	        email = in.nextLine();
		    System.out.println("Enter your Password:");
	        password = in.nextLine();
		} 
		jobseeker.setEmail(email);
		jobseeker.setPassword(password);
		
		System.out.println("Enter your Phone number:");
		jobseeker.setPhone(in.nextLine());
		System.out.println("Enter your City:");
		jobseeker.setCity(in.nextLine());
		System.out.println("Enter your Experience:");
		jobseeker.setExperience(in.nextLine());
		jobseeker.setjobSeekerId(jobseeker.getEmail()+jobseeker.getPhone() );
		DatabaseProvider db = new DatabaseProvider();
		try {
			db.jobseekerStore(jobseeker);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jobseeker;
	}
	
	static Employer getEmployer(){
		
		Employer employer=new Employer();
		Scanner in=new Scanner(System.in);
		
		System.out.println("\nEnter your details below\n");
		System.out.println("Enter your Name:");
		employer.setName(in.nextLine());
		
		System.out.println("Enter your E-mail id:");
		String email = in.nextLine();
		System.out.println("Enter your Password:");
		String password = in.nextLine();
		
		/*
		while(!SignIn.isValidMail(email,password)){
            System.out.println("\nEnter your E-mail id:");
	        email = in.nextLine();
		    System.out.println("Enter your Password:");
	        password = in.nextLine();
		} */
		
		employer.setEmail(email);
		employer.setPassword(password);
		
		System.out.println("Enter your Phone number:");
		employer.setPhone(in.nextLine());
		System.out.println("Enter your Company Name:");
		employer.setCompanyName(in.nextLine());
		System.out.println("Enter your Company Type:");
		employer.setCompanyType(in.nextLine());
		System.out.println("Enter your Job roll:");
		employer.setJob(in.nextLine());
		employer.setEmployerId(employer.getPhone()+employer.getEmail());
		DatabaseProvider db = new DatabaseProvider();
		try {
			db.employerStore(employer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employer;
	}

}
