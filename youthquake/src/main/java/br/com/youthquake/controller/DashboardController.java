package br.com.youthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

	@PostMapping("/Dashboard")
	public String viewDash() {
		return "DashboardView";
	}
}
