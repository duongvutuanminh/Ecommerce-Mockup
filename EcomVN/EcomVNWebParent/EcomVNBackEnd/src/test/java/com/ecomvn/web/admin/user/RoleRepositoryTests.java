package com.ecomvn.web.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ecomvn.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

	@Autowired 
	private RoleRepository repo;
	
	@Test 
	public void testCreateAdminRole() {
		String description = "ADMIN can have access to...";
		String abberviation = "ADM";
		String name = "Admin";
		Role admin = new Role(abberviation, name, description);
		//assertion purpose
		Role savedRole = repo.save(admin);
		assertThat(savedRole.getId()).isEqualTo("ADM");
	}
	
	@Test
	public void testCreateVendorRole() {
		Role vendor = new Role("Vendor");
		Role savedRole = repo.save(vendor);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateUserRole() {
		Role user = new Role("User");
		Role savedRole = repo.save(user);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
}
