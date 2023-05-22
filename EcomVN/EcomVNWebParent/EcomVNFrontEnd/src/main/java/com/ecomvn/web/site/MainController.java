package com.ecomvn.web.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String helloSite() {
		return "ecomsite";
	}

}
