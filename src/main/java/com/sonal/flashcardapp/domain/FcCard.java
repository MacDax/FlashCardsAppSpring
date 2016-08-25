package com.sonal.flashcardapp.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class FcCard  {
	private int cardid;
	private int deckid;
	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	
	public FcCard() {}
	
	public FcCard(String q, String ans, int did){
		deckid = did;
		question = q;
		answer = ans;
	}
	
	public String getQuestion() { return question; }
	public String getAnswer() { return answer; }
	public void setQuestion(String quest) { question = quest; }
	public void setAnswer(String ans) { answer = ans; }
	public int getDeckid() { return deckid; }
	public void setDeckid(int did) { deckid = did; }
	public int getCardId() { return cardid; }
	public void setCardId(int l) { cardid = l; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardid;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		
		if(!(obj instanceof FcCard)) {
			return false;
		}
		
		FcCard other = (FcCard) obj;
		
		if(cardid == other.cardid) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Question : " + question + "   Ans : " + answer;
	}

}
