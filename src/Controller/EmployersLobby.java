package Controller;
import java.sql.SQLException;
import java.util.Scanner;

import model.Employer;
import model.Job;
import service.DatabaseProvider;

public class EmployersLobby{

	static int count;
	static boolean flag;

	public static void employersMenu(Client client) {
		
		Scanner in = new Scanner(System.in);
		SignOut signout = new SignOut();
		Employer employer = (Employer) client;
		System.out.println("Hello " + employer.getName() + " What would you like to do today?");
		
		int option;
		System.out.println("\n1.PostJobs\n2.ViewApplicants\n3.Logout");
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				postJobs(client);
				valid = true;
			}
				break;

			case 2: {
				viewApplicants(client);
				valid = true;
			}
				break;


			case 3: {
				signout.signOut();
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}

	}

	public static void viewApplicants(Client client) {

		Scanner in = new Scanner(System.in);
		SignOut signout = new SignOut();
		Employer employer = (Employer) client;
		int choice;
		boolean flag = false;
		count=0;
		
		for (Job jobsPosted : HomePage.jobs) {
			if ((jobsPosted.getEmployerId()).equals(employer.getEmployerId())) {
				flag = true;
				HomePage.applicants.forEach((key, value) -> {
					if ((jobsPosted.getJobId()).equals(key)) {
					System.out.println("--Applicant no: " + (++count) + "-------------------");
					System.out.println("Name: " + value.getName());
					System.out.println("E-mail ID: " + value.getEmail());
					System.out.println("Password: " + value.getPassword());
					System.out.println("Phone number: " + value.getPhone());
					System.out.println("City: " + value.getCity());
					System.out.println("Experience:" + value.getExperience());}
				});
			}
		}
		if (!flag) {
			System.out.println("No jobs posted yet!!");
		}

		if (count == 0) {
			System.out.println("No Applicants have applied!!");
		}
		int option;
		System.out.println("\n1.Menu\n2.Logout");
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				employersMenu(client);
				valid = true;
			}
				break;

			case 2: {
				signout.signOut();
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
	}

	public static void postJobs(Client client) {

		Scanner in = new Scanner(System.in);
		Employer employer = (Employer) client;

		Job job = new Job();
		System.out.println("Enter your Company name:");
		job.setCompanyName(in.nextLine());
		System.out.println("Enter the Job title:");
		job.setJobTitle(in.nextLine());
		System.out.println("Enter the main language:");
		job.setLanguage(in.nextLine());
		System.out.println("Enter the kind of employment:");
		job.setEmployment(in.nextLine());
		System.out.println("Enter the Job description:");
		job.setJobDescription(in.nextLine());
		System.out.println("Enter the Job Location:");
		job.setJobLocation(in.nextLine());
		job.setJobId(Integer.toString(HomePage.jobs.size() + 1));
		job.setEmployerId(employer.getEmployerId());
		DatabaseProvider db = new DatabaseProvider();
		try {
			db.jobstore(job);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HomePage.jobs.add(job);
		System.out.print("Job posted successfully\n");
		SignOut l = new SignOut();

		int option;
		System.out.println("\n1.Menu\n2.Logout");
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				employersMenu(client);
				valid = true;
			}
				break;

			case 2: {
				l.signOut();
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
	}
}