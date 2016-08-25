package com.sonal.flashcardapp.exceptions;

public class DeckNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeckNotFoundException(String msg) {
		super(msg);
		System.out.println("Deck not found");
	}
}
