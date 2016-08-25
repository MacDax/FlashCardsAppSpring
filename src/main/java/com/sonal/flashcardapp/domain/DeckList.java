package com.sonal.flashcardapp.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@XmlRootElement
public class DeckList implements Serializable {
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(DeckList.class);
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="deck")
	
	private List<FcDeck> dkList;
	
	public DeckList() { }
	
	public List getDkList() {
		return dkList;
	}
	
	public void setDkList(List<FcDeck> newDeckList) {
		//logger.debug("deckList size in DECKLIST : " + newDeckList.size());
		this.dkList = newDeckList;
		//logger.debug("deckList size in DECKLIST : " + deckList.size());
	}
	
	public int numEntries() {
		if(dkList == null) return 0;
		return dkList.size();
	}
	
	public FcDeck getDeck(int idx) {
		return dkList.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "DeckList{";
		for (FcDeck entry: dkList) {
			listStr = listStr + "\n\t" + entry;
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
}
