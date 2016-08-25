package com.sonal.flashcardapp.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class FcDeck {
	@NotEmpty
	private String title;
	private boolean editable;
	private int deckid;
	private int userid;
	private int maxCards;
	private List<FcCard> card;
	
	public FcDeck() {}
	public FcDeck(String title, int userid) {
		this.userid = userid;
		this.title = title;
		card = new ArrayList<FcCard>();
		}
	
	public FcDeck(String deckTitle) {
		title = deckTitle;
	}

	public String getTitle() { return title; }
	public void setTitle(String ttl) {title = ttl;}
	public boolean getEditable() { return editable; }
	public void setEditable(boolean editField) { editable = editField; }
	public void setMaxCards(int maxCrd) { maxCards = maxCrd; }
	public int getMaxCards() { return maxCards; }
	public int getDeckid() { return deckid; }
	public void setDeckid(int did) { deckid = did; }
	public void setUserId(int uid) { userid = uid; }
	public int getUserId() { return userid; }
	public void setCard(List<FcCard> tempCard) { card = tempCard; }
	public List<FcCard> getCard() { return card; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userid + deckid;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FcDeck)) {
			return false;
		}
		FcDeck other = (FcDeck) obj;
		if (deckid != other.deckid) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
	
	

	public String toString() {
		
		return "Set Title : " + title;
	}
}
