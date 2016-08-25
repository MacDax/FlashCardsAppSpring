package com.sonal.flashcardapp.services;

import java.util.List;
import java.util.Map;

import com.sonal.flashcardapp.domain.*;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;



public interface FcCardServiceI {
	//public FcCard insertCard(FcCard newCard) throws DeckNotFoundException;
	public FcCard insertCard(FcCard newCard, int did) throws DeckNotFoundException;
	public int deleteCard(FcCard card) throws CardNotFoundException;
	public FcCard updateCard(int cid, FcCard card) throws CardNotFoundException;
	public List<FcCard> listCards();
	public List<FcCard> findCardOfDeck(int deckId);
	public int deleteCard(int cardid) throws CardNotFoundException;
}
