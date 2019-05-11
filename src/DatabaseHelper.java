import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseHelper {
	
	public static void main(String args[]) {
		createTable();
	}
	
	private static String tableName = "accounts";
	public static void createTable() {
		try {

			Connection connection = getConnection();
			PreparedStatement createTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS "+tableName+"(id INT NOT NULL AUTO_INCREMENT, email VARCHAR(50), password VARCHAR(16), purpose VARCHAR(255), PRIMARY KEY(id));");
			createTable.execute();	
			System.out.println("Created table");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() throws Exception {
		String info[] = getProperties();
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/supplements";
		String username = info[0];
		String password = info[1];
		Class.forName(driver).newInstance();
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		return connection;
	}
	
	

	public static void insertEmail(String email) {
		try {
			Connection connection = getConnection();
			PreparedStatement insertOneEmail = connection.prepareStatement("INSERT INTO " + tableName + " " + email);
			int inserted = insertOneEmail.executeUpdate();
			System.out.println("Inserted " + inserted + " row(s)");
		}catch (Exception e) {
			System.out.println("Unable to insert into table");
			e.printStackTrace();
		}
	}
	
	
	private static String[] getProperties() {
		Properties prop = new Properties();
	    InputStream input = null;
	    try {

	        input = new FileInputStream("../config.properties");

	        prop.load(input);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    String[] infoArr = new String[2];
	    infoArr[0] = prop.getProperty("dbuser");
	    infoArr[1] = prop.getProperty("dbpassword");
		return infoArr;	
	}
	
	
	

		
}
