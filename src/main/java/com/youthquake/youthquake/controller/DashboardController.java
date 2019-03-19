package com.youthquake.youthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youthquake.youthquake.model.UsuarioModel;

@Controller
public class DashboardController {

	@PostMapping("/Dashboard")
	public String viewDash() {
		return "DashboardView";
	}
}
