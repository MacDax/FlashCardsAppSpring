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

import com.sonal.flashcardapp.daoI.FcUserDAO;
import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;




@Repository("FcUserDaoJdbcImpl")
@Transactional
public class FcUserDaoJdbcImpl<FcDeck> implements FcUserDAO {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private FcUserRowMapper userRowMapper;
	private CardsOfDeckMapper usersdeckRowMapper;
	private static final Logger logger = LoggerFactory.getLogger(FcUserDaoJdbcImpl.class);
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		userRowMapper = new FcUserRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("susers")
		                 .usingGeneratedKeyColumns("userid")
		                 .usingColumns("fname", "lname", "email");
	}
	
	
	
	private MapSqlParameterSource getFcUsersParam(FcUsers user) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", user.getUserid());
		String fname = user.getFname();
		String lname = user.getLname();
		String email = user.getEmail();
		params.addValue("fname", fname);
		params.addValue("lname", lname);
		params.addValue("email", email);
		return params;
	}
	
	@Override
	public FcUsers insertUser(FcUsers newUser) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(newUser);
		//MapSqlParameterSource params = getFcUsersParam(newUser);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		newUser.setUserid(newId.intValue());
		return newUser;
		}

	@Override
	public FcUsers findUserById(int userId) {
		String sql = "SELECT * FROM susers WHERE userid = :userId";
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		FcUsers matchingUser = dbTemplate.queryForObject(sql, params, userRowMapper);
		return matchingUser;
	}



	@Override
	public int getUsersCount() {
		String sql = "SELECT count(*) from susers";
		return jdbcTemplate.queryForInt(sql);
		}



	@Override
	//public FcUsers loginUser(String email) throws UserNotFoundException {
	public FcUsers loginUser(FcUsers inUser) throws UserNotFoundException {
		FcUsers loggedInUser;
		String inEmail = inUser.getEmail();
		String sql = "SELECT * FROM susers where email = :email";
		MapSqlParameterSource params = new MapSqlParameterSource("email", inEmail);
		logger.info("inEmail : " + inEmail);
		loggedInUser = dbTemplate.queryForObject(sql, params, userRowMapper);
		return loggedInUser;
	}



	@Override
	public List<FcUsers> getUsersList() {
		List<FcUsers> usersList;
		String sql = "SELECT * FROM susers order by userid";
		usersList = jdbcTemplate.query(sql,userRowMapper);
		logger.info("userlist sql : " + sql + "list size : " + usersList.size());
		return usersList;
	}

	/*@Override
	public List<FcDeck> findDecksofUser(int userId) {
		String sql = "SELECT * FROM FcDeck where userid = :userId";
		List<FcDeck> deckList = jdbcTemplate.query(sql, deckRowMapper);
		return deckList;
		
		//return null;
	}*/

//	@Override
//	public int findTotalDecksofUser(int userId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
