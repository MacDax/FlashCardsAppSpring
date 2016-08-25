package com.sonal.flashcardapp.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String msg) {
		super(msg);
		System.out.println("User not found");
	}
}
