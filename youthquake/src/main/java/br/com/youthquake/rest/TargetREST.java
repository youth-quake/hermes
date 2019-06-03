package br.com.youthquake.rest;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.model.User;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.TargetService;

@RestController
@RequestMapping("/target")
public class TargetREST {
	@Autowired
	private TargetService targetService;

	@CrossOrigin
	@PostMapping(path = "/include")
	public ResponseEntity<Response<Target>> includeTarget(@Valid @RequestBody TargetDTO targetDto,
			BindingResult result) {

		Response<Target> response = new Response<Target>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Target targetInclude = this.targetService.targetInclude(targetDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(targetDto.getIdTarget()).toUri();

		response.setData(targetInclude);
		return ResponseEntity.created(location).body(response);
	}

	
	@CrossOrigin
	@DeleteMapping("/delete/{idTarget}")
	public ResponseEntity<String> deleteTarget(@PathVariable long idTarget) {
		targetService.deleteTarget(idTarget);
		return ResponseEntity.ok().body("Deletado com sucesso!");
	}
	
	@CrossOrigin
	@GetMapping("/targetuser")
	public ResponseEntity<List<Target>> responseEntity(){
		List<Target> target = null;
		target = targetService.getTargetInfo();
		return ResponseEntity.status(HttpStatus.OK).body(target);
	}

	@CrossOrigin
	@GetMapping("/microservice")
	public List<Target> getTargetToMicroservice() {
		List<Target> target = null;
		target = targetService.getTargetMicroservice();
		return target;
	}

	@CrossOrigin
	@PutMapping("/update/{idTarget}")
	public ResponseEntity<Target> updateTarget(@PathVariable long idTarget, @RequestBody TargetDTO dto) {
		Target target = new Target();
		target = targetService.updateTarget(idTarget, dto);
		return ResponseEntity.ok().body(target);
	}
}
