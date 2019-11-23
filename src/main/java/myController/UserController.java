package myController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {

	private UserService userService = new UserService();

	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("PARAMS" + req);
		if (req.getParameter("id") != null) {
			try {
				resp.getWriter().println(new ObjectMapper()
						.writeValueAsString(userService.getUser(Integer.parseInt(req.getParameter("id")))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
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