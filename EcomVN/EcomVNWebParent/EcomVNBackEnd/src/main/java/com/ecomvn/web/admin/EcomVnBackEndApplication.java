package com.ecomvn.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.ecomvn.common.entity", "com.ecomvn.web.admin.user"})
public class EcomVnBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomVnBackEndApplication.class, args);
	}

}
