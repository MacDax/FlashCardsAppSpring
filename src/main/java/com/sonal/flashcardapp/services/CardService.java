package com.sonal.flashcardapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.flashcardapp.daoI.FcCardDAO;
import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional(readOnly=true)
@Service("cardService")
public class CardService implements FcCardServiceI {
	@Autowired
	FcDeckServiceI deckService;
	@Autowired
	FcCardDAO cardDao;
	
	public static final Logger logger = LoggerFactory.getLogger(CardService.class);
	/*@Override
	@Transactional(readOnly=false)
	public FcCard insertCard(FcCard newCard) throws DeckNotFoundException {
		FcCard tCard;
		int deckid = newCard.getDeckid();
		System.out.println(newCard.toString() + " " + deckid);
		tCard = cardDao.insertCard(newCard);
		deckService.updateOrRollbackMaxCards(deckid);
		return tCard;
		}*/

	@Override
	@Transactional(readOnly=false)
	public FcCard insertCard(FcCard newCard, int deckid) throws DeckNotFoundException {
		FcCard tCard;
		
		tCard = cardDao.insertCard(newCard, deckid);
		logger.info("newCard : " + newCard.toString() + "  " + deckid);
		
		deckService.updateOrRollbackMaxCards(deckid);
		
		return tCard;
		}
	
	@Override
	@Transactional(readOnly=false)
	public int deleteCard(int cardid) throws CardNotFoundException {
		int num;
		//int deckId = card.getDeckid();
		num=cardDao.deleteCard(cardid);
		//deckService.decreaseMaxCards(deckId);
		return num;
	}

	@Override
	@Transactional(readOnly=false)
	public FcCard updateCard(int cid, FcCard updatedCard) throws CardNotFoundException {
		FcCard card;
		logger.info("service updated card" + updatedCard.toString() + "  " + updatedCard.getCardId());
		card = cardDao.updateCard(cid, updatedCard);
		return card;
	}

	@Override
	public List<FcCard> listCards() {
		List<FcCard> cardList = new ArrayList<FcCard>();
		cardList = cardDao.findAllCards();
		return cardList;
	}

	@Override
	public List<FcCard> findCardOfDeck(int deckId) {
		List<FcCard> cardList = new ArrayList<FcCard>();
		cardList = cardDao.findCardOfDeck(deckId);
		return cardList;
	}

	@Override
	public int deleteCard(FcCard card) throws CardNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	

}
