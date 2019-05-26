package br.com.youthquake.service;

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
	
	public Movements movementInclude(MovementsDTO dto) {
		Movements movements = new Movements();
		
		User user = userRepository.findFirstByIdUser(dto.getUser());
		movements.setUser(user);
		movements.setValue(dto.getValue());
		movements.setType(dto.getType());
		movements.setReference(dto.getReference());
		return movementsRepository.save(movements);
	}
}
