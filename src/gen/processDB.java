package gen;
import java.util.Scanner;

public class processDB {
	static DatabaseHelper db = new DatabaseHelper();
	
	static Scanner sc = new Scanner(System.in);
	public static void processEmail(String email) {
		System.out.println("Enter in the purpose for your email: ");
		String emailPurpose = sc.nextLine();
		db.insertEmail(email, emailPurpose);
	}
	public static void processPW(String generatedPW) {
		System.out.println("Enter in the purpose for your password: ");
		String passwordPurpose = sc.nextLine();
		db.insertPassword(generatedPW, passwordPurpose);
	}
	public static void processEmailPassword(String email, String password) {
		System.out.println("Enter in the purpose for your email and password: ");
		String purposeEmPass = sc.nextLine();
		db.insertEmailAndPass(email, password, purposeEmPass);
	}
	public static void processQuery() {
		System.out.println("Enter in your keyword purpose associated with the information: ");
		String inputQuery = sc.nextLine();
		db.query(inputQuery);
	}
	public static void testLogin() throws Exception {
		System.out.println("Enter in your username/email: ");
		String inputUser = sc.nextLine();
		System.out.println("Enter in your password: ");
		String inputPassword = sc.nextLine();
		db.testWeakLogin(inputUser, inputPassword);
	}
	
	

}
