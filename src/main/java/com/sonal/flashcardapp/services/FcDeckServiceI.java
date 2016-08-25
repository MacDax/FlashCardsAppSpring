package com.sonal.flashcardapp.services;

import java.util.List;
import java.util.Map;

import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;

public interface FcDeckServiceI {
	public int checkMaxCards(int deckId);
	public void updateOrRollbackMaxCards(int deckId);
	public void decreaseMaxCards(int deckId);
	public List<FcDeck> getDeckList();
	public List<FcDeck> getUsersDeckCards();
	public FcDeck insertDeck(FcDeck newDeck, int uid);
	public List<FcDeck> getUsersDeckList(int userid);
	public int usersDeckCount(int userid);
	public List<Map<String, FcDeck>> findCardsOfDeck();
	public int updateDeck(FcDeck updatedDeck, int deckid);
}
