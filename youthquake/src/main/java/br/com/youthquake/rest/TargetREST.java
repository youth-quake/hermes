package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.model.User;
import br.com.youthquake.service.TargetService;

@RestController
@RequestMapping("/target")
public class TargetREST {
	
	@Autowired
	private TargetService targetService;
	
	@CrossOrigin
	@DeleteMapping("/delete/{idTarget}")
	public ResponseEntity<String> deleteTarget(@PathVariable long idTarget){
		targetService.deleteTarget(idTarget);
		return ResponseEntity.ok().body("Deletado com sucesso!");
	}
	
	@CrossOrigin
	@PutMapping("/update/{idTarget}")
	public ResponseEntity<Target> updateTarget(@PathVariable long idTarget, @RequestBody TargetDTO dto){
		Target target = new Target();
		target = targetService.updateTarget(idTarget, dto);
		return ResponseEntity.ok().body(target);
	}
}
