package com.sonal.flashcardapp.services;

import java.util.List;

import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;



public interface FcUserServiceI {
	public FcUsers addNewUser(FcUsers newUser);
	//public FcUsers loginUser(String email) throws UserNotFoundException;
	public FcUsers loginUser(FcUsers inUser) throws UserNotFoundException;
	public List<FcUsers> getUsersList();
}
