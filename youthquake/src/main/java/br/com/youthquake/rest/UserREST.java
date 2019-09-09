package br.com.youthquake.rest;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.User;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.UserService;

@RestController
public class UserREST {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping(path = "/user/include")
	public ResponseEntity<String> includeUser(@Valid @RequestBody UserDTO userDto, BindingResult result) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body("BAD REQUEST");
		}

		User userInclude = this.userService.userInclude(userDto);

		if (userInclude == null) {
			return ResponseEntity.ok().body("Login ou e-mail já existe");
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId())
				.toUri();

		response.setData(userInclude);
		return ResponseEntity.created(location).body("Usuário cadastrado com sucesso!");
	}

	@CrossOrigin
	@PostMapping(path = "/include/picture/{idUser}")
	public ResponseEntity<Response<User>> includePicture(@Valid @RequestBody UserDTO dto, @PathVariable long idUser,
			BindingResult result) {

		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		User userInclude = this.userService.pictureInclude(dto, idUser);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idUser).toUri();

		response.setData(userInclude);
		return ResponseEntity.created(location).body(response);
	}

	@CrossOrigin
	@PutMapping("/update/picture/{idUser}")
	public ResponseEntity<User> updatePicture(@PathVariable long idUser, @RequestBody UserDTO dto) {
		User user = new User();
		user = userService.updatePicture(idUser, dto);
		return ResponseEntity.ok().body(user);
	}

	@CrossOrigin
	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> getAllUserJSON() {
		List<User> users = null;
		users = userService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@CrossOrigin
	@GetMapping("/login/{login}/{password}")
	public ResponseEntity<User> login(@PathVariable String login, @PathVariable String password) {
		return ResponseEntity.ok().body(userService.verifyUser(login, password));
	}

	@CrossOrigin
	@GetMapping("/profile/{idUser}")
	public ResponseEntity<List<User>> getInformationById(@PathVariable long idUser) {
		List<User> user = null;
		user = userService.getUserInfo(idUser);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@CrossOrigin
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDTO dto) {
		User user = new User();
		user = userService.userUpdate(id, dto);
		return ResponseEntity.ok().body(user);
	}

	@CrossOrigin
	@PutMapping("user/updatestatus/{idUser}")
	public ResponseEntity<User> updateInfoUser(@PathVariable long idUser, @RequestBody UserDTO dto) {
		User user = null;
		user = userService.updateInfoUser(idUser, dto);
		return ResponseEntity.ok().body(user);
	}

	@CrossOrigin
	@DeleteMapping("/user/delete/{idUser}")
	public ResponseEntity<String> deleteMovement(@PathVariable long idUser) {
		userService.deleteUserById(idUser);
		return ResponseEntity.ok().body("Usuario deletado com sucesso!");
	}
}