package daoDataJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import beans.Time;
import beans.User;
 
public class Trooper {
	

	public Connection getConnection() {
		// return a connection here
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/storm_trooper", "root", "root");
	
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User getUserLoginInfo(String username, String password) throws SQLException {
		User user = null;
	
		Connection conn = getConnection();
		 //why do we do this?? this i innitializing user to null, will use this after query to set values and update user 
		
		PreparedStatement stmt = conn.prepareStatement("select id, fname from users where username=? AND password=?");
		stmt.setString(1,username.toString());
		stmt.setString(2, password);
		ResultSet results = stmt.executeQuery();
		
		results.next();
		user = new User(results.getInt(1), results.getString(2),"", "", "");
		
		conn.close();
		return user;
	}
	
	@SuppressWarnings("null")
	public Time submitTime(String user_id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) throws SQLException {
		System.out.println("Sub time before conn " + user_id);
		Time user_time = null;
		String query = "insert into time (users_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)" + "values(?,?,?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user_id);
		stmt.setString(2, monday);
		stmt.setString(3, tuesday);
		stmt.setString(4, wednesday);
		stmt.setString(5, thursday);
		stmt.setString(6, friday);
		stmt.setString(7, saturday);
		stmt.setString(8, sunday);
		stmt.executeUpdate();
		ResultSet key = stmt.getGeneratedKeys();
		System.out.println("Sub time"+ key);
		key.next();
		user_time.getUsers_id(key.getInt(1));
		
		conn.close();
		return submitTime("users_id", monday, tuesday, wednesday, thursday, friday, saturday, sunday);
		
	}
	
	public Time timeByUser(String user_id) throws SQLException {
		System.out.println("Trooper change " + user_id);
		Time all_time = null;
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from time where users_id=?");
		stmt.setString(1, user_id);
		ResultSet results = stmt.executeQuery();
		
		all_time = new Time();
		while(results.next()) {
			all_time = new Time(
					results.getInt("users_id"), 
					results.getInt("monday"), 
					results.getInt("tuesday"), 
					results.getInt("wednesday"), 
					results.getInt("thursday"), 
					results.getInt("friday"), 
					results.getInt("saturday"), 
					results.getInt("sunday"), 
					results.getInt("total"), 
					results.getInt("status")
					);
					}
		conn.close();
		return all_time;
	}
}