package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import beans.Time;
import beans.User;

import daoDataJDBC.Trooper;


public class UserService {

private Trooper user = new Trooper();
	//Service is for business logic
//	public User getUser(int id) throws SQLException {
//	
//		return user.getUser(id);
//	}
	
	public User log_user_in(String username, String password) throws SQLException {
		return user.getUserLoginInfo(username, password);

	}
	
	

	public String time(int i, int j, String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday, int k, int l) {
		
			
		return null;
	}

	public Time newTime(String user_id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
		System.out.println("User serice newTime log " + monday);
		return null;
	}

	public Object timeByUser(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		return user.timeByUser(user_id);
	}
}
