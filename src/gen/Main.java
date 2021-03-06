package gen;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String args[]) {

		System.out.println("Please enter in a option: \n1) Email \n2) Password \n3) Email + Password \n4) Weak Query \n5) Login \n0) Exit");
		Scanner sc = new Scanner(System.in);
		ReadUserInput rui = new ReadUserInput();
		try {
			int userOption = Integer.parseInt(sc.nextLine());
			
			switch(userOption) {
			case 1: 
				//processes option and returns an email
				String yourEmail = rui.optionOne();
				
				//add email to database
				processDB.processEmail(yourEmail);
				break;
				
			case 2:
				
				//processes option and returns password
				String yourPassword = rui.optionTwo();
				
				//add password to database
				processDB.processPW(yourPassword);
				break;
			case 3:
				//processes option and returns email and password
				String emailPassword [] = rui.optionThree();
				
				//add email and password to databsae
				processDB.processEmailPassword(emailPassword[0], emailPassword[1]);
				break;
			case 4:
				//processes any user input query
				processDB.processQuery();
				break;
				
			case 5:
				processDB.testLogin();
				break;
			default:
				System.out.println("Enter in a digit only, try again");
				return;

			}
			/*
			if(userOption == 1) {
				//processes option and returns an email
				String yourEmail = rui.optionOne();
				
				//add email to database
				processDB.processEmail(yourEmail);
				
			}else if (userOption == 2) {
				//processes option and returns password
				String yourPassword = rui.optionTwo();
				
				//add password to database
				processDB.processPW(yourPassword);
				
			}else if (userOption == 3) {
				//processes option and returns email and password
				String emailPassword [] = rui.optionThree();
				
				//add email and password to databsae
				processDB.processEmailPassword(emailPassword[0], emailPassword[1]);
				
			}else if (userOption == 4) {
				//processes any user input query
				processDB.processQuery();
				
			}else {
				System.out.println("Enter in a digit only, try again");
				return;
			}*/
		}catch(Exception e){
			System.out.println("Error occured, try again.");
		}
		finally {
			sc.close();
		}

	}
}
