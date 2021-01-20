package payrollSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conn {
	public Connection c;
	public Statement s;
	
	public Conn() {
		try {
			// register jdbc driver in our program
			String name = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(name);
			
			// url to connect to microsoft mysql server
			String url = "jdbc:sqlserver://DESKTOP-R93LQUO\\SQLEXPRESS;databaseName=PayrollSystem;integratedSecurity=true";
			// connection setup 
			c = DriverManager.getConnection(url);
			// access the database
			s = c.createStatement();
			System.out.println("connected");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
