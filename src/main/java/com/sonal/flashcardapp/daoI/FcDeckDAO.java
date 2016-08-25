 package com.sonal.flashcardapp.daoI;

import java.util.List;
import java.util.Map;

import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;



public interface FcDeckDAO {
	public int getDeckCount();
	//String findDeckTitle(String deckTitle);
	public List<FcDeck> listAllDecks();
	public List<FcDeck> findDeckByName(String deckTitle);
	public FcDeck insertDeck(FcDeck newDeck, int uid);
	public List<FcDeck> findDecksofUser(int userId);
	public int findTotalDecksofUser(int userId);
	public List<Map<String, FcDeck>> findCardsOfDeck();
	public int updateDeck(FcDeck updatedDeck, int deckid) throws DeckNotFoundException;
	public int deleteByTitle(String title, int uid) throws DeckNotFoundException;
	public int checkMaxCards(int deckId);
	public void updateOrRollBackMaxCards(int deckId);
	public void decreaseMaxCards(int deckId);
}
