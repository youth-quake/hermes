package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.MovementsDTO;
import br.com.youthquake.model.Movements;
import br.com.youthquake.repository.MovementsRepository;

@Service
public class MovementsService {

	@Autowired
	private MovementsRepository movementRepo;
	
	public void deleteMovementById(long idMovement){
		movementRepo.deleteById(idMovement);
	}
	
	public Movements updateMovement(long idMovement, MovementsDTO dto){
		Movements movement = movementRepo.getOne(idMovement);
		movement.movementUpdateInformation(dto);
		return movementRepo.save(movement);
	}
}
