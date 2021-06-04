package org.project.jobportal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
	public class SignIn {

	public static Client isValidUser(String email,String password,int option) {

		Scanner in = new Scanner(System.in);
		String pwd = "";
		Client client = null;
	
		System.out.println("ccccccc"+(HomePage.employers.get(email)).getName());

		if (option == 1) {
			if (HomePage.employers.containsKey(email)) {

				client = HomePage.employers.get(email);
				pwd = HomePage.employers.get(email).getPassword();
				System.out.println("valid mail");
			} else return null;
		} 
		else if (option == 2) {
			if (HomePage.jobseekers.containsKey(email)) {
				client = HomePage.jobseekers.get(email);
				pwd = HomePage.jobseekers.get(email).getPassword();
				System.out.println("valid mail");
			} else return null;
		}
		
		if (!password.equals(pwd)) 
			return null;
		 else
			 System.out.println("valid mail");
			return client;

	}
	
	public static boolean isValidMail(String mail,String password){
        
        String mailPattern=
        "[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
        Pattern p=Pattern.compile(mailPattern);
        Matcher m=p.matcher(mail);
        if(!m.find()){
              System.out.println("Invaild mail Id");
              return false;
        }      
        
        String passwordPattern="[a-z]";
        p=Pattern.compile(passwordPattern);
        m=p.matcher(password);
        if(!m.find()){
              System.out.println("Password should include: \n\"Capital letter\"\n\"Small letter\"\n\"Number\"");
              return false;
        } 
        
        passwordPattern="[A-Z]";
        p=Pattern.compile(passwordPattern);
        m=p.matcher(password);
        if(!m.find()){
               System.out.println("Password should include: \n\"Capital letter\"\n\"Small letter\"\n\"Number\"");
               return false;
        } 
        
        passwordPattern="[0-9]";
        p=Pattern.compile(passwordPattern);
        m=p.matcher(password);
        if(!m.find()){
               System.out.println("Password should include: \n\"Capital letter\"\n\"Small letter\"\n\"Number\"");
               return false;
        } 
        return true;
        
    }
	
	public Client signInAs() {

		System.out.println("========================================");
		System.out.println("\t\t Login");
		System.out.println("========================================");
		
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter your E-mail id:");
		String email = in.nextLine();
		System.out.println("Enter your Password:");
		String password = in.nextLine();
		
		
		while(!isValidMail(email,password)){
            System.out.println("\nEnter your E-mail id:");
	        email = in.nextLine();
		    System.out.println("Enter your Password:");
	        password = in.nextLine();
		} 
		
		System.out.println("\nLogin as :\n");
		System.out.println("       1.Employer  |  2.Job Seeker");
		Client client = null;
		int option;

		for (boolean valid = false; !valid;) {
			option = in.nextInt();
			if (option == 1) {
				client = SignIn.isValidUser(email,password,option);
				valid = true;
			} else if (option == 2) {
				client = SignIn.isValidUser(email,password,option);
				valid = true;
			} else {
				System.out.println("Wrong option try again!!");
			}
		}
		
		if (client != null) {
			System.out.println("Logged in Successfully\n");
			return client;
		} else {

			System.out.println("\nInvalid mail id or Password");
			System.out.println("Try Again?\n");
			return null;
		}
	}

}

