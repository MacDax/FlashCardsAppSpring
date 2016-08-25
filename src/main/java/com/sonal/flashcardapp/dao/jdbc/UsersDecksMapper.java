package com.sonal.flashcardapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sonal.flashcardapp.domain.FcUsers;

public class UsersDecksMapper implements RowMapper<FcUsers> {

	@Override
	public FcUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
		String username;
		int totalCards;
		
		username = rs.getString("fname");
		totalCards = rs.getInt("decksno");
		
		return null;
	}

}
