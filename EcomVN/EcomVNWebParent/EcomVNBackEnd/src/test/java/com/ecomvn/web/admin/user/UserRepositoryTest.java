package com.ecomvn.web.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ecomvn.common.entity.Role;
import com.ecomvn.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired 
	private UserRepository repo;
	
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role role = entityManager.find(Role.class, 1);
		User userA= new User("Nguyen Van", "A", "nguyenvana98@gmail.com", "aaa888aaa");
		userA.addRole(role);
		User savedUser = repo.save(userA);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
}
