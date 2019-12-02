package myController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Time;
import beans.User;
import service.UserService;

public class TimeController {

	private UserService userService = new UserService();
	
	
	public void getTime(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("HERE " + req);
		
//		Time timeForThisRequest = new ObjectMapper().readValue(req.getInputStream(), Time.class);
//		System.out.println("UNDER HERE " + timeForThisRequest);
		resp.setContentType("application/json");
		
//		Time userForThisRequest = new ObjectMapper().readValue(req.getInputStream(), Time.class);
		
//		System.out.println("Input stream Time " + userForThisRequest.get);
		String monday = req.getParameter("monday");
		String tuesday = req.getParameter("tuesday");
		String wednesday = req.getParameter("wednesday");
		String thursday = req.getParameter("thursday");
		String friday = req.getParameter("friday");
		String saturday = req.getParameter("saturday");
		String sunday = req.getParameter("sunday");
		
		System.out.println("ALL " + req);
		System.out.println("DAYS "  + monday + tuesday + wednesday);
		
		
		HttpSession session = req.getSession();
		System.out.println("H session " + session.getAttribute("id"));
		System.out.println("Name session " + session.getAttribute("fname"));
		System.out.println("Session check " + session.getAttribute("id").toString());
		Time time = null;
		String user_id = session.getAttribute("id").toString();
		System.out.println("What is the day" + monday);
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				userService.newTime(user_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)));
		// headers
		
		resp.setStatus(201);
	}
	
	public void allTime(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException, SQLException {
		
		System.out.println("ALL time req " + req);
		resp.setContentType("application/json");
		HttpSession session = req.getSession();
		System.out.println("H session " + session.getAttribute("id"));
		System.out.println("Name session " + session.getAttribute("fname"));
		String user_id = session.getAttribute("id").toString();
		System.out.println("IS user id here??? " + user_id);
		// TODO Auto-generated method stub
		
		try {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(userService.timeByUser(user_id)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	private int getUser_id() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}
