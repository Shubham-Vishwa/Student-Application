package jdbc;
import java.sql.*;
public class DBConnection {
	
	private static Connection con = null;
	
	private DBConnection() {} // Restricting user to create it's object from outside
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","Vishwa123");
		}catch(Exception e) {e.printStackTrace();}
	}	// connection stablised only once while class loading. 
	
	public static Connection getCon() {
		return con;
	}	// Connection can be reused by calling this method.
}
