package myController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Time;
import service.UserService;

public class TimeController {

	private UserService userService = new UserService();

	public void getTime(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("HERE " + req);
		resp.setContentType("application/json");
		
		Time timeDays = new ObjectMapper().readValue(req.getInputStream(), Time.class);
		
	}
}
