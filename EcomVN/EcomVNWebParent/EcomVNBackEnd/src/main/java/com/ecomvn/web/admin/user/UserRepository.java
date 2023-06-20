package com.ecomvn.web.admin.user;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomvn.common.entity.User_Detail;

@Repository
public interface UserRepository extends CrudRepository<User_Detail, Integer>{
	@Query("SELECT * FROM User WHERE email = :email;")
	public User_Detail getUserByEmail(@Param("email") String email);
}
