package gen;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseHelper {
	
	public static void main (String args[]) {
		delete();
	}
	
	private static String tableName = "accounts";
	public static void createTable() {
		try {

			Connection connection = getConnection();
			PreparedStatement createTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS "+tableName+"(id INT NOT NULL AUTO_INCREMENT, email VARCHAR(50), password VARCHAR(16), purpose VARCHAR(255), PRIMARY KEY(id));");
			createTable.execute();	
			System.out.println("Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() throws Exception {
		String info[] = getProperties();
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/generator";
		String username = info[0];
		String password = info[1];
		Class.forName(driver).newInstance();
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		return connection;
	}
	
	public void insertEmailAndPass(String email, String password, String purpose) {
		try {	
			Connection connection = getConnection();																						//'email', 'password', 'purpose';			
			PreparedStatement insertBoth = connection.prepareStatement("INSERT INTO " + tableName + " (email, password, purpose) VALUES ('" + email + "', '" + password + "', '" + purpose + "');"); 
			int inserted = insertBoth.executeUpdate();
			System.out.println("Inserted email and password: " + inserted + " rows");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertPassword(String password, String purpose) {
		try {
			Connection connection = getConnection();
			PreparedStatement insertOnePassword = connection.prepareStatement("INSERT INTO "+ tableName + " (password, purpose) VALUES ('" +password + "', '" + purpose + "');");
			int inserted = insertOnePassword.executeUpdate();
			System.out.println("Inserted password: " + inserted + " row(s)");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void insertEmail(String email, String purpose) {
		try {
			Connection connection = getConnection();
			PreparedStatement insertOneEmail = connection.prepareStatement("INSERT INTO " + tableName + " (email, purpose) VALUES ('" + email + "', '" + purpose + "');");
			int inserted = insertOneEmail.executeUpdate();
			System.out.println("Inserted email: " + inserted + " row(s)");
		}catch (Exception e) {
			System.out.println("Unable to insert into table");
			e.printStackTrace();
		}
	}
	
	
	public void query(String query) {
		try {
			Connection connection = getConnection();
			PreparedStatement queryStatement = connection.prepareStatement(query);
			ResultSet rs = queryStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			
			while(rs.next()) {
				for(int i=1; i<=columnNumber; i++) {	
					String columnValue = rs.getString(i);
					System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
					System.out.print("\t\t");
				}
				System.out.println("");
			}

		}catch (Exception e) {
			
		}
	}
	//manually edit
	public static void delete() {
		try {
			Connection connection = getConnection();
			PreparedStatement deleteItem = connection.prepareStatement("DELETE FROM " + tableName);
			int deleted = deleteItem.executeUpdate();
			System.out.println("Deleted: " + deleted + " row(s)" );
		}catch (Exception e) {
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
