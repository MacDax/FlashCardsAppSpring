package com.sonal.flashcardapp.exceptions;

public class CardNotFoundException extends Exception {
	public CardNotFoundException(String msg) {
		super(msg);
		System.out.println("Card Not Found");
	}
}
