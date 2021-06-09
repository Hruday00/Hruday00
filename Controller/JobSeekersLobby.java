package Controller;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import model.Job;
import model.JobSeeker;
import service.DatabaseProvider;

public class JobSeekersLobby  {
	
	static boolean flag;
	
	public static void jobSeekersMenu(Client client) {
	
		Scanner in = new Scanner(System.in);
		JobSeeker jobseeker = (JobSeeker) client;
		System.out.println("\nHello " + jobseeker.getName() + "\nWhat would you like to today?");
		
		int option;
		System.out.println("\n1.Search Jobs\n2.ViewApplications\n3.Logout");
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				searchJobs(client);
				valid = true;
			}
				break;

			case 2: {
				viewApplications(client);
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
	}

	public static void searchJobs(Client client) {

		Scanner in = new Scanner(System.in);
		
		System.out.println();
		for (Job job : HomePage.jobs) {
			System.out.println("--Job ID:" + job.getJobId() + "-------------------");
			System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
			System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
			System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
		}

		System.out.println("\n1.Apply for a job\n2.Apply filter");
		int option;
		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				applyJobs(client);
				valid = true;
			}
				break;

			case 2: {
				filterJobs(client);
				valid = true;
			}
				break;
			case 3: {
				SignOut signout=new SignOut();
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

	public static void filterJobs(Client client) {

		Scanner in = new Scanner(System.in);
		System.out.println("1.Company name   2.Job Title");
		 System.out.println("\n3.Language 4.Location");
		int option;
		String filter = "";

		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				System.out.println("Enter the Company name:");
				in.nextLine();
				filter = in.nextLine();
				System.out.println("Enter the Company name:" + filter);
				for (Job job : HomePage.jobs) {
					if ((job.getCompanyName()).equals(filter)) {
						System.out.println("--Job ID:" + job.getJobId() + "-------------------");
						System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
						System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
						System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
					}

				}
				valid = true;
			}
				break;
			case 2: {
				System.out.println("Enter the Job Title:");
				in.nextLine();
				filter = in.nextLine();
				for (Job job : HomePage.jobs) {
					if ((job.getJobTitle()).equals(filter)) {
						System.out.println("--Job ID:" + job.getJobId() + "-------------------");
						System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
						System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
						System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
					}
				}
				valid = true;
			}
				break;
			
			  case 3:{ System.out.println("Enter the Language name:");
			  in.nextLine();
			  filter=in.nextLine(); 
			  for (Job job :HomePage.jobs) {
				  if((job.getLanguage()).equals(filter)) {
					  System.out.println("--Job ID:" + job.getJobId() + "-------------------");
				      System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
					  System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
					  System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription()); 
				  }
			  }
			  valid=true; }
			  break;
			  
			  case 4:{ System.out.println("Enter the Location name:");
			  in.nextLine();
			  filter=in.nextLine(); for (Job job : HomePage.jobs) {
			  if((job.getJobLocation()).equals(filter)) {
				  System.out.println("--Job ID:" + job.getJobId() + "-------------------");
					System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
					System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
					System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
				}
			  } 
			  }
			  break;
			 
			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
		System.out.println("\n1.Apply\n2.Menu\n3.Logout");
		for (boolean valid1 = false; !valid1;) {
			option = in.nextInt();
			switch (option) {

			case 1: {
				applyJobs(client);
				valid1 = true;
			}
				break;

			case 2: {
				jobSeekersMenu(client);
				valid1 = true;
			}
				break;

			case 3: {
				SignOut signOut = new SignOut();
				signOut.signOut();
				valid1 = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}

		}
	}

	public static void viewApplications(Client client) {
		Scanner in = new Scanner(System.in);
		JobSeeker jobseeker = (JobSeeker) client;

		System.out.println();
		HomePage.applicants.forEach((key, value) -> {
			if ((value.getjobSeekerId()).equals(jobseeker.getjobSeekerId())) {
				for (Job job : HomePage.jobs) {
					if ((key).equals(job.getJobId())) {
						System.out.println("--Job ID:" + job.getJobId() + "-------------------");
						System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
						System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
						System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
						System.out.println();
						System.out.println("You have applied for the above jobs");
						flag=true;
					}
				}
			}
		});

		if (!flag) {
			System.out.println("You have not yet applied for a job!!\n");
		}
		System.out.println("\n1.Menu\t2.Logout");
		int option = in.nextInt();
		for (boolean valid = false; !valid;) {

			switch (option) {

			case 1: {
				jobSeekersMenu(client);
				valid = true;
			}
				break;

			case 2: {
				SignOut signOut = new SignOut();
				signOut.signOut();
				valid = true;
			}
				break;

			default: {
				System.out.println("Wrong option try again!!");
			}
			}
		}
	}

	public static void applyJobs(Client client) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the Job ID number to be applied:");
		String id = in.nextLine();
		JobSeeker jobseeker = (JobSeeker) client;

		for (Job job : HomePage.jobs) {
			System.out.println("--Job ID:" + job.getJobId() + "-------------------");
			System.out.println("Company: " + job.getCompanyName() + " Job Title: " + job.getJobTitle());
			System.out.println("Employment: " + job.getEmployment() + " Skill Required: " + job.getLanguage());
			System.out.println("Locatin: " + job.getJobLocation() + " Description: " + job.getJobDescription());
		}
		DatabaseProvider db = new DatabaseProvider();
		boolean flag = false;
		for (Job job : HomePage.jobs) {
			if (job.getJobId().equals(id)) {
				HomePage.applicants.put(job.getJobId(), jobseeker);

				try {
					db.jobApplicantStore(jobseeker, job.getJobId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("\nSuccessfully applied for this job");
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("No Such Job Id found, Try again");
		}

		System.out.println("\n1.Menu\t2.Logout");
		int option = in.nextInt();
		for (boolean valid = false; !valid;) {

			switch (option) {

			case 1: {
				jobSeekersMenu(client);
				valid = true;
			}
				break;
			case 2: {
				SignOut signOut = new SignOut();
				signOut.signOut();
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