package br.com.youthquake.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.FriendsDTO;
import br.com.youthquake.model.Friends;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.FriendsService;

@RestController
public class FriendsREST {
	
	@Autowired
	private FriendsService friendService;
	
	@CrossOrigin
	@PostMapping(path = "/friends/include")
	public ResponseEntity<Response<Friends>> includeFriend(@Valid @RequestBody FriendsDTO friendsDto, BindingResult result) {

		Response<Friends> response = new Response<Friends>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Friends friendInclude = this.friendService.friendInclude(friendsDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(friendsDto.getIdFriends())
				.toUri();

		response.setData(friendInclude);
		return ResponseEntity.created(location).body(response);
	}
	
	@CrossOrigin
	@GetMapping("/friend")
	public ResponseEntity<Boolean> friend(@RequestBody FriendsDTO friend) {
		return ResponseEntity.ok().body(friendService.verifyFriends(friend));
	}
}
