package com.ecomvn.web.admin.user;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecomvn.common.entity.Location;
import com.ecomvn.common.entity.Role;
import com.ecomvn.common.entity.User_Detail;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User_Detail> listAll(){
		return (List<User_Detail>) repo.findAll();
	}
	
	public List<Role> allRoles() {
		return (List<Role>) roleRepo.findAll();
	}
	
	public void save(User_Detail user) {
		encodePassword(user);
		repo.save(user);
	}
	
	User_Detail encodePassword(User_Detail user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		passwordEncoder.matches(user.getPassword(), encodedPassword);
		return user;
	}
	
	public boolean isEmailUnique(String email) {
		User_Detail user = null;
		try {
			user = repo.getUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if no user found with the email, then email is unique.
		return user == null;
	}
	
	public List<Location> allLocation() {
		Location[] locationsArray = Location.values();
		List<Location> locationList = new ArrayList<>(Arrays.asList(locationsArray));
		return locationList;
	}
}
