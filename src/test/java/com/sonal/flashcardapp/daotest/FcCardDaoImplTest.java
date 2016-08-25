package com.sonal.flashcardapp.daotest;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sonal.flashcardapp.dao.jdbc.FcCardDaoJdbcImpl;
import com.sonal.flashcardapp.daoI.FcCardDAO;
import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;

@ContextConfiguration("classpath:orderdao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FcCardDaoImplTest {
	@Autowired
	@Qualifier("FcCardDaoJdbcImpl")
	FcCardDAO fcCardDao;
	private String question;
	private String answer;
	private int deckid;
	FcCard testCard, updatedCard;
	private int updatedCardId;
	private String newAnswer;
	private String newQuestion;
	
	@Before
	public void setup() {
		question = "What is test data seven?";
		answer = "This is test data";
		deckid = 49;
		testCard = new FcCard(question, answer, deckid);
		
		updatedCardId = 83;
		newAnswer = "This is new answer";
		newQuestion = "What is new question?";
		updatedCard = new FcCard(newQuestion, newAnswer, deckid);
		updatedCard.setCardId(updatedCardId);
	}
	
	@Test
	public void testInsertCard() throws DeckNotFoundException {
		//fcCardDao.insertCard(testCard);
		}
	
	@Test
	public void testFinalAllCards() {
		List<FcCard> cardList = new ArrayList<FcCard>();
		cardList = fcCardDao.findAllCards();
		/*int len = cardList.size();
		System.out.println("len : " + len);
		for(int i=0; i<len; i++) {
			System.out.println(cardList.get(i));
		}*/
	}
	
	@Test
	public void testUpdateCard()  {
		try {
			fcCardDao.updateCard(deckid, updatedCard);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
