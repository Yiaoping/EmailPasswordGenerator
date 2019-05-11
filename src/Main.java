import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		System.out.println((int)3.64);
		System.out.println("Please enter in a option: \n1) Email \n2) Password \n3) Email + Password \n4) Exit");
		Scanner sc = new Scanner(System.in);
		try {
			int userOption = Integer.parseInt(sc.nextLine());
			if(userOption == 1) {
				System.out.println("Type in any username: ");
				String user = sc.nextLine();
				System.out.println("Type in only the domain name: (ex. hotmail/gmail/outlook)");
				String domainName = sc.nextLine();
				String generatedEmail = generateEmail(user, domainName);
				System.out.println(generatedEmail);
				
			}else if (userOption == 2) {
				System.out.println("Enter in a password length from 8-16");
				int pwLength = Integer.parseInt(sc.nextLine());
				
				//checks to see if pw length is under 8 or over 16 long
				while(pwLength>16 || pwLength<8 ) {
					System.out.println("Enter in a new password length or 4 to quit.");
					pwLength = Integer.parseInt(sc.nextLine());
					if(pwLength == 4) {
						return;
					}
				}
				System.out.println(generatePass(pwLength));
				
				
			}else if (userOption == 3) {
				System.out.println("Type in a username: ");
				String userWithPass = sc.nextLine();
				System.out.println("Type in only the domain name: (ex. hotmail/gmail/outlook)");
				String domainName = sc.nextLine();
				System.out.println("Enter in a password length of 8-16");
				int pwLengthEmail = Integer.parseInt(sc.nextLine());
				while(pwLengthEmail> 16 || pwLengthEmail < 8) {
					System.out.println("Enter in a proper password length between 8 and 16, or 4 to quit");
					pwLengthEmail = Integer.parseInt(sc.nextLine());
					if(pwLengthEmail==4) {
						return;
					}
				}
				String resultEmailPass [] = generateEmailPassword(userWithPass, domainName, pwLengthEmail);
				System.out.println("Email: " + resultEmailPass[0]); 
				System.out.println("Password: " + resultEmailPass[1]);
				
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
	private static String generateEmail(String user, String domainName) {
		StringBuilder userEmail = new StringBuilder();
		userEmail.append(user);
		for(int i=0; i<4; i++) {
			int rand = (int) (Math.random() * 10);
			userEmail.append(rand);
		}
		userEmail.append("@" + domainName + ".com");
		return new String (userEmail);
		
	}
	
	
	private static String generatePass(int length) {
		String passwordSetDigits = "1234567890";
		String passwordSetChars = "abcdefghijklmnopqrstuvwxyz";
		String passwordSetCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String passwordSetSpecialChars = "!@#$&";
		char [] password = new char[length];
		int count = 1;
		for(int i=0; i<length; i++) {
			int rd;
			if(count%4 == 0) {
				rd = (int)(Math.random() * passwordSetDigits.length());
				password[i] = passwordSetDigits.charAt(rd);
			}else if(count%4 == 1) {
				rd = (int)(Math.random() * passwordSetChars.length());
				password[i] = passwordSetChars.charAt(rd);
			}else if(count%4 == 2) {
				rd = (int)(Math.random() * passwordSetCaps.length());
				password[i] = passwordSetCaps.charAt(rd);
			}else if(count%4 == 3) {
				rd = (int)(Math.random() * passwordSetSpecialChars.length());
				password[i] = passwordSetSpecialChars.charAt(rd);
			}
			count++;
		}
		return new String(password);
		
	}

	
	private static String[] generateEmailPassword(String userWithPass, String domainName, int pwLength) {
		
		
		String emailPassword = generateEmail(userWithPass, domainName);
		String passwordEmail = generatePass(pwLength);
		
		EmailPassword ep = new EmailPassword();
		return ep.getInfo(emailPassword, passwordEmail);
		
	}
	
	
}
