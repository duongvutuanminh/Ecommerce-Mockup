package com.ecomvn.common.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.UUIDGenerator;

import com.ecomvn.common.entity.idGenerator.UserIDGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User_Detail {
	@Id
	@GeneratedValue(generator = "custom-id")
	@GenericGenerator(name = "custom-id", strategy = "com.ecomvn.common.entity.idGenerator",
					parameters = {
							@Parameter(name = UserIDGenerator.INITIAL_PARAM, value = "1"),
							@Parameter(name = UserIDGenerator.INCREMENT_PARAM, value = "1"),
					})
	@Column(name = "id", columnDefinition = "varchar(20)", nullable = false, unique = true)
	private String Id;
	
	@Column(name = "email", nullable = false, unique = true, columnDefinition = "varchar(128)")
    private String email;
	
	@Column(name = "phone", nullable = false, columnDefinition = "varchar(15)")
	public String phoneNumber;
	
	@Column(name = "first_name", nullable = false, columnDefinition = "varchar(45)")
	private String firstName;

	@Column(name = "last_name", nullable = false, columnDefinition = "varchar(45)")
	private String lastName;
	
	@Column(name = "address", columnDefinition = "varchar(100)")
	private String address;
	
	@Column(length = 128, nullable = false)
    @Enumerated(EnumType.STRING)
    private Location location;

	@OneToOne
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Role role;
	
	@PostLoad
    private void setCustomIdWithRolePrefix() {
        UserIDGenerator generator = (UserIDGenerator) new UUIDGenerator();
        generator.setValuePrefix(role.getId());
    }

	public User_Detail() {}

	public User_Detail(String address, String email, String firstName, String lastName, Location location, String password,
			String phoneNumber, Role role) {
		super();
		this.address = address;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getId() {
		return Id;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getLocation() {
		return location.getValue();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setLocation(String location) {
		this.location = Location.setValue(location);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + Id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", roles=" + role + "]";
	}
}
