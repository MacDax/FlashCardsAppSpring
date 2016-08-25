package com.sonal.flashcardapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sonal.flashcardapp.domain.FcUsers;

public class FcUserRowMapper implements RowMapper<FcUsers> {

	@Override
	public FcUsers mapRow(ResultSet resultSet, int row) throws SQLException {
		String fname, lname, email;
		int userid;
		FcUsers user;
		
		lname = resultSet.getString("lname");
		fname = resultSet.getString("fname");
		userid = resultSet.getInt("userid");
		email = resultSet.getString("email");
		user = new FcUsers(fname, lname);
		user.setEmail(email);
		user.setUserid(userid);
		
		return user;
	}

}
