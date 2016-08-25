package com.sonal.flashcardapp.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.flashcardapp.daoI.FcCardDAO;
import com.sonal.flashcardapp.domain.FcCard;
import com.sonal.flashcardapp.exceptions.CardNotFoundException;
import com.sonal.flashcardapp.exceptions.FcCardDaoException;




@Repository("FcCardDaoJdbcImpl")
@Transactional
public class FcCardDaoJdbcImpl implements FcCardDAO {
	@Autowired
	@Qualifier("dataSource")
private DataSource dataSource;
private JdbcTemplate jdbcTemplate;
private NamedParameterJdbcTemplate jdTemplate;
private SimpleJdbcInsert jdbcInsert;
private FcCardRowMapper cardMapper;

private static final Logger logger = LoggerFactory.getLogger(FcCardDaoJdbcImpl.class);

@PostConstruct
public void deckSetUp() {
	jdbcTemplate = new JdbcTemplate(dataSource);
	jdTemplate = new NamedParameterJdbcTemplate(dataSource);
	cardMapper = new FcCardRowMapper();
	jdbcInsert = new SimpleJdbcInsert(dataSource)
	                 .withTableName("cards")
	                 .usingGeneratedKeyColumns("cardid")
	                 .usingColumns("deckid", "question", "answer");
}

	@Override
	public int getCardsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FcCard> findAllCards() {
		String listCardSql = "SELECT * FROM cards order by cardid";
		List<FcCard> cardList = jdbcTemplate.query(listCardSql, cardMapper);
		int len = cardList.size();
		/*System.out.println("len : " + len);
		for(int i=0; i<len; i++) {
			System.out.println(cardList.get(i));
		}*/
		return cardList;
	}

	@Override
	public List<FcCard> findCardOfDeck(int deckId) {
		String listDeckSql = "SELECT * FROM cards where deckid = ?";
		return jdbcTemplate.query(listDeckSql, cardMapper, deckId);
	}

	

	private MapSqlParameterSource getCardParamMap(FcCard newCard) {
		MapSqlParameterSource params = new MapSqlParameterSource("cardid", newCard.getCardId());
		params.addValue("deckid", newCard.getCardId());
		params.addValue("question", newCard.getQuestion());
		params.addValue("answer", newCard.getAnswer());
		logger.info("new card params " + newCard.toString() + "  deck id " + newCard.getDeckid() +  "  card id : " + newCard.getCardId());
		return params;
	}
		
	
	/*@Override
	public FcCard insertCard(FcCard newCard)  {
		FcCard newCard = new FcCard(question, answer, cardid);
		MapSqlParameterSource params = getCardParamMap(newCard);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    newCard.setCardid(newId.intValue());
		
		//String sql = "INSERT into cards(question, answer, cardid) values(?,?,?)";
		logger.debug(newCard.toString());
		try {
		SqlParameterSource params = new BeanPropertySqlParameterSource(newCard);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		
		newCard.setCardId(newId.intValue());
		} catch(Exception ex) {
			logger.debug("error inserting a card " + ex.getMessage());
			throw new FcCardDaoException("Error inserting card.");
		}
		return newCard;  
		}*/
	
	@Override
	public FcCard insertCard(FcCard newCard, int deckid)  {
		newCard.setDeckid(deckid);
		MapSqlParameterSource params = getCardParamMap(newCard);
		newCard.setDeckid(deckid);
		SqlParameterSource sqlParams = new BeanPropertySqlParameterSource(newCard);
		logger.info("new card info " + newCard.toString() + "  deck id " + newCard.getDeckid());
	    Number newId = jdbcInsert.executeAndReturnKey(sqlParams);
	    newCard.setCardId(newId.intValue());
	    logger.info("new card info after insert " + newCard.toString() + "  deck id " + newCard.getDeckid() + "  card id : " + newCard.getCardId());
		return newCard;  
		}

	@Override
	public FcCard updateCard(int cardid, FcCard updatedCard) throws CardNotFoundException {
		String answer = updatedCard.getAnswer();
		String question = updatedCard.getQuestion();
		//int cardId = updatedCard.getCardId();
		logger.info("updatedCard " + updatedCard.toString() + "  " + cardid);
		String sql = "UPDATE cards SET question=:question, answer=:answer WHERE cardid = :cardid";
		
		logger.info("updatedCard " + updatedCard.toString() + "  " + cardid);
		MapSqlParameterSource sparams = getCardParamMap(updatedCard);
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(updatedCard);
		int rowsAffected = jdTemplate.update(sql, params);
		return updatedCard;
		}

	@Override
	public int deleteCard(int cid) throws CardNotFoundException {
		//int cid = card.getCardId();
		MapSqlParameterSource params;
		params = new MapSqlParameterSource("id", cid);
		
		logger.info("delete Card : " + cid);
		
		String sql = "DELETE from cards where cardid = :cid";
		int rowsAffected = jdTemplate.update(sql,params);
		return rowsAffected;
	}

}
