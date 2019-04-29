package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.service.UserService;

@Controller
public class LoginUserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/Login")
	public ResponseEntity<Boolean> login(@RequestBody UserDTO user){
		return ResponseEntity.ok().body(userService.verifyUser(user));
	}
}
