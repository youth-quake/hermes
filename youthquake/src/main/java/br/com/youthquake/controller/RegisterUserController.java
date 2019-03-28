package br.com.youthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterUserController {

	@RequestMapping("/Cadastro")
	public String Cadastro(){
		
		return "CadastrarView";
	}
}
