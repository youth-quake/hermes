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
	
	public Movements movementInclude(long idUser, MovementsDTO dto) {
		Movements movements = new Movements();
		movements.setUser(userRepository.findFirstByIdUser(idUser));
		movements.setValue(dto.getValue());
		movements.setType(dto.getType());
		movements.setReference(dto.getReference());
		return movementsRepository.save(movements);
	}
	
	public Movements movementInitialInclude(long idUser, MovementsDTO dto){
		Movements movements = new Movements();
		movements.setUser(userRepository.findFirstByIdUser(idUser));
		movements.setValue(dto.getValue());
		movements.setType(dto.getType());
		return movementsRepository.save(movements);
	}
	
	public List<Movements> getMovementInfo(long idUser){
		User u = (User)this.session.getAttribute(SESSION_USER);
		return movementsRepository.GetInformationMovementsByIdUser(idUser);
	}

	public void deleteMovementById(long idMovement) {
		movementsRepository.deleteById(idMovement);
	}

	public Movements updateMovement(long idMovement, long idUser, MovementsDTO dto) {
		Movements movement = movementsRepository.getMovementsByIdAndUser(idUser, idMovement);
		movement.movementUpdateInformation(dto);
		return movementsRepository.save(movement);
	}


	public List<Movements> getMovementMicroservice(long idUser) {
		return movementsRepository.getMovementsMicroservice(idUser);
	}
}
