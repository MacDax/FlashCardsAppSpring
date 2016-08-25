package com.sonal.flashcardapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sonal.flashcardapp.domain.FcCard;


public class FcCardRowMapper implements RowMapper<FcCard> {
	String question, answer;
	int cid, did;
	FcCard newCard;
	
	@Override
	public FcCard mapRow(ResultSet resultSet, int rowCnt) throws SQLException {
		question = resultSet.getString("question");
		answer = resultSet.getString("answer");
		cid = resultSet.getInt("cardid");
		did = resultSet.getInt("deckid");
		newCard = new FcCard(question, answer, did);
		newCard.setCardId(cid);
		return newCard;
	}

}
