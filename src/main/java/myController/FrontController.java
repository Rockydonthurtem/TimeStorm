package myController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	
	private UserController userController = new UserController();
	
	//first do doGet and then pass it to doDispatch
	//Could you/ why not do dispatch in each "do" method.. You would have to have a parent class or the method to handle it for each request, 
	//that's why one "centeral dispatcher" is logical "DRY".
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	//Dispatcher does exactly what the name implies, it Dispatches to location you provide in the 
	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		//this is reading the URI log it to see whats coming in, may have to change somethings due to Axios
		System.out.println("OK THIS doDispatch:" + uri);
		switch (uri) {
		case "/TimeStorm/api/id":
			if (req.getMethod().equals("POST")) {
				try {
					try {
						userController.getUser(req, resp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			 if (req.getMethod().equals("GET")) {
				userController.postUser(req,resp);
				return;
			}
		default:
			break;
		}
	}
//			@Override
//			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//				doDispatch(req, resp);
//			}
			
			@Override
			public void init() throws ServletException {
				System.out.println("Front Controller Initialized!");
			}
}