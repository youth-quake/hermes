package br.com.youthquake.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.MovementsDTO;
import br.com.youthquake.model.Movements;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.MovementsService;
import br.com.youthquake.service.UserService;

@RestController
@RequestMapping("/movements")
public class MovementsREST {

	@Autowired
	private MovementsService movementsService;

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping(path = "/include/{idUser}")
	public ResponseEntity<Response<Movements>> includeMovement(@Valid @PathVariable long idUser, @RequestBody MovementsDTO movementsDto,
			BindingResult result) {

		Response<Movements> response = new Response<Movements>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Movements movementsInclude = this.movementsService.movementInclude(idUser, movementsDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(movementsDto.getIdMovement()).toUri();

		response.setData(movementsInclude);
		return ResponseEntity.created(location).body(response);
	}
	
	
	@CrossOrigin
	@PostMapping(path = "/includeinitial/{idUser}")
	public ResponseEntity<Response<Movements>> includeMovementTotal(
			@Valid @PathVariable long idUser, @RequestBody MovementsDTO movementsDto,
			BindingResult result) {

		Response<Movements> response = new Response<Movements>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Movements movementsInclude = this.movementsService.movementInitialInclude(idUser, movementsDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(movementsDto.getIdMovement()).toUri();

		response.setData(movementsInclude);
		return ResponseEntity.created(location).body(response);
	}
	
	
	@CrossOrigin
	@DeleteMapping("/delete/{idMovement}")
	public ResponseEntity<String> deleteMovement(@PathVariable long idMovement) {
		movementsService.deleteMovementById(idMovement);
		return ResponseEntity.ok().body("movimentação deletada com sucesso!");
	}

	@CrossOrigin
	@GetMapping("/get/{idUser}")
	public ResponseEntity<List<Movements>> getInformationResponseEntity(@PathVariable long idUser) {
		List<Movements> movements = null;
		movements = movementsService.getMovementInfo(idUser);
		return ResponseEntity.status(HttpStatus.OK).body(movements);
	}
	
	@CrossOrigin
	@GetMapping("/microservice/{idUser}")
	public ResponseEntity<List<Movements>> microserviceMovements(@PathVariable long idUser) {
		List<Movements> movements = null;
		movements = movementsService.getMovementMicroservice(idUser);
		return ResponseEntity.status(HttpStatus.OK).body(movements);
	}
	
	@CrossOrigin
	@PutMapping("/update/{idMovement}/{idUser}")
	public ResponseEntity<Movements> updateMovement(@PathVariable long idMovement, @PathVariable long idUser,
													@RequestBody MovementsDTO dto) {
		Movements movements = new Movements();
		movements = movementsService.updateMovement(idMovement, idUser, dto);
		return ResponseEntity.ok().body(movements);
	}
}
