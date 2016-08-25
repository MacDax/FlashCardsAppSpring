package com.sonal.flashcardapp.daotest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sonal.flashcardapp.daoI.FcUserDAO;
import com.sonal.flashcardapp.domain.FcDeck;
import com.sonal.flashcardapp.domain.FcUsers;


@ContextConfiguration("classpath:orderdao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FcUsersDAOImpleTest {
	@Autowired
	@Qualifier("FcUserDaoJdbcImpl")
	private FcUserDAO fcuserDao;
	
	//Check insertUser() method can correctly insert new user.
	@Test
	public void testInsertUser() throws SQLException {
		FcUsers testUser = new FcUsers("Kellu", "Babu");
		testUser.setEmail("mmmm@babu.com");
		fcuserDao.insertUser(testUser);
		System.out.println("Test Insert user id : " + testUser.getUserid());
	}
	
	//Check findUserById() method can return a located user:
	@Test
	public void testFindUserById() {
		FcUsers user = fcuserDao.findUserById(17);
		System.out.println("found user : " + user.getFname());
	}
	
}
