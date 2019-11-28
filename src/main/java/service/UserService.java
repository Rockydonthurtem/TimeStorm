package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

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
		System.out.println("SERVICE " + username);
		return user.getUserLoginInfo(username, password);

	}
	
}
