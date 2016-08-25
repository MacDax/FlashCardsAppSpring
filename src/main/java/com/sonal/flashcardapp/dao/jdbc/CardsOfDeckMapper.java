package com.sonal.flashcardapp.dao.jdbc;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;



public class CardsOfDeckMapper implements RowMapper <FcUsers>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CardsOfDeckMapper.class);
	
	@Override
	public FcUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
		//int cardid;
		int deckid, uid;
		String deckTitle;
		//String question, answer;
		String fcuserfName, fcuserLname, fcuserEmail;
		//List<FcCard> cardList = new ArrayList<FcCard>();
		FcDeck deck;
		//FcCard card;
		List<FcDeck> deckList = new ArrayList<FcDeck>();
		FcUsers fcUser;
				
		//cardid = rs.getInt("cardid");
		deckid = rs.getInt("deckid");
		deckTitle = rs.getString("title");
		//question = rs.getString("question");
		//answer = rs.getString("answer");
		fcuserfName = rs.getString("fname");
		fcuserLname = rs.getString("lname");
		fcuserEmail = rs.getString("email");
		uid = rs.getInt("userid");
		logger.info("uid : " + uid);
		//card = new FcCard(question, answer, deckid);
		//card.setCardId(cardid);
		//cardList.add(card);
		deck = new FcDeck(deckTitle);
		deck.setDeckid(deckid);
		deckList.add(deck);
		//deck.setCard(cardList);
		fcUser = new FcUsers(fcuserfName, fcuserLname);
		fcUser.setUserid(uid);
		fcUser.setEmail(fcuserLname);
		fcUser.setDlist(deckList);
		return fcUser;
	}

}
