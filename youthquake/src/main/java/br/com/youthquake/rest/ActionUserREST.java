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

import br.com.youthquake.dto.ActionUserDTO;
import br.com.youthquake.model.ActionUser;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.ActionUserService;

@RestController
public class ActionUserREST {
	@Autowired 
	ActionUserService actionUserService;
	
	@CrossOrigin
	@PostMapping(path = "/action/include")
	public ResponseEntity<Response<ActionUser>> includeActionUser(@Valid @RequestBody ActionUserDTO actionUserDTO, BindingResult result) {

		Response<ActionUser> response = new Response<ActionUser>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		ActionUser actionUserInclude = this.actionUserService.actionUserInclude(actionUserDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actionUserDTO.getIdActionUser())
				.toUri();

		response.setData(actionUserInclude);
		return ResponseEntity.created(location).body(response);
	}
}
