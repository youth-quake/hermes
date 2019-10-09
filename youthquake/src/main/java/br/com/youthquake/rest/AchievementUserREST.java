package br.com.youthquake.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.AchievementUserDTO;
import br.com.youthquake.model.AchievementUser;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.AchievementUserService;

@RestController
public class AchievementUserREST {
	@Autowired 
	AchievementUserService achievementUserService;
	
	@CrossOrigin
	@PostMapping(path = "/achievement/include/{idUser}")
	public ResponseEntity<Response<AchievementUser>> includeAchievementUser(@Valid @PathVariable long idUser, @RequestBody AchievementUserDTO achievementUserDTO, BindingResult result) {

		Response<AchievementUser> response = new Response<AchievementUser>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		AchievementUser achievementUserInclude = this.achievementUserService.achievementUserInclude(idUser, achievementUserDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(achievementUserDTO.getIdAchievementUser())
				.toUri();

		response.setData(achievementUserInclude);
		return ResponseEntity.created(location).body(response);
	}
}
