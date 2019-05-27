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

import br.com.youthquake.dto.MovementsDTO;
import br.com.youthquake.model.Movements;
import br.com.youthquake.service.MovementsService;

@RestController
@RequestMapping("/movements")
public class MovementsREST {

	@Autowired
	private MovementsService movementsService;
	
	@CrossOrigin
	@DeleteMapping("/delete/{idMovement}")
	public ResponseEntity<String> deleteMovement(@PathVariable long idMovement){
		movementsService.deleteMovementById(idMovement);
		return ResponseEntity.ok().body("movimentação deletada com sucesso!");
	}
	
	
	@CrossOrigin
	@PutMapping("/update/{idMovement}")
	public ResponseEntity<Movements> updateMovement(@PathVariable long idMovement,
			@RequestBody MovementsDTO dto){
		Movements movements = new Movements();
		movements = movementsService.updateMovement(idMovement, dto);
		return ResponseEntity.ok().body(movements);
	}
}
