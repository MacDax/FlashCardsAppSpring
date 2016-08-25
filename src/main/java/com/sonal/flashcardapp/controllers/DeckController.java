package com.sonal.flashcardapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;











import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.services.*;

@Controller
public class DeckController {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	@Autowired
	FcDeckServiceI deckService;
	
	@RequestMapping(value="/deckForm", method=RequestMethod.GET)
	public ModelAndView createDeck(HttpSession session) {
		ModelAndView modelView;
		modelView = new ModelAndView("deckForm");
		FcUsers currentUser = (FcUsers) session.getAttribute("fcusers");
		modelView.addObject("fcdeck", new FcDeck());
		modelView.addObject("fcusers", currentUser);
		return modelView;
	}
	
	@RequestMapping(value="/deckForm", method=RequestMethod.POST)
	public ModelAndView insertDeck(@ModelAttribute("FcDeck") @Valid FcDeck fcdeck, BindingResult result, HttpSession session) {
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("deckForm");
			modelView.addObject("fcdeck", fcdeck);
			return modelView;
		}
			logger.info("fcdeck info : " + fcdeck.getTitle());	
			
		try{
			FcDeck currentDeck = (FcDeck) session.getAttribute("fcdeck");
			FcUsers currentUser = (FcUsers) session.getAttribute("fcusers");
			int uid = currentUser.getUserid();
			logger.info("fcusers info : " + uid);	
			FcDeck cd = deckService.insertDeck(fcdeck, uid);
			modelView = new ModelAndView("createCard");
			modelView.addObject(cd);
			session.setAttribute("fcdeck", cd);
			modelView.addObject("fccard", new FcCard());
			logger.info("created card view");
			return modelView;
		} catch(Exception ex){
			logger.info("error in deckform :" + ex.getMessage());
			modelView = new ModelAndView("createCard");
			modelView.addObject("fccard", new FcCard());
			return modelView;
		}
	}
	
	/*@RequestMapping(value="/usersdecks", method=RequestMethod.GET)
	public ModelAndView listDecks(int userid, HttpSession session) {
		ModelAndView modelView;
		List<FcDeck> deckList = new ArrayList<FcDeck>();
		deckList = deckService.getUsersDeckList(userid);
		modelView = new ModelAndView("usersDecks");
		session.setAttribute("decklist", deckList);
		modelView.addObject(deckList);
		return modelView;
	}*/
	
}
