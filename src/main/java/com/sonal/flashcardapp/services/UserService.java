package com.sonal.flashcardapp.services;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.flashcardapp.daoI.FcUserDAO;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.FcUserDaoException;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;


@Service
//@Transactional
public class UserService implements FcUserServiceI {
	@Autowired
	@Qualifier("FcUserDaoJdbcImpl")
	//@Qualifier("FcUserDaoMock")
	FcUserDAO fcuserdao;
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public FcUsers addNewUser(FcUsers newUser) {
		try {
			fcuserdao.insertUser(newUser);
		} catch (SQLException e) {
			throw new FcUserDaoException(e.getMessage());
		}
		return newUser;
	}

	@Override
	//public FcUsers loginUser(String email) {
	public FcUsers loginUser(FcUsers inUser) {
		FcUsers loggedInUser = null;
		
		try {
			//logger.info("email in loginUser : " + email());
			loggedInUser = fcuserdao.loginUser(inUser);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loggedInUser;
	}

	@Override
	public List<FcUsers> getUsersList() {
		List<FcUsers> usersList = fcuserdao.getUsersList();
		return usersList;
	}
}
