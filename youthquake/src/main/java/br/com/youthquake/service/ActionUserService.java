package br.com.youthquake.service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.ActionUserDTO;
import br.com.youthquake.model.ActionUser;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.ActionSystemRepository;
import br.com.youthquake.repository.ActionUserRepository;

@Service
public class ActionUserService {
	@Autowired
	ActionSystemRepository actionSystemRepository;

	@Autowired
	ActionUserRepository actionUserRepository;

	@Autowired
	HttpSession session;

	private static String SESSION_USER = "SessionUser";

	public ActionUser actionUserInclude(@Valid ActionUserDTO dto) {
		ActionUser actionUser = new ActionUser();

		User u = (User) this.session.getAttribute(SESSION_USER);

		actionUser.setUser(u);
		actionUser.setIdActionSystem(actionSystemRepository.findFirstByName(dto.getNameActionUser()));
		actionUser.setQuantity(dto.getQuantity());
		return actionUserRepository.save(actionUser);
	}
}
