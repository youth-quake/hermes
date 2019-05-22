package br.com.youthquake.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.service.TargetService;

@RestController
public class TargetREST {
	
	private TargetService targetService;
	
	@CrossOrigin
	@DeleteMapping("/deleteTarget")
	public ResponseEntity<Void> deleteTarget(TargetDTO dto){
		targetService.deleteTarget(dto);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
