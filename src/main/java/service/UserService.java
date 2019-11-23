package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import beans.User;
import daoDataJDBC.Trooper;


public class UserService {

private Trooper user = new Trooper();
	//Service is for business logic
	public User getUser(int id) throws SQLException {
		System.out.println("lookin for i " + id);
		return user.getUser(id);
	}
	
}
