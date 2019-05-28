package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.TargetRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class TargetService {

	@Autowired
	private TargetRepository targetRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void deleteTarget(TargetDTO dto) {
		 targetRepository.deleteById(dto.getIdTarget());
	}
	
	public Target targetInclude(TargetDTO dto) {
		Target target = new Target();
		
		User user = userRepository.findFirstByIdUser(dto.getUser());
		target.setUser(user);
		target.setName(dto.getName());
		target.setDescription(dto.getDescription());
		target.setDtStart(dto.getDtStart());
		target.setDtEnd(dto.getDtEnd());
		target.setValue(dto.getValue());
		target.setValueAccumulated(dto.getValueAccumulated());
		target.setPercentage(dto.getPercentage());
		
		return targetRepository.save(target);
	}
}
