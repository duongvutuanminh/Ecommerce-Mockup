package com.ecomvn.web.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		//Retrieving role from the database 
		Role role = entityManager.find(Role.class, 1);
		User userA= new User("Nguyen Van", "A", "nguyenvana98@gmail.com", "aaa888aaa");
		userA.addRole(role);
		User savedUser = repo.save(userA);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreate2ndUser() {
		//Create role with correct id 
		//This id correspond to the id in the table
		//this person is a vendor 
		Role role = new Role(2);
		User userB= new User("Nguyen Van", "B", "nguyenvanb99@gmail.com", "bbb666bbb");
		userB.addRole(role);
		User savedUser = repo.save(userB);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateUserWith2Roles() {
		//Create role with correct id 
		//This id correspond to the id in the table
		//this person is a vendor 
		Role role = new Role(2);
		Role role1 = new Role(1);
		User userB= new User("Ruvi", "Oshan", "oshanruvi01@gmail.com", "oshanNow");
		userB.addRole(role);
		userB.addRole(role1);
		User savedUser = repo.save(userB);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test 
	public void testListAllUser() {
		List<String> userInfo = new ArrayList<String>();
		Iterable<User> listUser = repo.findAll();
		listUser.forEach(user -> userInfo.add(user.toString()));
		for (String user : userInfo) {
		    System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserByID() {
		User user = repo.findById(1).orElse(null);
	    if (user != null) {
	        System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
	        System.out.println("Email: " + user.getEmail());
	        System.out.println("Roles:");
	        for (Role role : user.getRoles()) {
	            System.out.println("- " + role.getName());
	        }
	    }
	}
}
