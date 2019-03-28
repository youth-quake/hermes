package br.com.youthquake.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.youthquake.infra.ApplicationSecurity;
import br.com.youthquake.model.User;


@Controller
public class LoginUserController {


	private ApplicationSecurity applicationSecurity;
	
	
	public LoginUserController(ApplicationSecurity applicationSecurity) {
		this.applicationSecurity = applicationSecurity;
	}
	
	@PostMapping("/Login")
	public String loginUserRedirect(@ModelAttribute User user) {
		if(applicationSecurity.verifyUser(user)){
			return "DashboardView";
		}else{
			return "LoginView";
		}
	}
		
	@GetMapping("/Login")
	public String viewLogin(Model model){
		model.addAttribute("user",new User());
		return "LoginView";
	}
}