package com.sonal.flashcardapp.daoI;

import java.util.List;

import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;


public interface FcCardDAO {
		public int getCardsCount();
		public List<FcCard> findAllCards();
		public List<FcCard> findCardOfDeck(int deckId);
		//public List<FcCard> findCardsByDeck(FcDeck deckId);
		//public FcCard insertCard(FcCard newCard) throws DeckNotFoundException;
		public FcCard insertCard(FcCard newCard, int deckid) throws DeckNotFoundException;
		public FcCard updateCard(int cardid, FcCard updatedCard) throws CardNotFoundException;
		public int deleteCard(int cardid) throws CardNotFoundException;
}
