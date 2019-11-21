package daoDataJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Trooper {
	public static Connection newConnection() throws SQLException {
		// return a connection here
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/storm_trooper", "root", "root"); 
	}
	
}
