package com.sonal.flashcardapp.dao.jdbc;

import java.util.List;






















import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonal.flashcardapp.daoI.FcDeckDAO;
import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.DeckNotFoundException;
import com.sonal.flashcardapp.exceptions.FcDeckDaoException;



@Repository("FcDeckDaoJdbcImpl")
@Transactional
public class FcDeckDaoJdbcImpl implements FcDeckDAO {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private FcDeckRowMapper deckMapper;
	private CardsOfDeckMapper dcardMapper;
	private UsersDecksMapper usersDeckMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(FcDeckDaoJdbcImpl.class);
	
	@PostConstruct
	public void deckSetUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		deckMapper = new FcDeckRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("deck")
		                 .usingGeneratedKeyColumns("deckid")
		                 .usingColumns("title", "userid", "editable", "maxcards");
		dcardMapper = new CardsOfDeckMapper();
		usersDeckMapper = new UsersDecksMapper();
	}

	@Override
	public int getDeckCount() {
		
		return 0;
	}

//	@Override
//	public String findDeckTitle(String deckTitle) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<FcDeck> listAllDecks() {
		String listDecksSql = "SELECT * FROM deck order by title";
		List<FcDeck> listDecks = jdbcTemplate.query(listDecksSql, deckMapper);
		return listDecks;
	}

	@Override
	public List<FcDeck> findDeckByName(String deckTitle) {
		String findDeckSql = "SELECT * FROM deck where title like = ?";
		List<FcDeck> foundDecks = jdbcTemplate.query(findDeckSql, deckMapper, "%"+deckTitle+"%");
		return foundDecks;
	}

	private MapSqlParameterSource getDeckParamMap(FcDeck newDeck) {
		MapSqlParameterSource params = new MapSqlParameterSource("deckid", newDeck.getDeckid());
		params.addValue("userid", newDeck.getUserId());
		params.addValue("title", newDeck.getTitle());
		params.addValue("editable", newDeck.getEditable());
		params.addValue("maxCards", newDeck.getMaxCards());
		
		logger.info("Params : " + newDeck.getUserId() + "     " + newDeck.getTitle() + "   " + newDeck.getDeckid());
		
		return params;
	}
	
	

	@Override
	public List<FcDeck> findDecksofUser(int userId) {
		String sql = "SELECT * FROM deck where userid=?";
		List<FcDeck> deckList = jdbcTemplate.query(sql, deckMapper, userId);
		return deckList;
	}

	@Override
	public int findTotalDecksofUser(int userId) {
		String deckSql = "SELECT count(*) FROM deck WHERE userid = ?";
		//MapSqlParameterSource params = new MapSqlParameterSource("userid", userId);
		int totalDeck = jdbcTemplate.queryForInt(deckSql, userId);
		return totalDeck;
	}

	@Override
	public List<Map<String, FcDeck>> findCardsOfDeck() {
		
		//String sql = "select d.deckid, d.userid, su.userid, su.fname, su.lname, su.email, c.cardid, d.title, c.question, c.answer from cards c, deck d, susers su where c.deckid = d.deckid and su.userid=d.userid";
		String sql = "select d.deckid, d.userid, su.userid, su.fname, su.lname, su.email, d.title from deck d, susers su where su.userid = d.userid";
		//String sql = "Select su.userid, su.fname, count(d.userid) as decksno from flashcardsdb.deck d, susers su where su.userid = d.userid group by userid";
		List<Map<String, FcDeck>> cardsList = (List<Map<String, FcDeck>>) jdbcTemplate.queryForMap(sql); //jdbcTemplate.query(sql, dcardMapper);
		//List<Map<FcUsers, FcDeck>> cardList = (List<Map<FcUsers, FcDeck>>) jdbcTemplate.queryForMap(sql, dcardMapper); //jdbcTemplate.query(sql, dcardMapper);
		
		return cardsList;
		
	}

	

	@Override
	public int deleteByTitle(String title, int uid) throws DeckNotFoundException {
		String sql = "DELETE from deck where title=? and userid=?";
		int rowsRemoved = jdbcTemplate.update(sql, title, uid);
		return rowsRemoved;
	}

	@Override
	public int checkMaxCards(int deckId) {
		String sql = "SELECT maxcards from deck where deckid=?";
		
		int maxCards = jdbcTemplate.queryForInt(sql, deckId);
		return maxCards;
	}

	@Override
	public void updateOrRollBackMaxCards(int deckId) {
		int maxCrds = checkMaxCards(deckId);
		MapSqlParameterSource pid;
		pid= new MapSqlParameterSource("deckId", deckId);
		logger.info("in update : " + deckId);
		if(maxCrds == 10 ) {
			throw new FcDeckDaoException("Cards limit reached. This deck already has 10 cards.");
		}
		
		String sql = "UPDATE deck SET maxcards = maxcards+1 where deckid = :deckId";
		int updated = dbTemplate.update(sql, pid);
		logger.info("in update : " + updated);
	}

	@Override
	public void decreaseMaxCards(int deckId) {
		
		int maxCrds = checkMaxCards(deckId);
		MapSqlParameterSource pid;
		pid= new MapSqlParameterSource("deckId", deckId);
		logger.info("decreasing deckId : " + deckId);
		if(maxCrds < 1 ) {
			throw new FcDeckDaoException("There are no cards left in this deck.");
		}
		
		String sql = "UPDATE deck SET maxcards = maxcards-1 where deckid = :deckId";
		int updated = dbTemplate.update(sql, pid);
		logger.info("decresed maxcard limit");
		
	}

	@Override
	public FcDeck insertDeck(FcDeck newDeck, int uid) throws FcDeckDaoException {
		newDeck.setUserId(uid);
		MapSqlParameterSource params = getDeckParamMap(newDeck);
		
		newDeck.setUserId(uid);
		Number newId = jdbcInsert.executeAndReturnKey(params);
	    newDeck.setDeckid(newId.intValue());
	   logger.info("new deck infor : " + newDeck.getTitle() + newDeck.getUserId());
	    return newDeck;
	}

	@Override
	public int updateDeck(FcDeck updatedDeck, int deckId) throws DeckNotFoundException {
		MapSqlParameterSource params = getDeckParamMap(updatedDeck);
		//int deckId = updatedDeck.getDeckid();
		MapSqlParameterSource pid;
		pid= new MapSqlParameterSource("deckId", deckId);
		String sql = "UPDATE deck SET title=:title where deckid = :deckid";
		logger.info("update sql " + deckId);
		int updated = dbTemplate.update(sql, params);
		logger.info("updated : " + updated);
		return updated;
	}
	
	

}
