import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
		System.out.println("Please enter in a option: \n1) Email \n2) Password \n3) Email + Password \n4) Exit");
		Scanner sc = new Scanner(System.in);
		try {
			int userOption = Integer.parseInt(sc.nextLine());
			if(userOption == 1) {
				System.out.println("Type in any username: ");
				String user = sc.nextLine();
				String generatedEmail = generateEmail(user);
				System.out.println(generatedEmail);
				
			}else if (userOption == 2) {
				System.out.println("Creating password");
				generatePass();
			}else if (userOption == 3) {
				System.out.println("Type in a username: ");
				String userAndPass = sc.nextLine();
				generateEmailPassword(userAndPass);
			}else {
				System.out.println("Enter in a digit only, try again");
				return;
			}
		}catch(Exception e){
			System.out.println("Error occured, try again.");
		}
		finally {
			sc.close();
		}

	}




	/*Generates a new user email, appending four random digits to the user's username*/
	private static String generateEmail(String user) {
		StringBuilder userEmail = new StringBuilder();
		userEmail.append(user);
		for(int i=0; i<4; i++) {
			int rand = (int) (Math.random() * 10);
			userEmail.append(rand);
		}
		return new String (userEmail);
		
	}
	

	private static void generatePass() {
		
	}

	
	private static void generateEmailPassword(String userAndPass) {
		
	}
	
	
}
