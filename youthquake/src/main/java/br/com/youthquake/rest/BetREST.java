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

import br.com.youthquake.dto.BetDTO;
import br.com.youthquake.model.Bet;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.BetService;

@RestController
public class BetREST {
	
	@Autowired 
	BetService betService;
	
	@CrossOrigin
	@PostMapping(path = "/bet/include")
	public ResponseEntity<Response<Bet>> includeBet(@Valid @RequestBody BetDTO betDto, BindingResult result) {

		Response<Bet> response = new Response<Bet>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Bet betInclude = this.betService.betInclude(betDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(betDto.getIdBet())
				.toUri();

		response.setData(betInclude);
		return ResponseEntity.created(location).body(response);
	}

}
