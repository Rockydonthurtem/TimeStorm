package myController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Time;
import service.UserService;

public class TimeController {

	private UserService userService = new UserService();

	public void getTime(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("application/json");
	}
}
