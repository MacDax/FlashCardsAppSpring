package com.sonal.flashcardapp.daotest;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sonal.flashcardapp.daoI.FcDeckDAO;
import com.sonal.flashcardapp.domain.FcDeck;


@ContextConfiguration("classpath:orderdao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FcDeckDAOImplTest {
	@Autowired
	@Qualifier("FcDeckDaoJdbcImpl")
	private FcDeckDAO fcDeckDao;
	private String title;
	private int uid;
	private boolean editable;
	
	//This setup is test data:
	@Before
	public void setUp() {
		 title = "Test Deck Title";
		 uid = 17;
		 editable = true;
	}
	
	//Check the method findDeckofUser() returns decks of a given user id:
	@Test
	public void testFindDecksofUser() {
		List<FcDeck> deckList = new ArrayList<FcDeck>();
		deckList = fcDeckDao.findDecksofUser(2);
		int len = deckList.size();
		for(int i=0; i<len; i++) {
			System.out.println(deckList.get(i));
		}
	}
	
	//Check listAllDecks() method returns all available decks in the deck table:
	@Test 
	public void testListAllDecks() {
		List<FcDeck> allDecks = new ArrayList<FcDeck>();
		allDecks = fcDeckDao.listAllDecks();
		int len=allDecks.size();
		for(int i=0; i<len;i++){
			//System.out.println(allDecks.get(i));
		}
	}

	//Check insertDeck() inserts given deck data:
	@Test 
	public void testInsertDeck() {
		//FcDeck valid = fcDeckDao.insertDeck(title, uid, editable);
		//assert();
	}
	
	//Chcek method searches for the deck by given title string:
	@Test
	public void testFindDeckByTitle() {
		List<FcDeck> foundDeckList = new ArrayList<FcDeck>();
		//foundDeckList = fcDeckDao.findDeckByName(title);
		int len = foundDeckList.size();
		/*for(int i=0;i<len;i++) {
			System.out.println(foundDeckList.get(i));
		}*/
	}
	
	@Test
	public void testFindCardsOfDeck() {
		List<FcDeck> cardList = new ArrayList<FcDeck>();
		//cardList = fcDeckDao.findCardsOfDeck();
		
	}
}
