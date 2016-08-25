package com.sonal.flashcardapp.resthandlers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;
import com.sonal.flashcardapp.services.FcCardServiceI;

@Path("/flashcardapp")
public class CardsRestHandler {
	@Autowired
	FcCardServiceI cardService;
	private Logger logger = LoggerFactory.getLogger(CardsRestHandler.class);
	
	/*Test url
	 * http://localhost:8080/flashcardapp/webservices/flashcardapp/cardslist
	 */
	
	@GET
	@Path("/cardslist")
	@Produces("application/xml, application/json")
	public List<FcCard> getCardList() {
		List<FcCard> cardList = new ArrayList<FcCard>();
		cardList = cardService.listCards();
		return cardList;
	}
	
	
	/*Test url
	 * http://localhost:8080/flashcardapp/webservices/flashcardapp/deckcard/1
	 */
	
	@GET
	@Path("deckcard/{id}")
	@Produces("application/xml, application/json")
	public List<FcCard> getCardOfDeck(@PathParam("id") int id) {
		List<FcCard> deckCardList = new ArrayList<FcCard>();
		deckCardList = cardService.findCardOfDeck(id);
		return deckCardList;
	}
	
	
	/* Test Url -- Post the data from file card.json to:
	 * http://localhost:8080/flashcardapp/webservices/flashcardapp/createcard/1
	 * After doing the post, use a get command to retrieve the student (and verify that the post was successful).
	 */
	@POST
	@Path("createcard/{deckid}")
	@Produces("application/xml, application/json")
	@Consumes("application/xml, application/json") 
	public Response insertCard(FcCard newCard, @PathParam("deckid") int deckid) throws DeckNotFoundException {
		ResponseBuilder respBuilder;
			cardService.insertCard(newCard, deckid);
			respBuilder = Response.status(Status.CREATED);
			respBuilder.entity(newCard);
			return respBuilder.build();
			}
	
	/* Test Url -- Put (HTTP Put Command) the data from file card.json to:
	 * http://localhost:8080/flashcarapp/webservices/flashcardapp/updatecard/88
	 * After doing the post, use a get command to retrieve the student (and verify that the post was successful).
	 */
	@PUT
	@Path("updatecard/{crdid}")
	@Produces("application/xml, application/json")
	@Consumes("applicatin/xml, application/json")
	public Response updateCard(@PathParam("crdid") int cardid, FcCard updatedCard) throws CardNotFoundException {
		ResponseBuilder respBuilder;
		FcCard upCard;
		upCard = cardService.updateCard(cardid, updatedCard);
		
		if(upCard == null) {
			respBuilder = Response.status(Status.NOT_FOUND);
		}else {
		respBuilder = Response.status(Status.OK);
		respBuilder.entity(updatedCard);
		}
		return respBuilder.build();
	}
	
	//URL : http://localhost:8080/flashcardapp/webservices/flashcardapp/deletecard/1
	@DELETE
	@Path("deletecard/{crdid}")
	public Response deleteCard(@PathParam("crdid") int crdid) throws CardNotFoundException {
		ResponseBuilder respBuilder;
		int numRowsAffected;
		
		numRowsAffected = cardService.deleteCard(crdid);
		
		if(numRowsAffected == 0) {
			respBuilder = Response.status(Status.NOT_FOUND);
		}else {
			respBuilder = Response.status(Status.OK);
			respBuilder.entity(crdid);
		}
		return respBuilder.build();
	}
}
