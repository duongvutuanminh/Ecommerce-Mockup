package com.ecomvn.web.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecomvn.common.entity.Role;
import com.ecomvn.common.entity.User;

@Controller
public class UserController {

	@Autowired 
	private UserService userService;
	
	@GetMapping("/user")
	public String listAll(Model model) {
		List<User> listUser = userService.listAll();
		//coming from a database, cast into a list of user
		model.addAttribute("listUserInPage", listUser);
		return "user";
	}
	
	@GetMapping("/user/create") 
	public String createNewUser(Model model) {
		List<Role> listRole = userService.allRoles();
		model.addAttribute("allRoles", listRole);
		return "user_form";
	}
	
	@PostMapping("/user/save")
	public String saveUser(User user, RedirectAttributes redirectAttributes) {
		userService.save(user);
		redirectAttributes.addFlashAttribute("message", "User saved successfully");
		return "redirect:/user";
	}
}
