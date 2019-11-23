package daoDataJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.chinook.beans.Artist;

import beans.User;
 
public class Trooper {
	

	public static Connection getConnection() {
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
	
	public User getUser(int id) {
		System.out.println("TROOPER DAO LOOKING FOR A # " + id);
		Connection conn = getConnection();
		System.out.println("2nd conn log, in getUser method" + conn);
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					 "select * from users where id=?"
					);
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			System.out.println("Null or column name, interesting?? " + results);
			results.next();
			user = new User(results.getInt(1), results.getString(null), results.getString("lname"), "", "");
			
			System.out.println( "OK HERES USER" +  user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return user;
	}
	
//	public User getUser(int i) {
//		Connection conn = getConnection();
//		User user = null;
//		try {
//			String sql = "select * from users where user_ID=?";
//			
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			new String[] {
//			ResultSet rs = stmt.executeQuery();
//			
//			
//			while(rs.next()) {
//				User user_sql = rs.getInt(i),
//						
//				results.add(ts);
//			} //end while
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return results;
//	}
//}
}