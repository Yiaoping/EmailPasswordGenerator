
public class EmailPassword {
	

	EmailPassword(){}
	
	public String[] getInfo(String user, String password) {
		String [] info = new String [2];
		info[0] = user;
		info[1] = password;
		return info;
	}	
	
	
}
