package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.MovementsDTO;
import br.com.youthquake.model.Movements;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.MovementsRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class MovementsService {
	
	@Autowired
	MovementsRepository movementsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	
	public Movements movementInclude(MovementsDTO dto) {
		Movements movements = new Movements();

		User u = (User)this.session.getAttribute(SESSION_USER);
		movements.setUser(userRepository.findFirstByIdUser(u.getIdUser()));
		movements.setValue(dto.getValue());
		movements.setType(dto.getType());
		movements.setReference(dto.getReference());
		return movementsRepository.save(movements);
	}
	
	
	public List<Movements> getMovementInfo(){
		User u = (User)this.session.getAttribute(SESSION_USER);
		return movementsRepository.GetInformationMovementsByIdUser(u.getIdUser());
	}

	public void deleteMovementById(long idMovement) {
		movementsRepository.deleteById(idMovement);
	}


	public Movements updateMovement(long idMovement, MovementsDTO dto) {
		Movements movement = movementsRepository.getOne(idMovement);
		movement.movementUpdateInformation(dto);
		return movementsRepository.save(movement);
	}

}
