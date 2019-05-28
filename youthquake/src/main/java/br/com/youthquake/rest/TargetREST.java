package br.com.youthquake.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.TargetService;

@RestController
public class TargetREST {
	@Autowired
	private TargetService targetService;
	
	@CrossOrigin
	@PostMapping(path = "/target/include")
	public ResponseEntity<Response<Target>> includeTarget(@Valid @RequestBody TargetDTO targetDto, BindingResult result) {

		Response<Target> response = new Response<Target>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Target targetInclude = this.targetService.targetInclude(targetDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(targetDto.getIdTarget())
				.toUri();

		response.setData(targetInclude);
		return ResponseEntity.created(location).body(response);
	}
	
	
	
	@CrossOrigin
	@DeleteMapping("/deleteTarget")
	public ResponseEntity<Void> deleteTarget(TargetDTO dto){
		targetService.deleteTarget(dto);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
