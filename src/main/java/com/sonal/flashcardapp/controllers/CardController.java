package com.sonal.flashcardapp.controllers;

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
import com.sonal.flashcardapp.services.FcCardServiceI;

@Controller
public class CardController {
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	@Autowired
	FcCardServiceI cardService;
	
	@RequestMapping(value="/createcard", method=RequestMethod.GET)
	public ModelAndView createCard(HttpSession session) {
		ModelAndView modelView;
		
		modelView = new ModelAndView("createCard");
		
		FcUsers currentUser = (FcUsers) session.getAttribute("fcusers");
		FcDeck currentDeck = (FcDeck) session.getAttribute("fcdeck");
		
		modelView.addObject("fccard", new FcCard());
		modelView.addObject("fcdeck", currentDeck);
		modelView.addObject("fcusers", currentUser);
		return modelView;
	}
	
	@RequestMapping(value="/createcard", method=RequestMethod.POST, params="createCard")
	public ModelAndView insertCard(@ModelAttribute("fccard") @Valid FcCard fccard, BindingResult result, HttpSession session) {
		ModelAndView modelView;
		/*FcUsers currentUser = (FcUsers) session.getAttribute("fcusers");
		FcDeck currentDeck = (FcDeck) session.getAttribute("fcdeck");
		logger.info("deck id " + currentDeck.getDeckid());
		int did = currentDeck.getDeckid();*/
		
		logger.info("fccard info : " + fccard.toString());	
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("createCard");
			modelView.addObject("fccard", fccard);
			logger.info("try create card errors : " + result.toString());
			return modelView;
		}
		
		try {
			logger.info("try create card : " + fccard.toString());
			FcUsers currentUser = (FcUsers) session.getAttribute("fcusers");
			FcDeck currentDeck = (FcDeck) session.getAttribute("fcdeck");
			int did = currentDeck.getDeckid();
			FcCard newCard = cardService.insertCard(fccard, did);
			
			session.setAttribute("fccard", newCard);
			session.setAttribute("fcusers", currentUser);
			session.setAttribute("fcdeck", currentDeck);
			
			modelView = new ModelAndView("cardSuccess");
			modelView.addObject("fccard", newCard);
			modelView.addObject("fcdeck", currentDeck);
			modelView.addObject("fcusers", currentUser);
			return modelView; 
		}catch(Exception ex){
			modelView = new ModelAndView("createCard");
			logger.info("Ex : " + ex.getMessage());
			return modelView;
		}
	}
}
