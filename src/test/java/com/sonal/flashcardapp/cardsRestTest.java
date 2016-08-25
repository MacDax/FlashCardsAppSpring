package com.sonal.flashcardapp;

import org.junit.Before;

import com.sonal.flashcardapp.domain.FcCard;

public class cardsRestTest {
	private static String CARD_SERVICES_URL = "http://localhost:8080/flashcardapp/webservices/flashcardapp";
	private static FcCard testCard, updatedCard;
	private String question, answer, newAnswer, newQuestion;
	private int deckid, updatedCardId;
	
	@Before
	public void setUp() {
		question = "What is test data seven?";
		answer = "This is test data";
		deckid = 49;
		testCard = new FcCard(question, answer, deckid);
		
		updatedCardId = 83;
		newAnswer = "This is new answer";
		newQuestion = "What is new question?";
		updatedCard = new FcCard(newQuestion, newAnswer, deckid);
		updatedCard.setCardId(updatedCardId);
	}
	
	
}
