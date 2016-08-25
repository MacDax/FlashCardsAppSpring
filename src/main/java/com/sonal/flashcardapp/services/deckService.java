package com.sonal.flashcardapp.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.flashcardapp.daoI.FcDeckDAO;
import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;



@Transactional(readOnly=true)
@Service("deckService")
public class deckService implements FcDeckServiceI {
	@Autowired
	private FcDeckDAO deckDao;
	
	private static final Logger logger = LoggerFactory.getLogger(deckService.class); 
	
	@Override
	public int checkMaxCards(int deckId) {
		int maxCrds = 0;
		maxCrds = deckDao.checkMaxCards(deckId);
		return maxCrds;
			}

	@Override
	@Transactional(readOnly=false)
	public void updateOrRollbackMaxCards(int deckId) {
		deckDao.updateOrRollBackMaxCards(deckId);
		logger.info("updated maxcards " + checkMaxCards(deckId));
	}

	@Override
	@Transactional(readOnly=false)
	public void decreaseMaxCards(int deckId) {
		deckDao.decreaseMaxCards(deckId);
		logger.info("decreased maxcards " + checkMaxCards(deckId));
	}

	@Override
	@Transactional(readOnly=true)
	public List<FcDeck> getDeckList() {
		List<FcDeck> newDeckList = new ArrayList<FcDeck>();
		newDeckList = deckDao.listAllDecks();
		logger.info("decklist size : " + newDeckList.size());
		return newDeckList;
	}

	@Override
	@Transactional(readOnly=true)
	public List<FcDeck> getUsersDeckCards() {
		List<FcDeck> usersDeckCards;
		/*usersDeckCards = deckDao.findCardsOfDeck();
		return usersDeckCards;*/
		return null;
	}

	/*@Override
	@Transactional(readOnly=false)
	public FcDeck insertDeck(FcDeck newDeck) {
		FcDeck insertedDeck = deckDao.insertDeck(newDeck);
		return insertedDeck;
	}*/

	@Override
	@Transactional(readOnly=false)
	public FcDeck insertDeck(FcDeck newDeck, int uid) {
		logger.info("deck service uid : " + uid );
		FcDeck insertedDeck = deckDao.insertDeck(newDeck, uid);
		return insertedDeck;
	}

	@Override
	@Transactional(readOnly=true)
	public List<FcDeck> getUsersDeckList(int userid) {
		List<FcDeck> usersDecks = new ArrayList<FcDeck>();
		usersDecks = deckDao.findDecksofUser(userid);
		return usersDecks;
	}

	@Override
	public int usersDeckCount(int userid) {
		int total = deckDao.findTotalDecksofUser(userid);
		return total;
	}

	@Override
	public List<Map<String, FcDeck>> findCardsOfDeck() {
		List<Map<String, FcDeck>> usersData;
		usersData = deckDao.findCardsOfDeck();
		return usersData;
	}

	@Override
	@Transactional(readOnly=false)
	public int updateDeck(FcDeck updatedDeck, int deckid) {
		int updated = 0;
		try {
			updated = deckDao.updateDeck(updatedDeck,deckid);
		} catch (DeckNotFoundException e) {
			logger.debug(e.getMessage());
			//e.printStackTrace();
		}
		return updated;
	}

}
