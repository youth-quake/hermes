package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.ActionUserDTO;
import br.com.youthquake.model.ActionSystem;
import br.com.youthquake.model.ActionUser;
import br.com.youthquake.repository.ActionSystemRepository;
import br.com.youthquake.repository.ActionUserRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class ActionUserService {
	@Autowired
	ActionSystemRepository actionSystemRepository;

	@Autowired
	ActionUserRepository actionUserRepository;


	@Autowired
	private UserRepository userRepository;

	public ActionUser actionUserInclude(long idUser, ActionUserDTO dto) {
		
		ActionSystem actionSystem =  actionSystemRepository.findFirstByName(dto.getNameActionUser());
		ActionUser actionUser = actionUserRepository.findFirtsByUser_idUserAndIdActionSystem_idAction(idUser, actionSystem.getIdAction());
		
		Long quantity = actionUserRepository.getActionUserBiIdUserAndIdAction(idUser, actionSystem.getIdAction());
		
		if(actionUser != null && quantity > 0) {
			actionUser.setQuantity(dto.getQuantity() + actionUser.getQuantity());
			actionUser.setProgress((actionUser.getQuantity() * 100) / actionSystem.getNumberRequired());
			return actionUserRepository.save(actionUser);
		}
		actionUser = new ActionUser();		
		actionUser.setUser(userRepository.findFirstByIdUser(idUser));
		actionUser.setIdActionSystem(actionSystem);
		actionUser.setQuantity(dto.getQuantity());
		actionUser.setProgress((dto.getQuantity() * 100) / actionSystem.getNumberRequired());
		return actionUserRepository.save(actionUser);
	}
}
