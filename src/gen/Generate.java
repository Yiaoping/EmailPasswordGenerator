package gen;

public class Generate {
	
	private final static String passwordSetDigits = "1234567890";
	private final static String passwordSetChars = "abcdefghijklmnopqrstuvwxyz";
	private final static String passwordSetCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String passwordSetSpecialChars = "!@#$&";
	
	/*Generates a new user email, appending four random digits to the user's username*/
	public static String generateEmail(String user, String domainName) {
		StringBuilder userEmail = new StringBuilder();
		userEmail.append(user);
		for(int i=0; i<4; i++) {
			int rand = (int) (Math.random() * 10);
			userEmail.append(rand);
		}
		userEmail.append("@" + domainName + ".com");
		return new String (userEmail);
	
	}

	public static String generatePass(int length) {
		
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

	
	public static String[] generateEmailPassword(String userWithPass, String domainName, int pwLength) {

		String emailPassword = generateEmail(userWithPass, domainName);
		String passwordEmail = generatePass(pwLength);
		EmailPassword ep = new EmailPassword();
		return ep.getInfo(emailPassword, passwordEmail);
		
	}

}
