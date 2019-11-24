package myController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

public class UserController {

	private UserService userService = new UserService();

	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		resp.setContentType("application/json");
		System.out.println("PARAMS" + req.getParameter("id"));
		if (req.getParameter("username") !=null && req.getParameter("password") != null) {
			try {
//				resp.getWriter().println(new ObjectMapper()
//						.writeValueAsString(userService.getUser(Integer.parseInt(req.get("id")))));
				
						User user_login = userService.log_user_in(req.getParameter("username"), req.getParameter("password"));
						resp.getWriter().println(new ObjectMapper().writeValueAsString(user_login));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("try something else");
			resp.sendError(401);
		}
	}
	
	public void postUser(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");

	}
} 