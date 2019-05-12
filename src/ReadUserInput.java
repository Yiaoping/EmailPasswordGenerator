import java.util.Scanner;

public class ReadUserInput {
	
	static Scanner sc = new Scanner(System.in);
	
	public String optionOne() {
		System.out.println("Type in any username: ");
		String user = sc.nextLine();
		System.out.println("Type in only the domain name: (ex. hotmail/gmail/outlook)");
		String domainName = sc.nextLine();
		
		String [] optionOne = new String [2];
		optionOne[0] = user;
		optionOne[1] = domainName;
		
		String generatedEmail = Generate.generateEmail(optionOne[0], optionOne[1]);
		System.out.println(generatedEmail);
		
		return generatedEmail;
		
	}

	public String optionTwo() {
		System.out.println("Enter in a password length from 8-16");
		int pwLength = Integer.parseInt(sc.nextLine());
		
		//checks to see if pw length is under 8 or over 16 long
		while(pwLength>16 || pwLength<8 ) {
			System.out.println("Enter in a new password length or 0 to quit.");
			pwLength = Integer.parseInt(sc.nextLine());
			if(pwLength == 0) {
				System.exit(0);
			}
		}
		String generatedPW = Generate.generatePass(pwLength);
		System.out.println("Password: " + generatedPW);
		return generatedPW;
	}

	public String[] optionThree() {
		System.out.println("Type in a username: ");
		String userWithPass = sc.nextLine();
		System.out.println("Type in only the domain name: (ex. hotmail/gmail/outlook)");
		String domainName = sc.nextLine();
		System.out.println("Enter in a password length of 8-16");
		int pwLengthEmail = Integer.parseInt(sc.nextLine());
		while(pwLengthEmail> 16 || pwLengthEmail < 8) {
			System.out.println("Enter in a proper password length between 8 and 16, or 0 to quit");
			pwLengthEmail = Integer.parseInt(sc.nextLine());
			if(pwLengthEmail==0) {
				System.exit(0);;
			}
		}
		String resultEmailPass [] = Generate.generateEmailPassword(userWithPass, domainName, pwLengthEmail);
		System.out.println("Email: " + resultEmailPass[0]); 
		System.out.println("Password: " + resultEmailPass[1]);
		return resultEmailPass;
	}

}
