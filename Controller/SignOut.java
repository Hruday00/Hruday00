package Controller;
import service.DatabaseProvider;
public class SignOut {

	public static void signOut() {

		System.out.println("\n========================================");
		System.out.println("\t      Signing out");
		System.out.println("========================================");

		DatabaseProvider db=new DatabaseProvider();
		try {
			db.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		HomePage homepg = new HomePage();
		homepg.loginDetails();
	}
}