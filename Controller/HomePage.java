package Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Employer;
import model.Job;
import model.JobSeeker;
import service.DatabaseProvider;

public class HomePage {

	public static Map<String, Employer> employers = new HashMap<String, Employer>();
	public static Map<String, JobSeeker> jobseekers = new HashMap<String, JobSeeker>();
	public static Map<String, JobSeeker> applicants = new HashMap<String, JobSeeker>();
	public static List<Job> jobs = new ArrayList<Job>();
	
	
	public static void init() {
		
		System.err.println("\t\tWELCOME");
		DatabaseProvider database = new DatabaseProvider();
		
		try {
			database.retrieve();
		} catch (Exception e) {

			e.printStackTrace();
		}
		loginDetails();
	}

	public static void loginDetails() {
		
		Scanner in = new Scanner(System.in);
		SignUp signUp = new SignUp();
		System.out.println("========================================");
		System.out.println("\t\t Home");
		System.out.println("========================================");
		 
		DatabaseProvider database = new DatabaseProvider();
		//database.connect();
		
		//System.out.println(employers);

		System.out.println("\n\t1.SignIn   |    2.SignUp");
		int option;

		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				lobby();
				valid = true;
			}
				break;

			case 2: {
				signUp.signUpAs();
				lobby();
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
	}

	public static void lobby() {
		SignIn signIn = new SignIn();

		Client client = signIn.signInAs();

		if (client != null) {
			if (client instanceof Employer) {
				EmployersLobby.employersMenu(client);
			} else if (client instanceof JobSeeker) {
				JobSeekersLobby.jobSeekersMenu(client);
			}
		} else {
			loginDetails();
		}

	}
	
	
}