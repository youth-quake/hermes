package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.Questions;
import br.com.youthquake.model.User;
import br.com.youthquake.service.QuizService;

@RestController
public class QuizREST {
	
	@Autowired
	private QuizService service;
	
	@CrossOrigin
	@GetMapping("/questions/{idQuestion}")
	public ResponseEntity<Questions> getQuestion(@PathVariable long idQuestion){
		Questions question = null;
		question = service.getQuestionById(idQuestion);
		if(question != null) 
			return ResponseEntity.status(HttpStatus.OK).body(question);
		else
			return null;
	}
	
	@CrossOrigin
	@PutMapping("/quiz/newscore/{idUser}")
	public ResponseEntity<User> updateScore(@PathVariable long idUser, @RequestBody UserDTO dto){
		User user = new User();
		user = service.updateScore(idUser, dto);
		if(user != null) { 
			return ResponseEntity.ok().body(user);
		}
		return null;
	}
}
