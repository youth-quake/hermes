package br.com.youthquake.repository;

import static junit.framework.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.youthquake.model.User;
import junit.framework.Assert;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserPersistenceTest {

	@Autowired
	private UserRepository allUsers;
	private User user;

	@Before
	public void setup() {
		user = new User("Thiago", "123", "pazthiagolima@gmail.com");
		allUsers.save(user);
	}

	@Test
	public void userPersistence() {
		User userPersist = allUsers.getOne(user.getIdUser());
		assertEquals(user, userPersist);
	}
	
	@Test
	public void findLoginAndPassword() {
		user = allUsers.findFirstByLoginAndPassword("Thiago", "123");
	}
}
