package com.ecomvn.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "user_login")
public class User_Login {
	@Id
	@OneToOne
    @JoinColumn(name = "id") // Maps the id column from User_Detail
    private User_Detail userIDDetail;
	
	@OneToOne
    @JoinColumn(name = "email") // Maps the email column from User_Detail
    private User_Detail userEmailDetail;
	
	@Column(name = "password", nullable = false, columnDefinition = "varchar(60)")
	private String password;
	
	public User_Login() {
		
	}
	
	public User_Login(String password) {
		this.password = password;
	}

	public User_Detail getUserIDDetail() {
		return userIDDetail;
	}

	public void setUserIDDetail(User_Detail userIDDetail) {
		this.userIDDetail = userIDDetail;
	}

	public User_Detail getUserEmailDetail() {
		return userEmailDetail;
	}

	public void setUserEmailDetail(User_Detail userEmailDetail) {
		this.userEmailDetail = userEmailDetail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
