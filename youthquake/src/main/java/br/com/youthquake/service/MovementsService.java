package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.repository.MovementsRepository;

@Service
public class MovementsService {

	@Autowired
	private MovementsRepository movementRepo;
	
	public void deleteMovementById(long idMovement){
		movementRepo.deleteById(idMovement);
	}
}
