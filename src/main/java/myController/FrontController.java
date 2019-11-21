package myController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Dispatch received post from URI: " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/TimeStorm/api/login":
			//make log in controller and pass it the req and res. Can access db obj etc
			System.out.println("Login in route");
			resp.sendRedirect("/TimeStorm/test.html");
			break;
		default:
			break;
		}
	}
}
