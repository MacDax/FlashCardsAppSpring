package com.sonal.flashcardapp.daoI;

import java.sql.SQLException;
import java.util.List;

import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;



public interface FcUserDAO {
	public FcUsers insertUser(FcUsers newUser) throws SQLException;
	public FcUsers findUserById(int userId);
	public int getUsersCount();
	//public List<FcDeck> findDecksofUser(int userId);
	//public int findTotalDecksofUser(int userId);
	//public FcUsers loginUser(String email) throws UserNotFoundException;
	public FcUsers loginUser(FcUsers inUser) throws UserNotFoundException;
	public List<FcUsers> getUsersList();
}
