package br.com.youthquake.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.MovementsDTO;
import br.com.youthquake.model.Movements;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.MovementsService;

@RestController
public class MovementsREST {

	@Autowired
	private MovementsService movementsService;
	
	@CrossOrigin
	@PostMapping(path = "/movements/include")
	public ResponseEntity<Response<Movements>> includeMovement(@Valid @RequestBody MovementsDTO movementsDto, BindingResult result) {

		Response<Movements> response = new Response<Movements>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Movements movementsInclude = this.movementsService.movementInclude(movementsDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movementsDto.getIdMovement())
				.toUri();

		response.setData(movementsInclude);
		return ResponseEntity.created(location).body(response);
	}
	
}
