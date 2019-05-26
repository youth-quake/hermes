package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.service.TargetService;

@RestController
public class TargetREST {
	
	@Autowired
	private TargetService targetService;
	
	@CrossOrigin
	@DeleteMapping("/deleteTarget/{idTarget}")
	public ResponseEntity<String> deleteTarget(@PathVariable long idTarget){
		targetService.deleteTarget(idTarget);
		return ResponseEntity.ok().body("Deletado com sucesso!");
	}
}
