package com.youthquake.youthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youthquake.youthquake.infra.Seguranca;
import com.youthquake.youthquake.model.UsuarioModel;

@Controller
public class LoginUserController {


	private Seguranca seguranca;
	
	
	public LoginUserController(Seguranca seguranca) {
		this.seguranca = seguranca;
	}
	
	@PostMapping("/Login")
	public String loginUserRedirect(@ModelAttribute UsuarioModel user) {
		if(seguranca.acessUser(user)){
			return "DashboardView";
		}else{
			return "LoginView";
		}
	}
		
	@GetMapping("/Login")
	public String viewLogin(Model model) {
		model.addAttribute("user",new UsuarioModel());
		return "LoginView";
	}
}