package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.service.UserService;

@RestController
public class LoginUserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@GetMapping("/login")
	public ResponseEntity<Boolean> login(UserDTO user){
		return ResponseEntity.ok().body(userService.verifyUser(user));
	}
}
