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
		User user = null;
		resp.setContentType("application/json");

		User userForThisRequest = new ObjectMapper().readValue(req.getInputStream(), User.class);
		
		if(userForThisRequest.getPassword().isEmpty() != true && userForThisRequest.getUsername().isEmpty() != true) {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(
					user = userService.log_user_in(userForThisRequest.getUsername().toString(), userForThisRequest.getPassword())));
			// headers
			System.out.println("WRITER " + resp.getWriter());
			resp.setStatus(201);
		}
		
		System.out.println("USRCONTRL " + user);
		System.out.println("DFDFDFD " + req.getSession().getAttribute("id") );
		System.out.println("Looking for name " + req.getSession().getAttribute("fname") );
		
		req.getSession().setAttribute("id", user.getUser_id());
		System.out.println("USER 1 " + user);
		if (user != null) {
			System.out.println("USER 2 " + user);
			System.out.println("Second attribute " + req.getSession().getAttribute("fname"));
			req.getSession().setAttribute("id", user.getUser_id());
			req.getSession().setAttribute("fname", user.getFname());
			resp.sendRedirect("/TimeStorm/gettime.html");
		}
		
	}
		
		
//		if (new ObjectMapper().writeValueAsString(userForThisRequest) != null) {
//			System.out.println("INSIDE " + userForThisRequest.getUsername());
//			try {
//
//				
//						User user_login = userService.log_user_in(req.getParameter("username"), req.getParameter("password"));
//						resp.getWriter().println(new ObjectMapper().writeValueAsString(user_login));
//			} catch (NumberFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("try something else");
//			resp.sendError(401);
//		}
//	}
	
	public void postUser(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");

	}
} 