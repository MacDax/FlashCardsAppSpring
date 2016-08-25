package com.sonal.flashcardapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sonal.flashcardapp.domain.FcDeck;



public class FcDeckRowMapper implements RowMapper<FcDeck> {

	@Override
	public FcDeck mapRow(ResultSet resultSet, int rowCnt) throws SQLException {
			String title;
			int deckid, userid, maxCards;
			boolean editable;
			FcDeck usersDeck;
			
			deckid = resultSet.getInt("deckid");
			userid = resultSet.getInt("userid");
			maxCards = resultSet.getInt("maxCards");
			title = resultSet.getString("title");
			editable = resultSet.getBoolean("editable");
			usersDeck = new FcDeck(title, userid);
			usersDeck.setDeckid(deckid);
			usersDeck.setMaxCards(maxCards);
			usersDeck.setEditable(editable);
			
			return usersDeck;
	}

}
