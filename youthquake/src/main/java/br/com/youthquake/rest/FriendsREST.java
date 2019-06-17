package br.com.youthquake.rest;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.FriendsDTO;
import br.com.youthquake.model.Friends;
import br.com.youthquake.model.User;
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
	@GetMapping("/friend/search/{nameFriend}")
	public ResponseEntity<List<User>> searchFriend(@PathVariable String nameFriend){
		List<User> user = null;
		user = friendService.searchFriends(nameFriend);
		return ResponseEntity.ok().body(user);
	}
	
	@CrossOrigin
	@GetMapping("/friend/{idUser}")
	public ResponseEntity<List<Friends>> friend(@PathVariable long idUser) {
		List<Friends> f = null;
		f = friendService.verifyFriends(idUser);
		return ResponseEntity.ok().body(f);
	}
	
	@CrossOrigin
	@DeleteMapping("/friend/delete/{idFriends}")
	public ResponseEntity<String> removeFriend(@PathVariable long idFriends){
		friendService.deleteFriends(idFriends);
		return ResponseEntity.ok().body("Deletado com sucesso!");
	}
}
