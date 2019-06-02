package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	
	public void deleteTarget(TargetDTO dto) {
		 targetRepository.deleteById(dto.getIdTarget());
	HttpSession session;
	}	
	
	public void deleteTarget(long idTarget) {
		 targetRepository.deleteById(idTarget);
	}
	
	public List<Target> getTargetMicroservice(long idTarget){
		return targetRepository.getTargets(idTarget);
	}
	
	public Target updateTarget(long id, TargetDTO dto) {
		Target target = targetRepository.getOne(id);
		target.targetUpdateInformations(dto);
		return targetRepository.save(target);
	}
	
	public Target targetInclude(TargetDTO dto) {
		Target target = new Target();
		
		User u = (User)this.session.getAttribute(SESSION_USER);
		target.setUser(userRepository.findFirstByIdUser(u.getIdUser()));
		target.setName(dto.getName());
		target.setDescription(dto.getDescription());
		target.setDtStart(dto.getDtStart());
		target.setDtEnd(dto.getDtEnd());
		target.setValue(dto.getValue());
		target.setValueAccumulated(dto.getValueAccumulated());
		target.setPercentage(dto.getPercentage());
		
		return targetRepository.save(target);
	}

	public List<Target> getTargetInfo() {
		User u = (User)this.session.getAttribute(SESSION_USER);
		return targetRepository.GetInformationTargetByIdUser(u.getIdUser());
	}
}
