
package com.sonal.flashcardapp.resthandlers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.services.FcUserServiceI;

@Path("/flashcardapp")
public class UsersRestHandler {
	@Autowired
	FcUserServiceI userService;
	private static final Logger logger = LoggerFactory.getLogger(UsersRestHandler.class);
	
	
	//URL: http://localhost:8080/flashcardapp/webservices/flashcardapp/users
	@GET
	@Path("/users")
	@Produces("application/xml, application/json") 
	public List<FcUsers> getUsers() {
		List<FcUsers> usersList = new ArrayList<FcUsers>();
		usersList = userService.getUsersList();
		return usersList;
	}
}
