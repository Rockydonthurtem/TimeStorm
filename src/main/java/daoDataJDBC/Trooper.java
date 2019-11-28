package daoDataJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import beans.User;
 
public class Trooper {
	

	public Connection getConnection() {
		// return a connection here
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/storm_trooper", "root", "root");
			System.out.println("IN TROOPER LOOKING FOR CONN" + conn);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User getUserLoginInfo(String username, String password) throws SQLException {
		User user = null;
		System.out.println("Starting to check user in " + username +"" + password);
		Connection conn = getConnection();
		 //why do we do this?? this i innitializing user to null, will use this after query to set values and update user 
		PreparedStatement stmt = conn.prepareStatement("select id, fname from users where username=? AND password=?");
		stmt.setString(1,username.toString());
		stmt.setString(2, password);
		ResultSet results = stmt.executeQuery();
		System.out.println("RESSS ARE RESULTS " + results);
		results.next();
		user = new User(results.getInt(1), results.getString(2),"", "", "");
		System.out.println("THE U " + user);
		conn.close();
		return user;
	}
	
//	public User getUser(int id) {
//		System.out.println("TROOPER DAO LOOKING FOR A # " + id);
//		Connection conn = getConnection();
//		System.out.println("2nd conn log, in getUser method" + conn);
//		User user = null;
//		try {
//			PreparedStatement stmt = conn.prepareStatement(
//					 "select * from users where id=?"
//					);
//			stmt.setInt(1, id);
//			ResultSet results = stmt.executeQuery();
//			System.out.println("Null or column name, interesting?? " + results);
//			results.next();
////			user = new User(results.getInt(1), results.getString(null), results.getString("lname"), "", "");
//			user = new User(results.getInt(1),results.getString("fname"),"","","");
//			System.out.println( "OK HERES USER " +  user);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return user;
//	}

}