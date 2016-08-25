package com.sonal.flashcardapp.resthandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sonal.flashcardapp.domain.*;
//import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;
import com.sonal.flashcardapp.services.FcDeckServiceI;

@Path("flashcardapp")
public class DeckRestHandler {
	@Autowired
	FcDeckServiceI deckService;
	
	private static final Logger logger = LoggerFactory.getLogger(DeckRestHandler.class);
	
	
	//URL :http://localhost:8080/flashcardapp/webservices/flashcardapp/decklist
	
	@GET
	@Path("/decklist")
	@Produces("application/xml, application/json") 
	public List<FcDeck> getDeckList() {
		List<FcDeck> deckLst; // = new ArrayList<FcDeck>();
		DeckList listOfDecks = new DeckList();
		
		deckLst = deckService.getDeckList();
		//logger.info("rest deck : " + deckLst.size());
		//listOfDecks.setDkList(deckLst);
		//return listOfDecks;
		return deckLst;
	}
	
	//URL :http://localhost:8080/flashcardapp/webservices/flashcardapp/usersdecks/1
	@GET
	@Path("/usersdecks/{userid}")
	@Produces("application/json")
	public List<FcDeck> getUsersDeckCards(@PathParam("userid") int uid) {
		List<FcDeck> usersdeck;
		usersdeck = deckService.getUsersDeckList(uid);
		return usersdeck;
	}
	
	//URL:  http://localhost:8080/flashcardapp/webservices/flashcardapp/createdeck/1
	@POST
	@Path("/createdeck/{userid}")
	@Produces("application/xml, application/json")
	@Consumes("application/xml, application/json") 
	public Response insertCard(FcDeck newDeck, @PathParam("userid") int uid) throws DeckNotFoundException {
		ResponseBuilder respBuilder;
			deckService.insertDeck(newDeck, uid);
			respBuilder = Response.status(Status.CREATED);
			respBuilder.entity(newDeck);
			return respBuilder.build();
			}
	
	//URL : http://localhost:8080/flashcardapp/webservices/flashcardapp/deckcount/1
	@GET
	@Path("/deckcount/{userid}")
	@Produces("application/xml, application/json")
	public int coundCard(@PathParam("userid") int uid) throws UserNotFoundException {
		ResponseBuilder respBuilder;
		int total = deckService.usersDeckCount(uid);
		return total;
	}
	
	
	//URL: http://localhost:8080/flashcardapp/webservices/flashcardapp/usersdata
	@GET
	@Path("/usersdata")
	@Produces("application/xml, application/json")
	public List<Map<String, FcDeck>> readData() {
		ResponseBuilder respBuilder;
		List<Map<String, FcDeck>> dataList;
		dataList = deckService.findCardsOfDeck();
		return dataList;
	}
	
	//URL: http://localhost:8080/flashcardapp/webservices/flashcardapp/updatedeck/2
	@PUT
	@Path("/updatedeck/{deckid}")
	@Consumes("application/xml, application/json")
	public Response updateDeck(FcDeck newDeck, @PathParam("id") int deckid) {
		ResponseBuilder respBuilder;
		int updatedDeck;
		updatedDeck = deckService.updateDeck(newDeck, deckid);
		if(updatedDeck == 0) {
			respBuilder = Response.status(Status.NOT_FOUND);
		}else {
			respBuilder = Response.status(Status.OK);
		}
		
		return respBuilder.build();
	}
}
