package com.ecomvn.web.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecomvn.common.entity.Role;
import com.ecomvn.common.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll(){
		return (List<User>) repo.findAll();
	}
	
	public List<Role> allRoles() {
		return (List<Role>) roleRepo.findAll();
	}
	
	public void save(User user) {
		encodePassword(user);
		repo.save(user);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
	public boolean isEmailUnique(String email) {
		User user = null;
		try {
			user = repo.getUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if no user found with the email, then email is unique.
		return user == null;
	}
}
