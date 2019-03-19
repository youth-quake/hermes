package com.youthquake.youthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroUserController {
	
	@RequestMapping("/Cadastro")
	public String Cadastro(){
		
		return "CadastrarView";
	}
}
